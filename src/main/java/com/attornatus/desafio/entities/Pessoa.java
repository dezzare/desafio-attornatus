package com.attornatus.desafio.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private Date dataDeNascimento;
	
	Pessoa(){
	}

	public Pessoa(Long id, String nome, String dataDeNascimento) throws ParseException {
		super();
		this.id = id;
		this.nome = nome;
		setDataDeNascimento(dataDeNascimento);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(dataDeNascimento);
		this.dataDeNascimento = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
	
	
}
