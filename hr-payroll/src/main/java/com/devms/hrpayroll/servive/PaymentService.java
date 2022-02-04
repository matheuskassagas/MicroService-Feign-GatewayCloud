package com.devms.hrpayroll.servive;

import com.devms.hrpayroll.entity.Payment;
import com.devms.hrpayroll.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);
        Worker worker = restTemplate.getForEntity(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
