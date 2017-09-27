package edu.upm.midas.controller;
import edu.upm.midas.model.response.Response;
import edu.upm.midas.model.receiver.Request;
import edu.upm.midas.service.impl.MetamapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/metamap/api")
public class MetamapController {

    @Autowired
    private MetamapService metamapService;

    @RequestMapping(path = { "/concepts-found" },
            method = RequestMethod.POST)
    public Response filter(@RequestBody @Valid Request request, HttpServletRequest httpRequest, Device device) throws Exception {
        return metamapService.filter( request, httpRequest, device );
    }

}
