package com.attornatus.desafio.controllers;

import java.net.URI;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.attornatus.desafio.dto.EnderecoDTO;
import com.attornatus.desafio.entities.Endereco;
import com.attornatus.desafio.services.EnderecoService;


@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
//	@GetMapping
//	public ResponseEntity<List<Endereco>> findAll(){
//		List<Endereco> list = service.findAll();
//		return ResponseEntity.ok().body(list);
//	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Long id) {
		Endereco obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}	

//	@PostMapping(value = "/{id}")
//	public ResponseEntity<Endereco> insert(@PathVariable Long id, @RequestBody Endereco body){
//		Pessoa pessoa = pService.findById(id);
//		Endereco address = new Endereco( null, body.getLogradouro(), body.getNumero(), body.getCidade(),
//				body.getCep(),
//				body.getPrincipal(),
//				pessoa
//				);
//		address.setMorador(pessoa);
//		body = service.insert(address, id);
//				
//		URI uri = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(body.getId())
//				.toUri();
//		return ResponseEntity.created(uri).body(body);
//		
//	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody EnderecoDTO objDTO) throws ParseException{
		Endereco obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<Page<EnderecoDTO>> findAll(Pageable pageable) {
		PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
		Page<EnderecoDTO> list = service.findAll(pageRequest);		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
}
