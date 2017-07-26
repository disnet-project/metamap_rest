package edu.upm.midas.metamap.service.impl;

import edu.upm.midas.constants.Constants;
import edu.upm.midas.metamap.model.response.Text;
import edu.upm.midas.metamap.model.response.Response;
import edu.upm.midas.metamap.model.receiver.Request;
import edu.upm.midas.metamap.service.Metamap;
import edu.upm.midas.metamap.model.response.Concept;
import edu.upm.midas.utilsservice.ReplaceUTF8;
import gov.nih.nlm.nls.metamap.Ev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ReplaceUTF8 replaceUTF8;

    public Response filter(Request request) throws Exception{
        Response response = validate( request );
        List<Text> textList = new ArrayList<>();

        if (response.getValidationMesssage().equals(Constants.OK)){
            String sources = getSourceFormat( response.getConfiguration().getSources() );
            metamap.setupOptions(request.getConfiguration().getOptions() + " " + sources);
            metamap.setSemanticTypes( request.getConfiguration().getSemanticTypes() );

            for (edu.upm.midas.metamap.model.receiver.Text textReceiver: request.getTextList()) {
                String textNonAscii = replaceUTF8.replaceLooklike( textReceiver.getText() );

                if (!textNonAscii.isEmpty()){
                    Text text = new Text();
                    text.setId( textReceiver.getId() );

                    List<Concept> conceptList = new ArrayList<>();
                    for (Ev conceptEv : metamap.performNLP( textNonAscii ) ) {
                        Concept concept = new Concept();
                        concept.setCui( conceptEv.getConceptId() );
                        concept.setName( conceptEv.getConceptName() );
                        concept.setSemanticType( conceptEv.getSemanticTypes() );

                        conceptList.add( concept );
                    }// busqueda de conceptos con metamap
                    text.setConcepts( conceptList );
                    textList.add( text );
                }// validación del texto no vacío
            }// recorrido de textos enviados
            response.setTextList( textList );
        }

        return response;
    }


    /**
     * @param request
     * @return
     */
    public Response validate(Request request){
        Response response = new Response();

        boolean validSourceList = isAValidSourceList( request.getConfiguration().getSources() );
        boolean validSemanticTypeList = isAValidSemanticTypesList( request.getConfiguration().getSemanticTypes() );

        response.setConfiguration( request.getConfiguration() );
        if (validSourceList){
            response.setValidationMesssage( Constants.OK );
        }else{
            response.setValidationMesssage( Constants.RESPONSE_INVALID_SOURCES );
        }

        if (validSemanticTypeList){
            response.setValidationMesssage( Constants.OK );
        }else{
            response.setValidationMesssage( Constants.RESPONSE_SEMANTIC_TYPES );
        }

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
