package com.belediye.bproject;

import com.belediye.bproject.repository.DebitRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
public class BprojectApplication implements CommandLineRunner {

	private final ObjectMapper mapper;
	private final DebitRepository debitRepository;


	/*@Bean
	public CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Debit debit=new Debit();
				debit.setDebitType(5);
				debit.setNationalId(10960105912L);
				debit.setDebitStatus(true);
				debit.setDebitAmount(1200);
				debit.setPaymentDeadline(LocalDateTime.now());
				debitRepository.save(debit);
			}
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(BprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String s = mapper.writeValueAsString(LocalDateTime.now());
		System.out.println(s);
	}
}
