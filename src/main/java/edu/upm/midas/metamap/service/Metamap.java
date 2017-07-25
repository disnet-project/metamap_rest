package edu.upm.midas.metamap.service;

import edu.upm.midas.constants.Constants;
import gov.nih.nlm.nls.metamap.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerardo on 09/05/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project ExtractionInformationDiseasesWikipedia
 * @className MetamapService
 * @see
 */
@Component
public class Metamap implements NLPInterface {

    private MetaMapApi oMmapi;

    @Value("${my.host}")
    private String host;
    @Value("${default_options}")
    private String default_options;

    public Metamap() {}

    @PostConstruct
    public void setup() {
        oMmapi = new MetaMapApiImpl( host );
        setupOptions("-y -R SNOMEDCT_US");
    }

    public void setupOptions(String option) {
        oMmapi.setOptions(option);
    }

    /**
     * Method to process the UMLS terms loaded in a disease.
     *
     * @param signs_symptoms_text
     *            Receives the disease.
     * @throws Exception
     *             It can throws an exception.
     */
    public ArrayList<Ev> performNLP(String signs_symptoms_text)
            throws Exception {
        ArrayList<Ev> conceptsList = new ArrayList<Ev>();
        //System.out.println("HTML_A pasar a MetaMap: " + signs_symptoms_text);
        List<Result> citationsList = oMmapi
                .processCitationsFromString( signs_symptoms_text );

        for (int j = 0; j < citationsList.size(); j++) {
            Result result = citationsList.get(j);
            for (Utterance utterance : result.getUtteranceList()) {
                for (PCM pcm : utterance.getPCMList()) {
                    for (Mapping map : pcm.getMappingList()) {
                        for (Ev mapEv : map.getEvList()) {
                            if (isAValidSemanticType( mapEv.getSemanticTypes() )) {
                                conceptsList.add( mapEv );
                            }
                        }
                    }
                }
            }
        }

        return conceptsList;
    }

    /**
     * Method to check if contains a valid semantic type.
     *
     * @param semanticTypes
     *            Receive the list of semantic types of the term.
     * @return Return true or false.
     */
    private boolean isAValidSemanticType(List<String> semanticTypes) {
        for (int i = 0; i < Constants.SEMANTIC_TYPES.length; i++) {

            String validSemanticType = Constants.SEMANTIC_TYPES[i];

            if (semanticTypes.contains(validSemanticType)) {
                return true;
            }

        }
        return false;
    }


    /**
     * Método que regresa true si el source no se encuentra y false si se encuentra
     *
     * @param sourceId
     * @return
     */
    private boolean isSource(String sourceId){
        return Constants.SOURCES_MAP.get( sourceId ).isEmpty();
    }


    /**
     * Método que regresa true si el semantic_type no se encuentra y false si se encuentra
     *
     * @param semanticType
     * @return
     */
    private boolean isSemanticType(String semanticType){
        return Constants.SEMANTIC_TYPES_MAP.get( semanticType ).isEmpty();
    }


}
