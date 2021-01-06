package com.lucas.testorangetalents.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.dto.ClienteDTO;
import com.lucas.testorangetalents.repositories.ClienteRepository;
import com.lucas.testorangetalents.resources.exception.FieldMessage;
import com.lucas.testorangetalents.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteDTO>{
	
	@Autowired
	private ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
		
	}
	
	
	@Override
	public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(!BR.isValidCpf(objDTO.getCpf())) {
			list.add(new FieldMessage("Cpf", "CPF Inválido"));
		}
		
		if(!BR.isValidDate(objDTO.getNascimento())) {
			list.add(new FieldMessage("nascimento", "Data de Nascimento inválida"));
		}
    	
		Cliente cliente = repo.findByEmail(objDTO.getEmail());
		Cliente clienteCpf = repo.findByCpf(objDTO.getCpf());
		
		if(cliente != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		if(clienteCpf != null) {
			list.add(new FieldMessage("cpf", "CPF já existente"));
		}
		for(FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getCampo())
											.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
}
