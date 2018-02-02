package edu.upm.midas.service;

import gov.nih.nlm.nls.metamap.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.io.IOException;
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
    @Value("${my.port}")
    private int port;
    @Value("${default_options}")
    private String default_options;
    @NotNull
    private List<String> semanticTypes;


    public Metamap() {}

    @PostConstruct
    public void setup() throws IOException {
        //oMmapi = new MetaMapApiImpl( host );
        System.out.println("METAMAP_HOST: " + host.trim() + ", METAMAP_PORT:" + port);
        oMmapi = new MetaMapApiImpl( host.trim(), port, 0 );
        //oMmapi = new MetaMapApiImpl( host.trim() );
        //setupOptions("-y -R SNOMEDCT_US");
        //TEST
        /*String s = "";
        System.out.println(s);
        String textNonAscii = replaceUTF8.replaceLooklike(s);
        System.out.println(textNonAscii);*/

    }

    public void setupOptions(String options) {
        oMmapi.setOptions(options);//default_options +
    }

    public void setSemanticTypes(List<String> semanticTypes) {
        this.semanticTypes = semanticTypes;
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
        List<Result> citationsList = oMmapi
                .processCitationsFromString( signs_symptoms_text );

        for (int j = 0; j < citationsList.size(); j++) {
            Result result = citationsList.get(j);
            for (Utterance utterance : result.getUtteranceList()) {
                for (PCM pcm : utterance.getPCMList()) {// Obtener elementos de expresiones metamap
                    for (Mapping map : pcm.getMappingList()) {// Obtiene la lista de terminos Metamap Evaluation (Ev)
                        for (Ev mapEv : map.getEvList()) {// Instancia de Metamap Evaluation (Ev)
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
     * Método módificado para que se acepten los semantic types que se envían a la API
     *
     * @param semanticTypes
     *            Receive the list of semantic types of the term.
     * @return Return true or false.
     */
    private boolean isAValidSemanticType(List<String> semanticTypes) {
        for (int i = 0; i < this.semanticTypes.size(); i++) {
            String validSemanticType = this.semanticTypes.get(i);
            if (semanticTypes.contains(validSemanticType)) {
                return true;
            }
        }
        return false;
    }



}
