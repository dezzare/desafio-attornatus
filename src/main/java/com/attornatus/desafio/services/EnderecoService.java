package com.attornatus.desafio.services;

import java.text.ParseException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.desafio.dto.EnderecoDTO;
import com.attornatus.desafio.entities.Endereco;
import com.attornatus.desafio.entities.Pessoa;
import com.attornatus.desafio.repositories.EnderecoRepository;
import com.attornatus.desafio.services.exceptions.DataBaseException;
import com.attornatus.desafio.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository repository;

  // public List<Endereco> findAll() {
  // return repository.findAll();
  // }
  //
  public Endereco findById(Long id) {
    Optional<Endereco> obj = repository.findById(id);
    return obj.get();
  }

  // public Endereco insert(Endereco obj) {
  //
  // return repository.save(obj);
  // }

  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException error) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException error) {
      throw new DataBaseException(error.getMessage());
    }
  }


  public Endereco update(Long id, EnderecoDTO objDTO) throws ParseException {
    Long moradorId = objDTO.getMorador();
    Endereco novoObj = new Endereco(
        objDTO.getId(),
        objDTO.getLogradouro(),
        objDTO.getNumero(),
        objDTO.getCidade(),
        objDTO.getCep(),
        objDTO.getPrincipal(),
        new Pessoa(moradorId, null, null));
  

    try {
      @SuppressWarnings("deprecation")
      Endereco entity = repository.getOne(id);
      updateSource(entity, novoObj);
      return repository.save(entity);
    } catch (EntityNotFoundException error) {
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateSource(Endereco entity, Endereco obj) throws ParseException {

    entity.setMorador(obj.getMorador());
    entity.setLogradouro(obj.getLogradouro());
    entity.setNumero(obj.getNumero());
    entity.setCidade(obj.getCidade());
    entity.setCep(obj.getCep());
    entity.setPrincipal(obj.getPrincipal());
  }

  @Transactional(readOnly = true)
  public Page<EnderecoDTO> findAll(Pageable pageable) {
    Page<Endereco> page = repository.findAll(pageable);
    return page.map(x -> new EnderecoDTO(x));
  }

  @Transactional
  public EnderecoDTO insert(EnderecoDTO dto) {
    Endereco entity = new Endereco();
    entity.setMorador(new Pessoa(dto.getMorador(), null, null));
    entity.setLogradouro(dto.getLogradouro());
    entity.setNumero(dto.getNumero());
    entity.setCidade(dto.getCidade());
    entity.setCep(dto.getCep());
    entity.setPrincipal(dto.getPrincipal());

    entity = repository.save(entity);

    return new EnderecoDTO(entity);
  }

}
