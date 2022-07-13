package com.attornatus.desafio.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Date dataDeNascimento;
	
	
	@OneToMany(mappedBy = "morador")
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa(){
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

	public List<Endereco> getEnderecos() {
		return enderecos;
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
