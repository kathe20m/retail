package udea.com.co.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import udea.com.co.model.Client;
import udea.com.co.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @ApiOperation(value = "Gets unique client", response = Client.class)
    @RequestMapping(method = RequestMethod.GET, value = "/client/getclient")
    @ResponseBody
    public Client getClient(@RequestParam String clientIdentification) {
        return service.getClient(clientIdentification);
    }
}
