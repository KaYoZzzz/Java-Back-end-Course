package com.azienda.view;

import java.util.Scanner;

import com.azienda.control.Controller;
import com.azienda.model.NumeroNegativoException;
import com.azienda.model.NumeroZeroException;

public class ChiamanteCustom {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int scelta = 0;

			do {
				System.out.print("Procedere con la divisione? 1=Si, 2=No: ");
				scelta = leggiIntero(scanner, "");

				if (scelta == 1) {
					// 1. Acquisizione primo intero
					int a = leggiIntero(scanner, "Inserisci il primo intero: ");

					try {
						Controller.checkPositive(a);
					} catch (NumeroNegativoException e) {
						e.printStackTrace();
						System.out.println("Messaggio: " + e.getMessage());
						continue;
					}

					// 2. Acquisizione secondo intero
					int b = leggiIntero(scanner, "Inserisci il secondo intero: ");

					try {
						Controller.checkNotZero(b);
					} catch (NumeroZeroException e) {
						e.printStackTrace();
						System.out.println("Messaggio: " + e.getMessage());
						continue;
					}

					// 3. Esecuzione divisione e stampa formato a/b=c
					float risultato = (float) a / b;
					System.out.println("\nESITO:");
					System.out.println(a + "/" + b + "=" + risultato);

				} else if (scelta != 2) {
					System.out.println("Opzione non valida.");
				}

			} while (scelta != 2);

		} catch (Exception e) {
			System.out.println("Errore imprevisto: " + e.getMessage());
		}

		System.out.println("Programma terminato.");
	}

	private static int leggiIntero(Scanner scanner, String messaggio) {
		while (true) {
			if (!messaggio.isEmpty()) {
				System.out.print(messaggio);
			}

			if (scanner.hasNextInt()) {
				int valore = scanner.nextInt();
				// Puliamo il buffer dal carattere '\n' rimasto dopo nextInt()
				scanner.nextLine();
				return valore;
			} else {
				System.out.println("Errore: Devi inserire un numero intero!");
				scanner.next(); // Consuma l'input errato (stringa) per evitare loop
			}
		}
	}
}