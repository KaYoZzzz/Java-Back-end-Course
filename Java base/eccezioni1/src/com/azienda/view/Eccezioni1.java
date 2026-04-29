package com.azienda.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eccezioni1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int in = 0;
			int in2 = 0;
			boolean check = false;
			do {
				try {
					System.out.println("inserisci numero intero");
					in = scanner.nextInt();
					if (in < 0) {
						throw new RuntimeException("Errore, numero < 0");
					}
					System.out.println("inserisci secondo numero intero");
					in2 = scanner.nextInt();
					if (in2 == 0) {
						throw new RuntimeException("Errore, numero = 0");
					}
					check = true;
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.err.println("Errore, input non valido, riprovare");
					scanner.next();
				}
			} while (check == false);
			System.out.println(in + "/" + in2 + "=" + in / in2);
		} catch (RuntimeException re) {
			// TODO: handle exception
			System.out.println(re.getMessage());
		}

	}
}
