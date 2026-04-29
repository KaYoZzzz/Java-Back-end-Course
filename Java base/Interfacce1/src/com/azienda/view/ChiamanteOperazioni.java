package com.azienda.view;

import java.util.Scanner;

import com.azienda.model.Differenza;
import com.azienda.model.Divisione;
import com.azienda.model.OperazioniAritmetiche;
import com.azienda.model.Prodotto;
import com.azienda.model.Somma;

public class ChiamanteOperazioni {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		int a, b;
		// ciclo infinito (finché non decido di chiudere la calcolatrice)
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
			OperazioniAritmetiche object;
			switch (choice) {
			case 1:
				object = new Somma();
				object.printResult(object.operate(a, b));
				break;
			case 2:
				object = new Differenza();
				object.printResult(object.operate(a, b));
				break;
			case 3:
				object = new Prodotto();
				object.printResult(object.operate(a, b));
				break;
			case 4:
				object = new Divisione();
				object.printResult(object.operate(a, b));
				break;
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
