package com.azienda.view;

import java.util.Scanner;

import com.azienda.control.RubricaController;
import com.azienda.model.Rubrica;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rispostaMenu = 0;
		Rubrica rubrica = new Rubrica("Nuova Rubrica", 2025);
		RubricaController rubricaController = new RubricaController(rubrica);
		boolean ripeti = false;
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("\n\n---Benvenuto nella rubrica, cosa desideri fare?---\n" + "0) Esci\n"
						+ "1) Inserire un nuovo contatto nella rubrica\n" + "2) aggiornamento completo di un contatto\n"
						+ "3) Aggiornamento parziale di un contatto\n" + "4) cancellazione di un contatto\n"
						+ "5) Ricerca di un contatto per nome\n" + "6) ricerca di un contatto per cognome\n"
						+ "7) Ricerca di un contatto per numero di telefono\n"
						+ "8) Visualizzazione contatti presenti in rubrica (per ordine di inserimento)\n"
						+ "9) Visualizzazione contatti presenti in rubrica (per nome)\n"
						+ "10) Visualizzazione contatti presenti in rubrica (per cognome)\n"
						+ "11) Visualizzazione contatti presenti in rubrica (priorità cognome su nome)\n");

				do {
					ripeti = false;
					try {
						rispostaMenu = scanner.nextInt();
						scanner.nextLine();
						if (rispostaMenu == 0) {
							return;
						}
						if (rispostaMenu < 0 || rispostaMenu > 11) {
							System.out.println("Inserire un valore da 1 a 11 a seconda dell'azione da eseguire");
							ripeti = true;
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Errore, valore inserito non valido, riprova:");
						ripeti = true;
						scanner.nextLine();
					}
				} while (ripeti);

				switch (rispostaMenu) {
				case 1:
					rubricaController.addContact(scanner);
					break;

				case 2:
					rubricaController.completeUpdate(scanner);
					break;

				case 3:
					rubricaController.partialUpdate(scanner);
					break;

				case 4:
					rubricaController.deleteContact(scanner);
					break;
				case 5:
					rubricaController.search(5, scanner);
					break;
				case 6:
					rubricaController.search(6, scanner);
					break;
				case 7:
					rubricaController.search(7, scanner);

					break;
				case 8:
					System.out.println("\n---Lista contatti per ordine di inserimento---");
					rubricaController.printContacts();
					break;
				case 9:
					System.out.println("\n---Lista contatti per ordine di nome---");
					rubricaController.nameSurnameSearch(rispostaMenu);
					break;
				case 10:
					System.out.println("\n---Lista contatti per ordine di cognome---");
					rubricaController.nameSurnameSearch(rispostaMenu);
					break;
				case 11:
					System.out.println("\n---Lista contatti per ordine di cognome su nome---");
					rubricaController.nameSurnameSearch(rispostaMenu);
					break;
				default:

					break;
				}

				/////
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
