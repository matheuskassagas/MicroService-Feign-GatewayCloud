package com.devms.hrpayroll.servive;

import com.devms.hrpayroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Bob", 100.0, days);
    }
}
