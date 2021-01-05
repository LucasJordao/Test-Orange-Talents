package com.lucas.testorangetalents.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.dto.ClienteDTO;
import com.lucas.testorangetalents.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	// Repository
	@Autowired
	private ClienteRepository repository;
	
	// Services
	@Autowired
	private BancoService bancoService;
	
	// Classes auxiliares
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	/*
	 * Método responsável por retornar uma lista de clientes cadastrados no banco de dados
	 */
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	/*
	 * Método responsável por salvar um cliente no banco de dados 
	 */
	public Cliente insert(Cliente obj){
		obj.setId(null);
		bancoService.update(obj.getBanco());
		return repository.save(obj);
	}
	
	public Cliente fromDTO(ClienteDTO objDTO) throws ParseException {
		Date nascimento = sdf.parse(objDTO.getNascimento());
		Random digito = new Random();
		Cliente obj = new Cliente();
		Banco banco = bancoService.findById(objDTO.getBanco());
		obj.setId(null);
		obj.setNome(obj.getNome());
		obj.setCpf(objDTO.getCpf());
		obj.setEmail(objDTO.getEmail());
		obj.setConta(generatedSequence());
		obj.setDigito(digito.nextInt(9 - 1) + 1);
		obj.setNascimento(nascimento);
		obj.setBanco(banco);
		
		banco.getClientes().addAll(Arrays.asList(obj));
		
		return obj;
	}
	
	public Integer generatedSequence() {
		Random code = new Random();
		return code.nextInt(10000000 - 1);
	}
}
