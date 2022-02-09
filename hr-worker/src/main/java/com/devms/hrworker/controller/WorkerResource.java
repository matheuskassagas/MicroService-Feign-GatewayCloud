package com.devms.hrworker.controller;

import com.devms.hrworker.entity.Worker;
import com.devms.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger Logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env; // possui as informaçoes do contexto da aplicação

    @Autowired
    private WorkerRepository workerRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            Thread.sleep(3000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //imprime no logg o numero da porta que esta rodando
        Logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker obj = workerRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
}
