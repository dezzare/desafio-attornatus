package com.attornatus.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.desafio.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
