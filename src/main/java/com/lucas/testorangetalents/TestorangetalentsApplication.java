package com.lucas.testorangetalents;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.repositories.BancoRepository;

@SpringBootApplication
public class TestorangetalentsApplication implements CommandLineRunner{

	// Repositories
	@Autowired
	private BancoRepository bancoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TestorangetalentsApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception{
		
		Banco b1 = new Banco(null, "Zup Banco");
		Banco b2 = new Banco(null, "Orange Banco");
		
		bancoRepository.saveAll(Arrays.asList(b1, b2));
	}

}
