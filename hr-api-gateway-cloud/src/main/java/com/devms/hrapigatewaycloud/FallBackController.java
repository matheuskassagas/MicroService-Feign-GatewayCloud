package com.devms.hrapigatewaycloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/workerFallBack")
    public Mono<String> workerFallBack(){
        return Mono.just("Worker is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/payRollFallBack")
    public Mono<String> payRollFallBack(){
        return Mono.just("Payment is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/userFallBack")
    public Mono<String> userFallBack(){
        return Mono.just("Payment is taking too long to respond or is down. Please try again later");
    }
}