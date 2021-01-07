package com.lucas.testorangetalents.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.testorangetalents.domains.Banco;
import com.lucas.testorangetalents.services.BancoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/bancos")
public class BancoResource {
	
	// Services
	@Autowired
	private BancoService service;
	
	@ApiOperation(value="Busca todos Bancos")
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<Banco> bancos = service.findAll();
		
		return ResponseEntity.ok().body(bancos);
	}
	
}
