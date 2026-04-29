package com.azienda.esercizioJPA2.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Banca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToMany(mappedBy = "banca")
	private List<Conto> conti = new ArrayList<>();

	public Banca() {
		super();
	}

	public Banca(String nome, List<Conto> conti) {
		super();
		this.nome = nome;
		this.conti = conti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conto> getConti() {
		return conti;
	}

	public void setConti(List<Conto> conti) {
		this.conti = conti;
	}

	@Override
	public String toString() {
		return "Banca [id=" + id + ", nome=" + nome + ", conti=" + conti + "]";
	}

}
