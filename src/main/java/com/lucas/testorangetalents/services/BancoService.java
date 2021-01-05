package com.lucas.testorangetalents.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.repositories.BancoRepository;
import com.lucas.testorangetalents.services.exceptions.ObjectNotFoundException;

@Service
public class BancoService {

	// Repositorys
	@Autowired
	private BancoRepository repository;
	
	
	/*
	 * 
	 * Método responsável por recuperar um bancod de acordo com seu id 
	 */
	public Banco findById(Integer id) {
		Optional<Banco> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id 
										+ ", Tipo: " + Banco.class.getName()));
	}
	
	/*
	 * Método responsável por retornar uma lista de bancos cadastrados no banco de dados
	 */
	public List<Banco> findAll(){
		return repository.findAll();
	}
	
	/*
	 * Método responsável por atualizar um banco no banco de dados
	 */
	public Banco update(Banco obj) {
		return repository.save(obj);
	}
}
