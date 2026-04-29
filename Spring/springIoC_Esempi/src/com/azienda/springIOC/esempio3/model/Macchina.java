package com.azienda.springIOC.esempio3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("mac")
public class Macchina {
	private Integer id;
	private String modello;
	private Persona proprietario;

	public Macchina() {
		super();
	}

	@Autowired
	public Macchina(@Value("2") Integer id, @Value("modelloX") String modello,
			@Qualifier("persona") Persona proprietario) {
		super();
		this.id = id;
		this.modello = modello;
		this.proprietario = proprietario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public Persona getProprietario() {
		return proprietario;
	}

	public void setProprietario(Persona proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Macchina [id=" + id + ", modello=" + modello + ", proprietario=" + proprietario + "]";
	}

}
