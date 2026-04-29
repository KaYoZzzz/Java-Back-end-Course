package com.azienda.esempio10.model;

public class Concreta2 extends EsempioAstratta {

	@Override
	public void metodoAstratto() {
		// TODO Auto-generated method stub
		System.out.println("Concreta 2 - metodo astratto");
	}

	public void specifico2() {
		System.out.println("Concreta 2 - metodo specifico");
	}

	@Override
	public void metodoConcreto() {
		// TODO Auto-generated method stub
		System.out.println("Concreta 2 - metodo concreto");
	}
}
