package com.lucas.testorangetalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.testorangetalents.domains.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
	
	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
	
}
