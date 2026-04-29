package com.azienda.model;

public class Differenza implements OperazioniAritmetiche {

	@Override
	public int operate(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public void printResult(int result) {
		// TODO Auto-generated method stub
		System.out.println("Il risultato è: " + result);
	}

}
