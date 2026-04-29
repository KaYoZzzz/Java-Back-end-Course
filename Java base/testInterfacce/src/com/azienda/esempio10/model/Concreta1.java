package com.azienda.esempio10.model;

public class Concreta1 extends EsempioAstratta {

	@Override
	public void metodoAstratto() {
		// TODO Auto-generated method stub
		System.out.println("Concreta 1 - metodo astratto");
	}

	public void specifico1() {
		System.out.println("Concreta 1 - metodo specifico");
	}
}
