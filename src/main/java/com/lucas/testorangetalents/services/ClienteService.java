package com.lucas.testorangetalents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	// Repository
	@Autowired
	private ClienteRepository repository;
	
	
	/*
	 * Método responsável por retornar uma lista de clientes cadastrados no banco de dados
	 */
	public List<Cliente> findAll(){
		return repository.findAll();
	}
}
