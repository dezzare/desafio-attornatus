package com.attornatus.desafio.resources;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.desafio.entities.Pessoa;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@GetMapping
	public ResponseEntity<Pessoa> findAll() throws ParseException{
		Pessoa p = new Pessoa(1L, "Pedro", "01/01/2001");
		return ResponseEntity.ok().body(p);
		
	}
}
