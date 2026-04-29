package com.azienda.view;

import com.azienda.model.Automobile;
import com.azienda.model.Fabbrica;
import com.azienda.model.Indirizzo;

public class ChiamanteAutomobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fabbrica fabbricaferrari = new Fabbrica("Ferrari", new Indirizzo("Italia", "Milano", "Via Berchet 2", 20121));
		System.out.println(fabbricaferrari.infoFabbrica());		
		System.out.println("\n\n");
		for (int i = 0; i < 5; i++) {
			fabbricaferrari.produciAuto();
			Automobile auto = new Automobile("F488", "Ferrari", "AB"+ String.format("%03d", i * 111) +"CD", 4500, fabbricaferrari);
			System.out.println(auto.infoAutomobile());
			System.out.println("\n\n");
			
		}
		

	    Fabbrica fabbricaMercedes = new Fabbrica("Mercedes", new Indirizzo("Germania", "Stoccarda", "Mercedesstraße 137", 70327));
	    System.out.println(fabbricaMercedes.infoFabbrica());		
	    System.out.println("\n\n");
	    for (int i = 0; i < 3; i++) {
	    	fabbricaMercedes.produciAuto();
	        String targa = "EF" + String.format("%03d", i * 111) + "GH";
	        Automobile auto = new Automobile("Modello S", "Mercedes", targa, 3000, fabbricaMercedes);
	        System.out.println(auto.infoAutomobile());
	        System.out.println("\n\n");
	        
	    }
	}

	
}
