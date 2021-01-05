package com.lucas.testorangetalents.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	// Services
	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "/")
	public ResponseEntity<?> findAll(){
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
}
