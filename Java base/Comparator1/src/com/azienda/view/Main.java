package com.azienda.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.azienda.model.Studente;
import com.azienda.utils.ComparatorStudenteByVotoCognomeNome;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner scanner = new Scanner(System.in)) {
			String choice = null, nome = null, cognome = null;
			Float mediaVoti = 0f;
			List<Studente> studenti = new ArrayList<Studente>();
			do {
				System.out.println("Inserire nome studente");
				nome = scanner.nextLine();
				System.out.println("Inserire cognome studente");
				cognome = scanner.nextLine();
				do {
					try {

						System.out.println("Inserire media voti studente");
						mediaVoti = scanner.nextFloat();

					} catch (Exception e) {
						// TODO: handle exception
						mediaVoti = -1f;
						scanner.nextLine();
					} finally {
						if (mediaVoti < 0 || mediaVoti > 30) {
							System.out.println("Inserire un valore corretto (>= 0 o <= 30)");
						}
					}
				} while (mediaVoti < 0 || mediaVoti > 30);
				scanner.nextLine();
				studenti.add(new Studente(nome, cognome, mediaVoti));
				System.out.println("Studente creato\nVuoi crearne uno nuovo?\nDigita ESC per fermarti");
				choice = scanner.nextLine();
			} while (!choice.toLowerCase().equals("esc"));
			studenti.sort(new ComparatorStudenteByVotoCognomeNome());

			String fasciaCorrente = "";
			for (Studente studente : studenti) {
				// 1. Determiniamo la fascia dello studente attuale
				String fasciaStudente = calcolaEtichettaFascia(studente.getMediaVoti());

				// 2. Se la fascia dello studente è diversa dall'ultima che abbiamo stampato,
				// allora stampiamo il nuovo titolo della fascia
				if (!fasciaStudente.equals(fasciaCorrente)) {
					fasciaCorrente = fasciaStudente;
					System.out.println("\n" + fasciaCorrente + "\n");
				}

				// 3. Stampiamo i dati dello studente nel formato richiesto
				System.out.println(studente.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	private static String calcolaEtichettaFascia(float voto) {
		if (voto >= 26) {
			return "FASCIA 1";
		}
		if (voto >= 22) {
			return "FASCIA 2";
		}
		if (voto >= 18) {
			return "FASCIA 3";
		}
		return "BOCCIATI";
	}

}
