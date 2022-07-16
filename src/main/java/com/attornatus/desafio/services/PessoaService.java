package com.attornatus.desafio.services;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.attornatus.desafio.dto.PessoaDTO;
import com.attornatus.desafio.entities.Pessoa;
import com.attornatus.desafio.repositories.PessoaRepository;
import com.attornatus.desafio.services.exceptions.DataBaseException;
import com.attornatus.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

//	public List<Pessoa> findAll() {
//		return repository.findAll();
//	}

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException error) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException error) {
			throw new DataBaseException(error.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public Pessoa update(Long id, Pessoa obj) throws ParseException {
		try {
			Pessoa entity = repository.getOne(id);
			updateSource(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException error) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateSource(Pessoa entity, Pessoa obj) throws ParseException {
		entity.setNome(obj.getNome());
		entity.setDataDeNascimento(obj.getDataDeNascimento().toString());

	}
	public List<PessoaDTO> findAll(){
		List<Pessoa> list = repository.findAll();
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}
}
