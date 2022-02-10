package com.devms.hrworker;

import com.devms.hrworker.entity.Worker;
import com.devms.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
public class HrWorkerApplication implements CommandLineRunner {

	@Autowired
	private WorkerRepository workerRepository;

	public static void main(String[] args) {
			SpringApplication.run(HrWorkerApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Worker w1 = new Worker(null, "Bob", 200.0);
		Worker w2 = new Worker(null, "Maria", 300.0);
		Worker w3 = new Worker(null, "Alex", 250.0);

		workerRepository.saveAll(Arrays.asList(w1,w2,w3));
	}
}
