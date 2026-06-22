package com.azienda.withAbstract.view;

import java.util.Scanner;

import com.azienda.withAbstract.model.Differenza;
import com.azienda.withAbstract.model.Divisione;
import com.azienda.withAbstract.model.Prodotto;
import com.azienda.withAbstract.model.RisultatoOperazione;
import com.azienda.withAbstract.model.Somma;

public class ChiamanteOperazioni {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;
		int a, b;

		while (true) {
			choice = check(scanner);
			if (choice == 5) {
				scanner.close();
				return;
			}
			System.out.println("inserire primo numero");
			a = scanner.nextInt();
			System.out.println("inserire secondo numero");
			b = scanner.nextInt();

			// USA LA CLASSE ASTRATTA COME TIPO!
			RisultatoOperazione object = null;

			switch (choice) {
			case 1:
				object = new Somma();
				break;
			case 2:
				object = new Differenza();
				break;
			case 3:
				object = new Prodotto();
				break;
			case 4:
				object = new Divisione();
				break;
			}

			// GRAZIE ALLA TUA CLASSE ASTRATTA, PUOI FARE DIRETTAMENTE QUESTO:
			if (object != null) {
				object.printResult(a, b);
			}
		}
	}

	private static int check(Scanner scanner) {
		int choice;
		do {
			System.out.println(
					"che operazione vuoi fare?\n1) somma\n2) differenza\n3) moltiplicazione\n4) divisione\n5) esci");
			choice = scanner.nextInt();
			if (choice > 5 || choice < 1) {
				System.out.println("inserire un valore valido");
			}
		} while (choice > 5 || choice < 1);
		// chiudo il programma solo con 0, chiudo il programma
		return choice;
	}

}
