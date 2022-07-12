package com.attornatus.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attornatus.desafio.entities.Pessoa;
import com.attornatus.desafio.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(null, "Pedro", "01/01/2001");
		Pessoa p2 = new Pessoa(null, "João", "02/02/2002");
	
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	}
	
}
