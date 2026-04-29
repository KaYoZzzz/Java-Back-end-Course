package com.azienda.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.azienda.control.ApplicationService;
import com.azienda.model.Articolo;

public class Main {

	public static void main(String[] args) {
		// Spostiamo lo scanner nel try-with-resources per chiuderlo automaticamente
		Scanner sc = new Scanner(System.in);

		final String driverName = "com.mysql.cj.jdbc.Driver";
		final String url = "jdbc:mysql://localhost:3306/shoppingcart?useSSL=false&serverTimezone=UTC";
		final String user = "root";
		final String password = "root";

		try {
			// 1. Carichiamo il driver fuori dal blocco delle risorse
			Class.forName(driverName);

			// 2. Apriamo la connessione
			try (Connection conn = DriverManager.getConnection(url, user, password)) {

				conn.setAutoCommit(false);
				ApplicationService service = new ApplicationService(conn);

				int scelta = -1;

				while (scelta != 0) {
					System.out.println("\n--- GESTIONE CARRELLO ARTICOLI ---");
					System.out.println("1. Inserisci nuovo articolo");
					System.out.println("2. Elimina articolo per nome");
					System.out.println("3. Ricerca articoli per nome (contiene stringa)");
					System.out.println("4. Ricerca articoli per prezzo inferiore a...");
					System.out.println("5. Visualizza tutti (Ordinati per Nome)");
					System.out.println("6. Visualizza tutti (Ordinati per Prezzo)");
					System.out.println("7. Visualizza costo totale carrello");
					System.out.println("0. Esci");
					System.out.print("Scegli un'opzione: ");

					try {
						scelta = Integer.parseInt(sc.nextLine());

						switch (scelta) {
						case 1:
							System.out.print("Inserisci nome articolo: ");
							String nome = sc.nextLine();
							System.out.print("Inserisci prezzo: ");
							Float prezzo = Float.parseFloat(sc.nextLine());
							service.insertParametric(new Articolo(nome, prezzo));
							break;
						case 2:
							System.out.print("Inserisci il nome dell'articolo da eliminare: ");
							service.delete(sc.nextLine());
							System.out.println("Operazione completata.");
							break;
						case 3:
							System.out.print("Inserisci la stringa da cercare nel nome: ");
							stampaLista(service.cercaPerNome(sc.nextLine()));
							break;
						case 4:
							System.out.print("Inserisci il prezzo massimo: ");
							float pMax = Float.parseFloat(sc.nextLine());
							stampaLista(service.cercaSottoPrezzo(pMax));
							break;
						case 5:
							stampaLista(service.visualizzaOrdinatiNome());
							break;
						case 6:
							stampaLista(service.visualizzaOrdinatiPrezzo());
							break;
						case 7:
							float totale = service.getTotaleCarrello();
							System.out.println("Costo totale del carrello: " + totale + " €");
							break;
						case 0:
							System.out.println("Chiusura programma...");
							break;
						default:
							System.out.println("Opzione non valida!");
						}
					} catch (NumberFormatException e) {
						System.out.println("Errore: devi inserire un numero valido per la scelta o il prezzo.");
					} catch (SQLException e) {
						System.err.println("Errore durante l'operazione: " + e.getMessage());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Errore: Driver MySQL non trovato! Verifica le librerie nel progetto.");
		} catch (SQLException e) {
			System.err.println("Errore di connessione al database: " + e.getMessage());
		} finally {
			// Chiudiamo lo scanner qui se non lo mettiamo nel try-with-resources
			sc.close();
		}
	}

	private static void stampaLista(List<Articolo> lista) {
		if (lista == null || lista.isEmpty()) {
			System.out.println("Nessun articolo trovato.");
		} else {
			System.out.println("\nRisultati:");
			for (Articolo a : lista) {
				System.out.println("- " + a.getNome() + ": " + a.getPrezzo() + " €");
			}
		}
	}
}