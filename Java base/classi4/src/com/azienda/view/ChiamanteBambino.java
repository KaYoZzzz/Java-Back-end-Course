package com.azienda.view;

import com.azienda.model.Bambino;

public class ChiamanteBambino {
	public static void main(String[] args) {
		Bambino bambino = new Bambino("Carlo", "Rossi", 110.5f);
		bambino.cresce(9.5f);
		System.out.println(bambino.infoBambino());
		Bambino bambino2 = new Bambino("Gianni", "Verdi", 98.2f);
		bambino2.cresce(0.8f);
		System.out.println(bambino2.infoBambino());
		
		for(int i=0; i<10; i++) {
			Bambino bambini = new Bambino("nome_" + i, "cognome_" + i, 100f);
			bambini.cresce(10f);
			System.out.println(bambini.infoBambino());
		}
		
		
		System.out.println(Bambino.getContatore());
		
	}
}
