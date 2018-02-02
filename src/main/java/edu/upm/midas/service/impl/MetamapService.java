package edu.upm.midas.service.impl;

import edu.upm.midas.authorization.token.service.TokenAuthorization;
import edu.upm.midas.common.util.Common;
import edu.upm.midas.common.util.ReplaceUTF8;
import edu.upm.midas.constants.Constants;
import edu.upm.midas.model.receiver.Request;
import edu.upm.midas.model.response.Concept;
import edu.upm.midas.model.response.Response;
import edu.upm.midas.model.response.Text;
import edu.upm.midas.service.Metamap;
import gov.nih.nlm.nls.metamap.Ev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerardo on 04/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project metamap_rest
 * @className MetamapService
 * @see
 */
@Service
public class MetamapService {

    @Autowired
    private Metamap metamap;
    @Autowired
    private TokenAuthorization tokenAuthorization;
    @Autowired
    private ReplaceUTF8 replaceUTF8;
    @Autowired
    private Common common;

    public Response filter(Request request, HttpServletRequest httpRequest, Device device) throws Exception{
        Response response = validate( request, httpRequest, device );
        List<Text> textList = new ArrayList<>();

/*
        if (response.isAuthorization()) {
*/
            if (response.getValidationMesssage().equals(Constants.OK)) {
                String sources = getSourceFormat(response.getConfiguration().getSources());
                if (!common.isEmpty(sources)){//Si existen sources agregará la configuración -R de metamap y la eliminará
                                              // de las opciones, si es que existe
                    sources = Constants.MM_OPTION_RESOURCE_LIST + " " + sources;
                    request.getConfiguration().getOptions().replace(Constants.MM_OPTION_RESOURCE_LIST, "");
                }
                metamap.setupOptions(request.getConfiguration().getOptions() + " " + sources);
                metamap.setSemanticTypes(request.getConfiguration().getSemanticTypes());

                int countText = 1;
                for (edu.upm.midas.model.receiver.Text textReceiver : request.getTextList()) {
                    System.out.println("("+countText+") Filter text: " + textReceiver.getId());//INFO
                    String textNonAscii = replaceUTF8.replaceLooklike(textReceiver.getText());
                    //System.out.println("Procesado:" + textNonAscii+ "--");
                    if (!textNonAscii.isEmpty()) {
                        Text text = new Text();
                        text.setId(textReceiver.getId());

                        List<Concept> conceptList = new ArrayList<>();
                        for (Ev conceptEv : metamap.performNLP(textNonAscii)) {
                            Concept concept = new Concept();
                            concept.setCui(conceptEv.getConceptId());
                            concept.setName(conceptEv.getConceptName());
                            concept.setSemanticTypes(conceptEv.getSemanticTypes());
                            concept.setMatchedWords(conceptEv.getMatchedWords());
                            concept.setPositionalInfo(conceptEv.getPositionalInfo().toString());
                            //System.out.println("getMatchedWords: "+conceptEv.getMatchedWords().toString());//OK
                            //System.out.println("getPositionalInfo: "+conceptEv.getPositionalInfo().toString());//OK
                            //System.out.println("getMatchMapList: "+conceptEv.getMatchMapList().toString());//NO
                            //System.out.println("getPreferredName: "+conceptEv.getPreferredName());//OK, NO porque es el nombre del termino
                            //System.out.println("getTerm: "+conceptEv.getTerm());//NO
                            //System.out.println("getPruningStatus: "+conceptEv.getPruningStatus());//NO
                            //System.out.println("getNegationStatus: "+conceptEv.getNegationStatus());//NO
                            //System.out.println("toString: "+conceptEv.toString());//NO
                            System.out.println( "   Concept found in the text..." + concept.toString() );

                            conceptList.add(concept);
                        }// busqueda de conceptos con metamap
                        if (conceptList.size() <= 0) System.out.println( "   Concept not found in the text...");
                        text.setConcepts(conceptList);
                        textList.add(text);
                    }// validación del texto no vacío
                    countText++;
                }// recorrido de textos enviados
                response.setTextList(textList);
            }
/*
        }
*/

        return response;
    }


    /**
     * @param request
     * @return
     */
    public Response validate(Request request, HttpServletRequest httpRequest, Device device){
        Response response = new Response();
        //Validación de autorización para operar con esta api
        //NO necesita ser autorizada, porque es para uso interno, no público
        //Response response = tokenAuthorization.validateService(request.getToken(), httpRequest.getQueryString(), httpRequest.getRequestURL().toString(), device);

/*
        if (response.isAuthorization()) {
*/

            boolean validSourceList = isAValidSourceList(request.getConfiguration().getSources());
            boolean validSemanticTypeList = isAValidSemanticTypesList(request.getConfiguration().getSemanticTypes());

            response.setConfiguration(request.getConfiguration());
            if (validSourceList) {
                response.setValidationMesssage(Constants.OK);
            } else {
                response.setValidationMesssage(Constants.RESPONSE_INVALID_SOURCES);
            }

            if (validSemanticTypeList) {
                response.setValidationMesssage(Constants.OK);
            } else {
                response.setValidationMesssage(Constants.RESPONSE_SEMANTIC_TYPES);
            }
/*
        }
*/

        return response;
    }


    /**
     * @param sourceList
     * @return
     */
    public String getSourceFormat(List<String> sourceList){
        String sources = "";
        for(int i=0;i<sourceList.size();i++){
            if (i == (sourceList.size()-1))
                sources += sourceList.get(i);
            else
                sources += sourceList.get(i) + ",";
        }
        return sources;
    }


    /**
     * Método que regresa true si el source no se encuentra y false si se encuentra
     *
     * @param sources
     * @return
     */
    public boolean isAValidSourceList(List<String> sources){
        boolean valid = false;
        for (String source: sources) {
            valid = !Constants.SOURCES_MAP.get( source ).isEmpty();
        }
        return valid;
    }


    /**
     * Método que regresa true si el semantic_type no se encuentra y false si se encuentra
     *
     * @param semanticTypes
     * @return
     */
    public boolean isAValidSemanticTypesList(List<String> semanticTypes){
        boolean valid = false;
        for (String semanticType: semanticTypes) {
            valid = !Constants.SEMANTIC_TYPES_MAP.get( semanticType ).isEmpty();
        }
        return valid;
    }


}
