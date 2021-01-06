package com.lucas.testorangetalents.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lucas.testorangetalents.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer id;
	@NotEmpty(message = "O campo nome não pode ser vazio")
	@Size(min = 6, max = 80, message = "O tamanho deve ser entre 6 e 80")
	private String nome;
	@NotEmpty(message = "O campo email não pode ser vazio")
	@Email(message = "Email inválido")
	private String email;
	@NotEmpty(message = "O campo cpf não pode ser vazio")
	private String cpf;
	@NotEmpty(message = "O campo data de nascimento não pode ser vazio")
	private String nascimento;
	@Min(value = 1, message = "O valor mínimo é 1")
	@NotNull(message = "O campo banco não pode ser vazio")
	private Integer banco;
	
	
	// Construtores
	public ClienteDTO() {
		
	}


	public ClienteDTO(Integer id, String nome, String email, String cpf, String nascimento, Integer banco) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.banco = banco;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getNascimento() {
		return nascimento;
	}


	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}


	public Integer getBanco() {
		return banco;
	}


	public void setBanco(Integer banco) {
		this.banco = banco;
	}
}
