package com.attornatus.desafio.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa morador;
	
	private String logradouro;
	private Integer	numero;
	private String cidade;
	private Integer cep;
	private Boolean principal;
	
	public Endereco() {
	}

	public Endereco(Long id, Pessoa morador, String logradouro, Integer numero, String cidade, Integer cep, Boolean principal) {
		super();
		this.id = id;
		this.morador = morador;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
		setPrincipal(principal);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getMorador() {
		return morador;
	}

	public void setMorador(Pessoa morador) {
		this.morador = morador;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Boolean getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Boolean principal) {
		List<Endereco> enderecos = this.morador.getEnderecos();
		if (principal) {
			enderecos.stream().forEach((x) -> x.principal = false);
			this.principal = true;
		} else {
			this.principal = false;
		}
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
