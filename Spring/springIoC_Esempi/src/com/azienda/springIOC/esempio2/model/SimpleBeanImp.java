package com.azienda.springIOC.esempio2.model;

import org.springframework.stereotype.Component;

@Component
public class SimpleBeanImp {
	private String nome;

	public SimpleBeanImp() {
		super();
		System.out.println("Costruttore vuoto");
	}

	public SimpleBeanImp(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "SimpleBeanImp [nome=" + nome + "]";
	}

}
