package com.attornatus.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.attornatus.desafio.entities.Endereco;
import com.attornatus.desafio.entities.Pessoa;
import com.attornatus.desafio.repositories.EnderecoRepository;
import com.attornatus.desafio.repositories.PessoaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Pessoa p1 = new Pessoa(null, "Pedro", "01/01/2001");
		Pessoa p2 = new Pessoa(null, "João", "02/02/2002");
		
		Endereco e1 = new Endereco(null, p1, "rua UM", 11, "Cidade1", 11111111);
		Endereco e2 = new Endereco(null, p2, "rua DOIS", 22, "Cidade1", 22222222);
		Endereco e3 = new Endereco(null, p2, "rua TRÊS", 33, "Cidade2", 32222223);
			
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
	}
	
}
