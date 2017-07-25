package edu.upm.midas.metamap.controller;
import edu.upm.midas.constants.Constants;
import edu.upm.midas.metamap.model.Concept;
import edu.upm.midas.metamap.model.Response;
import edu.upm.midas.metamap.model.receiver.ConfigReceiver;
import edu.upm.midas.metamap.model.receiver.TextReceiver;
import edu.upm.midas.metamap.service.impl.MetamapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gerardo on 04/07/2017.
 *
 * @author Gerardo Lagunes G. ${EMAIL}
 * @version ${<VERSION>}
 * @project metamap_rest
 * @className MetamapController
 * @see
 */
@RestController
@RequestMapping("/api")
public class MetamapController {

    @Autowired
    private MetamapService metamapService;

    @RequestMapping(path = { "/metamap" },
            method = RequestMethod.POST)
    public Response filter(@RequestBody @Valid TextReceiver textReceiver) throws Exception {
        Response response = new Response();
        response.setConceptList( metamapService.filter(textReceiver.getText()) );

        ConfigReceiver conf = new ConfigReceiver();
        conf.setSemanticTypes( Constants.SEMANTIC_TYPES_MAP );
        conf.setSources( Constants.SOURCES_MAP );

        response.setConfigReceiver( conf );
        return response;
    }

}
