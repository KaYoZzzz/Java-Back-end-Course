package com.azienda.jdbcEsercizio.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.azienda.jdbcEsercizio.businessLogic.ApplicationService;
import com.azienda.jdbcEsercizio.model.Automobile;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		Scanner scanner = new Scanner(System.in);

		try {
			final String driverName = "com.mysql.cj.jdbc.Driver";
			final String url = "jdbc:mysql://localhost:3306/eserciziojdbc?useSSL=false&serverTimezone=UTC";
			final String user = "root";
			final String password = "root";

			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);

			ApplicationService service = new ApplicationService(connection);

			int scelta = -1;

			while (scelta != 0) {
				System.out.println("\n--- MENU GESTIONE AUTOMOBILI ---");
				System.out.println("1. Inserisci una nuova Automobile");
				System.out.println("2. Elimina macchine per marca");
				System.out.println("3. Aggiorna targa da marca");
				System.out.println("4. Visualizza tutte le automobili");
				System.out.println("0. Esci e salva (Commit)");
				System.out.print("Scelta: ");

				String input = scanner.nextLine();

				try {
					scelta = Integer.parseInt(input);

					// Controllo Range (deve essere tra 0 e 4)
					if (scelta < 0 || scelta > 4) {
						System.out.println("Errore: Inserisci un numero valido tra 0 e 4.");
						continue; // Torna all'inizio del ciclo e richiede la scelta
					}

					switch (scelta) {
					case 1:
						System.out.print("Marca: ");
						String marca = scanner.nextLine();
						System.out.print("Modello: ");
						String modello = scanner.nextLine();
						System.out.print("Targa: ");
						String targa = scanner.nextLine();
						System.out.print("Colore: ");
						String colore = scanner.nextLine();

						// Controllo tipo anche per la cilindrata
						float cilindrata = 0;
						try {
							System.out.print("Cilindrata: ");
							cilindrata = Float.parseFloat(scanner.nextLine());
						} catch (NumberFormatException e) {
							System.out.println("Cilindrata non valida, impostata a 0.");
						}

						Automobile nuovaAuto = new Automobile(marca, modello, targa, colore, cilindrata);
						service.insertParametric(nuovaAuto);
						System.out.println("Automobile inserita.");
						break;

					case 2:
						System.out.print("Marca da eliminare: ");
						String inizioMarcaDel = scanner.nextLine();
						int cancellate = service.deleteMacchinaPerMarca(inizioMarcaDel);
						System.out.println("Macchine rimosse: " + cancellate);
						break;

					case 3:
						System.out.print("Marca da cercare: ");
						String marcaUpd = scanner.nextLine();
						System.out.print("Nuova targa: ");
						String nuovaTarga = scanner.nextLine();
						int modificate = service.updateTargaFromMarca(marcaUpd, nuovaTarga);
						System.out.println("Macchine modificate: " + modificate);
						break;

					case 4:
						List<Automobile> listaAuto = service.selectAll();
						for (Automobile a : listaAuto) {
							System.out.println(a.toString());
						}
						break;

					case 0:
						connection.commit();
						System.out.println("Dati salvati. Chiusura in corso...");
						break;
					}

				} catch (NumberFormatException e) {
					// Gestisce il caso in cui l'utente scrive "Fiat" o lettere invece di numeri
					System.out.println("Errore: Devi inserire un numero, non del testo!");
					scelta = -1; // Resetta la scelta per non uscire dal ciclo
				}
			}

		} catch (Exception e) {
			System.err.println("Errore imprevisto: " + e.getMessage());
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				scanner.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}