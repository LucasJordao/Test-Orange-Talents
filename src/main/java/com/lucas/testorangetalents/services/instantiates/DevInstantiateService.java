package com.lucas.testorangetalents.services.instantiates;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.repositories.BancoRepository;

@Service
public class DevInstantiateService {
	
	@Autowired
	private BancoRepository bancoRepository;
	
	
	public void instantiate() {
		Banco b1 = new Banco(null, "Zup Banco");
		Banco b2 = new Banco(null, "Orange Banco");
		
		bancoRepository.saveAll(Arrays.asList(b1,b2));
	}
}
