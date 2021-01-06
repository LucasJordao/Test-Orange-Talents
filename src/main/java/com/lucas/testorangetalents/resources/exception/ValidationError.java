package com.lucas.testorangetalents.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	// Atributos
	private List<FieldMessage> erros = new ArrayList<>();
	
	// Construtores
	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		// TODO Auto-generated constructor stub
	}
	
	// Getters e Setters
	public List<FieldMessage> getLista() {
		return erros;
	}

	public void addError(String campo, String mensagem) {
		erros.add(new FieldMessage(campo, mensagem));
	}
	
	
}
