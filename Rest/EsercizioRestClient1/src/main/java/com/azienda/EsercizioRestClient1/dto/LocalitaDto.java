package com.azienda.EsercizioRestClient1.dto;

public class LocalitaDto {

	private String nome;
	private Float temperatura;

	public LocalitaDto(String nome, Float temperatura) {
		super();
		this.nome = nome;
		this.temperatura = temperatura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "LocalitaDto [nome=" + nome + ", temperatura=" + temperatura + "]";
	}

}
