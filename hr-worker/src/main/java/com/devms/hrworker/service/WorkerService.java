package com.devms.hrworker.service;

import com.devms.hrworker.entity.Worker;
import com.devms.hrworker.repository.WorkerRepository;
import com.devms.hrworker.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository repository;

    public Worker findById(Long id) throws Exception{
        Optional<Worker> worker = repository.findById(id);
        return worker.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Worker> findAll(){
        return repository.findAll().stream().map(worker -> new Worker(worker.getId(), worker.getName(), worker.getDailyIncome())).collect(Collectors.toList());
    }
}
