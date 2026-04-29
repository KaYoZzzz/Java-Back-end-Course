package com.azienda.esempio10.model;

public abstract class EsempioAstratta {
	public abstract void metodoAstratto();

	public void metodoConcreto() {
		System.out.println("Astratta - metodo concreto");
	}
}
