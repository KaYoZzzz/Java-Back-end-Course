package com.azienda.view;

import com.azienda.model.Bambino;
import com.azienda.model.Persona;

public class ChiamantePersona {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Persona p = new Persona("Paolo_" + (i + 1), "Bianchi", 155.6f);
			System.out.println(p.info() + "\n");
		}

		for (int i = 0; i < 10; i++) {
			Bambino b = new Bambino("Mario_" + (i + 1), "Bianchi", 100.6f);
			System.out.println(b.info() + "\n");
		}

		System.out.println("Numero persone: " + Persona.getContatore());
		System.out.println("Numero bambini: " + Bambino.getContatoreBambino());
	}
}
