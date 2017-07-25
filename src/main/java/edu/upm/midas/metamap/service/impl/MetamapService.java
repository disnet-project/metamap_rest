package edu.upm.midas.metamap.service.impl;

import edu.upm.midas.metamap.model.receiver.ConfigReceiver;
import edu.upm.midas.metamap.service.Metamap;
import edu.upm.midas.metamap.model.Concept;
import edu.upm.midas.utilsservice.ReplaceUTF8;
import gov.nih.nlm.nls.metamap.Ev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public List<Concept> filter(String text) throws Exception{

        List<Concept> conceptList = new ArrayList<>();
        String textNonAscii = replaceUTF8.replaceLooklike( text );
        //metamap.setupOptions("-y -R SNOMEDCT_US");

        if (!textNonAscii.isEmpty()){
            for (Ev conceptEv : metamap.performNLP( textNonAscii ) ) {
                Concept concept = new Concept();
                concept.setCui( conceptEv.getConceptId() );
                concept.setName( conceptEv.getConceptName() );
                concept.setSemanticType( conceptEv.getSemanticTypes() );

                conceptList.add( concept );
            }// busqueda de conceptos con metamap

        }// validación del texto no vacío

        return conceptList;

    }

}
