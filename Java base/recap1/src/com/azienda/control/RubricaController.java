package com.azienda.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.azienda.model.Contatto;
import com.azienda.model.Rubrica;

public class RubricaController {
	private Rubrica rubrica;

	public RubricaController(Rubrica rubrica) {

		this.rubrica = rubrica;
	}

	public void addContact(Scanner scanner) {
		Contatto newContact;
		boolean ripeti;
		String rispostaNuovoContatto;
		///// CREAZIONE DEL CONTATTO E INSERIMENTO IN RUBRICA/////
		do {
			do {
				newContact = getContactInfo(scanner);

				ripeti = false;
				// controlla se il contatto esiste, se esiste, ripeti tutto l'inserimento
				if (this.rubrica.containsContatto(newContact)) {
					System.out.println("Impossibile creare il contatto, contatto già esistente");
					ripeti = true;
				}
			} while (ripeti);
			this.rubrica.addContatto(newContact);
			System.out.println(
					"Contatto creato, vuoi aggiungierne uno nuovo? \n(Scrivi yes per continuare, altrimenti premi invio)");
			rispostaNuovoContatto = scanner.nextLine();
			ripeti = false;
			if (rispostaNuovoContatto.equalsIgnoreCase("yes")) {
				ripeti = true;
			}
		} while (ripeti);
	}

	public void completeUpdate(Scanner scanner) {
		if (rubrica.getContatti().isEmpty()) {
			System.out.println("La rubrica è vuota. Nulla da aggiornare.");
			return;
		} else {
			this.printContacts();
			Contatto cToUpdate = getContactInfo(scanner);
			if (rubrica.containsContatto(cToUpdate)) {
				int index = rubrica.getContatti().indexOf(cToUpdate);
				System.out.println("\nContatto trovato! Inserisci ora i NUOVI dati per l'aggiornamento:");
				Contatto nuovoContatto = getContactInfo(scanner);

				if (rubrica.containsContatto(nuovoContatto) && !nuovoContatto.equals(cToUpdate)) {
					System.out.println("Errore: esiste già un altro contatto con questi nuovi dati.");
				} else {
					// sostituzione effettiva
					rubrica.getContatti().set(index, nuovoContatto);
					System.out.println("Aggiornamento completato con successo!");
				}
			} else {
				System.out.println("Nessun contatto trovato");
			}
		}
	}

	public void partialUpdate(Scanner scanner) {
		if (rubrica.getContatti().isEmpty()) {
			System.out.println("La rubrica è vuota. Nulla da aggiornare.");
			return;
		} else {
			this.printContacts();
			Contatto cToUpdate = getContactInfo(scanner);
			if (rubrica.containsContatto(cToUpdate)) {
				int index = rubrica.getContatti().indexOf(cToUpdate);
				System.out.println("\nContatto trovato!\n"
						+ "Inserisci ora i NUOVI dati per l'aggiornamento.\npremi invio se non vuoi modificare quel campo:");
				Contatto nuovoContatto = getContactInfo(scanner);
				Contatto dummyContatto = rubrica.getContatti().get(index);
				if (nuovoContatto.getNome().equals("")) {
					nuovoContatto.setNome(dummyContatto.getNome());
				}
				if (nuovoContatto.getCognome().equals("")) {
					nuovoContatto.setCognome(dummyContatto.getCognome());
				}
				if (nuovoContatto.getTelefono().equals("")) {
					nuovoContatto.setTelefono(dummyContatto.getTelefono());
				}

				if (rubrica.containsContatto(nuovoContatto) && !nuovoContatto.equals(cToUpdate)) {
					System.out.println("Errore: esiste già un altro contatto con questi nuovi dati.");
				} else {
					rubrica.getContatti().set(index, nuovoContatto);
					System.out.println("Aggiornamento completato con successo!");
				}
			} else {
				System.out.println("Nessun contatto trovato");
			}
		}
	}

	public void deleteContact(Scanner scanner) {
		if (rubrica.getContatti().isEmpty()) {
			System.out.println("La rubrica è vuota. Nulla da eliminare.");
			return;
		} else {
			this.printContacts();
			Contatto cToDelete = getContactInfo(scanner);
			if (rubrica.containsContatto(cToDelete)) {
				int index = rubrica.getContatti().indexOf(cToDelete);
				System.out.println("Contatto trovato!");
				rubrica.getContatti().remove(index);
				System.out.println("Contatto rimosso!");
			} else {
				System.out.println("Nessun contatto trovato");
			}
		}
	}

	public void search(int toSearch, Scanner scanner) {
		String fieldToCheck = "";

		if (rubrica.getContatti().isEmpty()) {
			System.out.println("La rubrica è vuota. Nulla da cercare.");
			return;
		} else {
			System.out.println("Digitare stringa da cercare");
			String str = scanner.nextLine();
			System.out.println("--- Lista contatti contenente la stringa " + str + " ---");
			for (Contatto contatto : rubrica.getContatti()) {

				switch (toSearch) {
				case 5:
					fieldToCheck = contatto.getNome();
					break;
				case 6:
					fieldToCheck = contatto.getCognome();
					break;
				case 7:
					fieldToCheck = contatto.getTelefono();
					break;
				default:
					break;
				}

				if (fieldToCheck.contains(str)) {
					System.out.println(contatto.toString());
				}
			}
		}
	}

	/**
	 * metodo utilizzato per ricavare le informazioni da parte dell'utente del
	 * contatto su cui operare
	 * 
	 * 
	 * @param scanner
	 * @return Contatto
	 */
	private Contatto getContactInfo(Scanner scanner) {
		System.out.println("Inserire nome del contatto");
		String nome = scanner.nextLine();
		System.out.println("Inserire cognome del contatto");
		String cognome = scanner.nextLine();
		System.out.println("Inserire numero del contatto");
		String numero = scanner.nextLine();
		Contatto contact = new Contatto(nome, cognome, numero);

		return contact;

	}

	public void printContacts() {
		// this.rubrica.printContacts();
		for (Contatto contatto : rubrica.getContatti()) {
			System.out.println(contatto.toString());
		}
	}

	public void nameSurnameSearch(int choice) {
		ArrayList<Contatto> copiaContatti = new ArrayList<>(this.rubrica.getContatti());

		if (choice == 9) {
			copiaContatti.sort((c1, c2) -> c1.getNome().compareToIgnoreCase(c2.getNome())); // se dal main si sceglie il
																							// 9, visualizzai contatti
																							// per nome
		}

		else if (choice == 10) {
			copiaContatti.sort((c1, c2) -> c1.getCognome().compareToIgnoreCase(c2.getCognome())); // se dal main si
																									// sceglie il 10,
																									// visualizzai
																									// contatti per
																									// cognome

		} else {
			copiaContatti.sort((c1, c2) -> {
				int comp = c1.getCognome().compareToIgnoreCase(c2.getCognome());// se dal main si sceglie l'11,
																				// visualizzai contatti per priorità
																				// cognome su nome
				if (comp != 0) {
					return comp;
				}
				return c1.getNome().compareToIgnoreCase(c2.getNome());
			});

		}
		for (Contatto contatto : copiaContatti) {
			System.out.println(contatto.toString());
		}
	}
}
