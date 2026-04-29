package com.azienda.withAbstract.model;

public class Divisione extends RisultatoOperazione {

	@Override
	public int operate(int a, int b) {
		// TODO Auto-generated method stub
		if (b == 0) {
			System.out.println("Errore: Divisione per zero!");
			return 0;
		}
		return a / b;
	}

}
