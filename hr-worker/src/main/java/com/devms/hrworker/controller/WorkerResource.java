package com.devms.hrworker.controller;

import com.devms.hrworker.entity.Worker;
import com.devms.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Worker obj = workerRepository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
}
