package com.azienda.view;

import com.azienda.model.Bottiglia;
import com.azienda.utility.Costants;

public class UsoBottiglia {
	public static void main(String[] args) {
		Bottiglia bottiglia1 = new Bottiglia(
				Costants.CONTENUTO_ACQUA,
				Costants.MATERIALE_PLASTICA,
				2.0f,
				0f);
		boolean check = bottiglia1.aggiungi(10f);
		checkCap(check);
		check = bottiglia1.aggiungi(1f);
		checkCap(check);
		System.out.println(bottiglia1.stampaBottiglia());
		
		Bottiglia bottiglia2 = new Bottiglia(
				Costants.CONTENUTO_VINO,
				Costants.MATERIALE_VETRO,
				1.33f,
				0f);
		
		check = bottiglia2.aggiungi(10f);
		checkCap(check);
		check = bottiglia2.aggiungi(1f);
		checkCap(check);
		System.out.println(bottiglia2.stampaBottiglia());
		
		
	}
	
	static void checkCap(boolean check) {
		if(check ==true) {
			System.out.println("liquido aggiunto");
		} else {
			System.out.println("stai aggiungiendo troppo liquido");
		}
		
	}
}
