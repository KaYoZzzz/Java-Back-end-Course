package com.azienda.esempio11.model;

//in una classe astratta, non ho l'obbligo di implementare tutti i metodi della interfaccia
public abstract class AbstractServiceProvider implements ServiceProvider {
	@Override
	public void servizio1() {
		// TODO Auto-generated method stub
		System.out.println("implementazione comune servizio 1");
	}

	@Override
	public void servizio2() {
		// TODO Auto-generated method stub
		System.out.println("implementazione comune servizio 2");
	}
}
