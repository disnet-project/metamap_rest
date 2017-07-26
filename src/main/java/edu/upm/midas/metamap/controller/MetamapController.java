package edu.upm.midas.metamap.controller;
import edu.upm.midas.metamap.model.response.Response;
import edu.upm.midas.metamap.model.receiver.Request;
import edu.upm.midas.metamap.service.impl.MetamapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Response filter(@RequestBody @Valid Request request) throws Exception {
        return metamapService.filter( request );
    }

}
