package com.attornatus.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.desafio.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
