package com.azienda.utility;

import java.util.Scanner;

public class ValidatoreTipo {
	public static boolean checkBoolean(Scanner input, String messaggio) {
		String s;
		while (true) {
			System.out.println(messaggio);
			s = input.nextLine().toLowerCase();
			if (s.equals("true") || s.equals("false")) {
				return Boolean.parseBoolean(s); // Ritorna il valore ed esce dal metodo
			}
			System.out.println("Errore, digitare true o false");
		}
	}

	/**
	 * 
	 * @param input
	 * @param messaggio
	 * @return float
	 */
	public static float checkFloat(Scanner input, String messaggio) {
		float valore = 0;
		boolean inputValido = false;

		while (!inputValido) {
			System.out.println(messaggio);

			if (input.hasNextFloat()) {
				valore = input.nextFloat();
				inputValido = true; // Esci dal ciclo
			} else {
				System.out.println("Errore: devi inserire un numero (es. 100.5).");
			}

			// Fondamentale: pulisce il buffer dello scanner
			input.nextLine();
		}

		return valore;
	}
}