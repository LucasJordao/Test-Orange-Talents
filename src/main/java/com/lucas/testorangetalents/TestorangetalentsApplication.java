package com.lucas.testorangetalents;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.repositories.BancoRepository;

@Configuration
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
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

}
