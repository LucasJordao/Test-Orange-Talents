package com.lucas.testorangetalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.testorangetalents.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
