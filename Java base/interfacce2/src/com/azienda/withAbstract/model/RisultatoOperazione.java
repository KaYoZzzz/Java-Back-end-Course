package com.azienda.withAbstract.model;

public abstract class RisultatoOperazione implements OperazioniAritmetiche {
	public void printResult(int a, int b) {
		int result = operate(a, b);
		System.out.println("Il risultato dell'operazione tra " + a + " e " + b + " è: " + result);
	}
}
