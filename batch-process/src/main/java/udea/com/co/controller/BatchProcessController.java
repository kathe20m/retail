package udea.com.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.com.co.infrastructure.Producer;
import udea.com.co.model.Client;
import udea.com.co.model.Refund;
import udea.com.co.model.Sale;

@RestController
public class BatchProcessController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/batchprocess/sale/send",
            method = RequestMethod.POST)
    public ResponseEntity<Sale> sendSale(@RequestBody Sale sale){
        producer.publishAsyncSale(sale);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/batchprocess/client/send",
            method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Client> sendClient(@RequestBody Client client){
        producer.publishAsyncClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/batchprocess/refund/send",
            method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Refund> sendRefund(@RequestBody Refund refund){
        producer.publishAsyncRefund(refund);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
