package com.devms.hrpayroll.feignclients;


import com.devms.hrpayroll.entity.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Interface com assinaturas das requisicoes
@Component //gerenciavel pelo spring
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
