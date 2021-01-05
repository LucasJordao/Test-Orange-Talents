package com.lucas.testorangetalents.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucas.testorangetalents.domains.Cliente;
import com.lucas.testorangetalents.dto.ClienteDTO;
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
	
	@PostMapping(value = "/")
	public ResponseEntity<Void> insert(@RequestBody ClienteDTO objDTO) throws ParseException{
		Cliente obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
