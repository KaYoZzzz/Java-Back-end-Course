package com.azienda.view;

import com.azienda.model.Cellulare;
import com.azienda.model.DispositivoMultimediale;
import com.azienda.model.Televisore;

public class TestDispositivo {
	public static void main(String[] args) {
		Cellulare c = new Cellulare("Google", "Google Pixel 10 Pro", 800f, 48);
		Televisore t = new Televisore("Samsung", "OLED Q60", 1200f, 1000, 5);

		System.out.println("--- Test Cellulare ---");
		test(c);

		System.out.println("\n--- Test Televisore ---");
		test(t);
	}

	private static void test(DispositivoMultimediale d) {
		System.out.println("Marca: " + d.getMarca());
		System.out.println("Modello: " + d.getModello());
		System.out.println("Prezzo: " + d.getPrezzo() + "$");

		// Controllo se il dispositivo è un Televisore
		if (d instanceof Cellulare) {
			Cellulare cell = (Cellulare) d; // Casting esplicito
			System.out.println("Fotocamera: " + cell.getMegaPixelCamera() + " MP");
			System.out.println(cell.chiama());
			System.out.println(cell.rispondi());
		}
		// Controllo se il dispositivo è un Televisore
		else if (d instanceof Televisore) {
			Televisore tv = (Televisore) d; // Casting esplicito
			System.out.println("Canali totali: " + tv.getNumeroCanali());
			System.out.println("Canale attuale: " + tv.getCanaleSelezionato());
			tv.cambiaCanale(10);
			System.out.println("Nuovo canale selezionato: " + tv.getCanaleSelezionato());
		}
	}
}
