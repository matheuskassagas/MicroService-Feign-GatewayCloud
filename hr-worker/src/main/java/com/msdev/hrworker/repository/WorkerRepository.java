package com.msdev.hrworker.repository;


import com.msdev.hrworker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository <Worker, Long> {
}
