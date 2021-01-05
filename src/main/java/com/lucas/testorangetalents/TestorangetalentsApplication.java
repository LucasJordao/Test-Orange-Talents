package com.lucas.testorangetalents;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.repositories.BancoRepository;
import com.lucas.testorangetalents.repositories.ClienteRepository;

@SpringBootApplication
public class TestorangetalentsApplication implements CommandLineRunner{

	// Repositories
	@Autowired
	private BancoRepository bancoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestorangetalentsApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Banco b1 = new Banco(null, "Zup Banco");
		Banco b2 = new Banco(null, "Orange Banco");
		
		Cliente c1 = new Cliente(null, "Lucas William Silva Jordão", "lucas@hotmail.com", "111.111.111-11", sdf.parse("12/11/2001"), 1111111, 1, b1);
		Cliente c2 = new Cliente(null, "Marcos da Silva Albuquerque", "marcos@hotmail.com", "222.222.222-22", sdf.parse("23/10/2000"), 3333333, 3, b2);
		Cliente c3 = new Cliente(null, "Maria Caroline da Silva", "maria@hotmail.com", "333.333.333-33", sdf.parse("22/03/1998"), 4444444, 4, b2);
		
		b1.getClientes().addAll(Arrays.asList(c1));
		b2.getClientes().addAll(Arrays.asList(c2, c3));
		
		bancoRepository.saveAll(Arrays.asList(b1, b2));
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
	}

}
