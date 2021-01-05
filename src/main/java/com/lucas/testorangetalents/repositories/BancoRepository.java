package com.lucas.testorangetalents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.testorangetalents.domains.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer> {
	
}
