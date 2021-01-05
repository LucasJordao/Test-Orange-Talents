package com.lucas.testorangetalents.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.repositories.BancoRepository;

@Service
public class BancoService {

	// Repositorys
	@Autowired
	private BancoRepository repository;
	
	
	/*
	 * Método responsável por retornar uma lista de bancos cadastrados no banco de dados
	 */
	public List<Banco> findAll(){
		return repository.findAll();
	}
}