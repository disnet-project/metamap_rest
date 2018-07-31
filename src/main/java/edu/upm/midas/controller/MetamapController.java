package edu.upm.midas.controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.upm.midas.common.util.Common;
import edu.upm.midas.common.util.TimeProvider;
import edu.upm.midas.model.receiver.Request;
import edu.upm.midas.model.response.Response;
import edu.upm.midas.service.impl.MetamapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("${my.service.rest.request.mapping.general.url}")
public class MetamapController {

    @Autowired
    private MetamapService metamapService;
    @Autowired
    private Common common;
    @Autowired
    private TimeProvider timeProvider;

    @RequestMapping(path =  {  "${my.service.rest.request.mapping.filter.path}" },
            method = RequestMethod.POST)
    public Response filter(@RequestBody @Valid Request request, HttpServletRequest httpRequest, Device device) throws Exception {
        System.out.println("Start the service...");
        return metamapService.filter( request, httpRequest, device );
    }

    @RequestMapping(path =  {  "${my.service.rest.request.mapping.filter.json.path}" },
            method = RequestMethod.POST)
    public Response filterJSON(@RequestBody @Valid Request request, HttpServletRequest httpRequest, Device device) throws Exception {
        Response response = metamapService.filter( request, httpRequest, device );
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        ProcessedText processedText = new ProcessedText();
//        processedText.setTexts(response.getTextList());
        common.writeJSONFile(gson.toJson(response), request.getSnapshot(), request.getSource());
        return response;
    }


}
