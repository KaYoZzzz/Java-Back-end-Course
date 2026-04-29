package com.azienda.esercizioSwitchCase;

import java.util.Scanner;

public class EsercizioSwitchCase {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Inserisci il nome del mese: ");
		String mese = scanner.nextLine();

		int giorni = 0;

		switch (mese) {
		case "aprile", "giugno", "settembre", "novembre":{
			giorni = 30;

			break;
		}

		case "gennaio", "marzo", "maggio", "luglio", "agosto", "ottobre", "dicembre":{
			giorni = 31;
			break;
		}

		case "febbraio": {
			System.out.print("È un anno bisestile? (si/no): ");
			String risposta = scanner.nextLine();
			if(risposta.equals("si")) {
				giorni = 29;
			} else {
				giorni = 28;
			}
		}

		break;
		}

		System.out.println("Il mese di " + mese + " ha " + giorni + " giorni.");


		scanner.close();
	}
}