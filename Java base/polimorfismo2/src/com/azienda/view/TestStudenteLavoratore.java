package com.azienda.view;

import java.util.Scanner;

import com.azienda.model.Lavoratore;
import com.azienda.model.Studente;

public class TestStudenteLavoratore {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int continueIt = 0;
		do {
			int choice = check(scanner);
			switch (choice) {
			case 1:
				Studente studente = createStudent(scanner);
				System.out.println(studente.getNome() + "\n" + studente.getCognome() + "\n" + studente.getMediaVoti());
				break;

			case 2:
				Lavoratore lavoratore = createWorker(scanner);
				System.out.println(
						lavoratore.getNome() + "\n" + lavoratore.getCognome() + "\n" + lavoratore.getStipendio());
				break;
			}

			System.out.println("Vuoi continuare?\n1)si\n2)no");
			continueIt = scanner.nextInt();
			scanner.nextLine();
		} while (continueIt != 2);
		scanner.close();
	}

	static int check(Scanner scanner) {
		int choice = 0;
		do {
			System.out.println("Vuoi creare uno studente o un lavoratore?\n1)studente\n2)lavoratore");

			choice = scanner.nextInt();
			scanner.nextLine(); // pulisce il buffer
			if (choice < 1 || choice > 2) {
				System.out.println("inserire un valore corretto\n");
			}
		} while (choice < 1 || choice > 2);
		return choice;
	}

	static Studente createStudent(Scanner scanner) {
		System.out.println("Inserire nome: ");
		String nome = scanner.nextLine();
		System.out.println("Inserire cognome: ");
		String cognome = scanner.nextLine();
		float mediaVoti = 0f;
		do {
			System.out.println("Inserire media voti: ");
			mediaVoti = scanner.nextFloat();
			if (mediaVoti < 0 || mediaVoti > 10) {
				System.out.println("valore non accettato\n");
			}
		} while (mediaVoti < 0 || mediaVoti > 10);
		return new Studente(nome, cognome, mediaVoti);

	}

	static Lavoratore createWorker(Scanner scanner) {
		System.out.println("Inserire nome: ");
		String nome = scanner.nextLine();
		System.out.println("Inserire cognome: ");
		String cognome = scanner.nextLine();
		float stipendio = 0f;
		do {
			System.out.println("Inserire Stipendio: ");
			stipendio = scanner.nextFloat();
			if (stipendio < 0) {
				System.out.println("valore non accettato\n");
			}
		} while (stipendio < 0);
		return new Lavoratore(nome, cognome, stipendio);

	}

}
