package com.lucas.testorangetalents.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Atributos
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String nascimento;
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
