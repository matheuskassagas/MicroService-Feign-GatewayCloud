package com.devms.hrpayroll.controller;


import com.devms.hrpayroll.entity.Payment;
import com.devms.hrpayroll.servive.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @RequestMapping(value = "/{workerId}/days/{days}", method = RequestMethod.GET)
    public ResponseEntity<?> getPayment (@PathVariable Long workerId, @PathVariable Integer days){
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<?> getPaymentAlternative (Long workerId, Integer days){
        Payment payment = new Payment("Brann", 400.00, days);
        return ResponseEntity.ok(payment);
    }
}
