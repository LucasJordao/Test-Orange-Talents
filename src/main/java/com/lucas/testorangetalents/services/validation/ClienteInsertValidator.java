package com.lucas.testorangetalents.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lucas.testorangetalents.dto.ClienteDTO;
import com.lucas.testorangetalents.resources.exception.FieldMessage;
import com.lucas.testorangetalents.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteDTO>{
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
    	
		
		for(FieldMessage e: list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getCampo())
											.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
}
