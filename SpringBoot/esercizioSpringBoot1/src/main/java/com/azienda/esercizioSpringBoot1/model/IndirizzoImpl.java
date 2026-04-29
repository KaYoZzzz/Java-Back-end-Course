package com.azienda.esercizioSpringBoot1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IndirizzoImpl implements Indirizzo {
	@Autowired

	private @Value("Roma") String comune;
	private @Value("Via Colombo") String viaPiazza;
	private @Value("1") Integer civico;

	@Autowired
	public IndirizzoImpl() {

	}

	public IndirizzoImpl(String comune, String viaPiazza, Integer civico) {
		this.comune = comune;
		this.viaPiazza = viaPiazza;
		this.civico = civico;
	}

	@Override
	public String getComune() {
		return comune;
	}

	@Override
	public void setComune(String comune) {
		this.comune = comune;
	}

	@Override
	public String getViaPiazza() {
		return viaPiazza;
	}

	@Override
	public void setViaPiazza(String viaPiazza) {
		this.viaPiazza = viaPiazza;
	}

	@Override
	public Integer getCivico() {
		return civico;
	}

	@Override
	public void setCivico(Integer civico) {
		this.civico = civico;
	}

	@Override
	public String toString() {
		return comune + ", " + viaPiazza + ", " + civico;
	}

}