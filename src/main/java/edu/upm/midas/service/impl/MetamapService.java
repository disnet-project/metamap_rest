package edu.upm.midas.service.impl;

import edu.upm.midas.authorization.token.service.TokenAuthorization;
import edu.upm.midas.common.util.ReplaceUTF8;
import edu.upm.midas.constants.Constants;
import edu.upm.midas.model.response.Text;
import edu.upm.midas.model.response.Response;
import edu.upm.midas.model.receiver.Request;
import edu.upm.midas.model.response.Concept;
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

    public Response filter(Request request, HttpServletRequest httpRequest, Device device) throws Exception{
        Response response = validate( request, httpRequest, device );
        List<Text> textList = new ArrayList<>();

/*
        if (response.isAuthorization()) {
*/
            if (response.getValidationMesssage().equals(Constants.OK)) {
                String sources = getSourceFormat(response.getConfiguration().getSources());
                metamap.setupOptions(request.getConfiguration().getOptions() + " " + sources);
                metamap.setSemanticTypes(request.getConfiguration().getSemanticTypes());

                for (edu.upm.midas.model.receiver.Text textReceiver : request.getTextList()) {
                    String textNonAscii = replaceUTF8.replaceLooklike(textReceiver.getText());

                    if (!textNonAscii.isEmpty()) {
                        Text text = new Text();
                        text.setId(textReceiver.getId());

                        List<Concept> conceptList = new ArrayList<>();
                        for (Ev conceptEv : metamap.performNLP(textNonAscii)) {
                            Concept concept = new Concept();
                            concept.setCui(conceptEv.getConceptId());
                            concept.setName(conceptEv.getConceptName());
                            concept.setSemanticTypes(conceptEv.getSemanticTypes());

                            conceptList.add(concept);
                        }// busqueda de conceptos con metamap
                        text.setConcepts(conceptList);
                        textList.add(text);
                    }// validación del texto no vacío
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
