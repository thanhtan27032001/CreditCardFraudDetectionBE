package com.example.CreditCardFraudDetectionBE.controller;

import com.example.CreditCardFraudDetectionBE.model.ResponseObject;
import com.example.CreditCardFraudDetectionBE.model.Transaction;
import com.example.CreditCardFraudDetectionBE.model.Transaction2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/v1/pay")
public class PayController {
    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("")
    public String pay(@RequestBody Transaction transaction) {
        Integer result = restTemplate.postForObject("http://127.0.0.1:5000/predict", transaction, Integer.class);
        return result.toString();
    }

//    @PostMapping("model2")
//    public String pay2(@RequestBody Transaction2 transaction) {
//        Integer result = restTemplate.postForObject("http://127.0.0.1:5000/predict2", transaction, Integer.class);
//        return result.toString();
//    }

    @PostMapping("model2")
    public ResponseEntity<ResponseObject> pay2(@RequestBody Transaction2 transaction){
        Integer result = restTemplate.postForObject("http://127.0.0.1:5000/predict2", transaction, Integer.class);
        if (result == 0) {
            return ResponseEntity.ok(new ResponseObject("200 OK", "Transaction success", null));
        }
        if (result == 1) {
            return ResponseEntity
                    .status(HttpStatus.valueOf(423))
                    .body(new ResponseObject("423 Bad Request", "Fraud detected!", null));
        }
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(null);
    }
}
