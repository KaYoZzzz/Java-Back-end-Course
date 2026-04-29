package com.azienda.esercizioWhile;

import java.util.Scanner;

public class EsercizioWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int primoNumero = 0;
		int secondoNumero = 0;

		// Fase 1: Input primo numero
		System.out.print("Inserisci il primo numero intero: ");
		primoNumero = scanner.nextInt();

		System.out.print("Inserisci il secondo numero intero: ");
		secondoNumero = scanner.nextInt();

		if(primoNumero<=0) {
			System.out.println("Si deve inputare un numero maggiore di 0");
		}
		if(secondoNumero <= 0) {
			System.out.println("Si deve inputare un numero maggiore di 0");
		}

		if(secondoNumero>=primoNumero) {
			System.out.println("Si deve inputare un numero minore di "+primoNumero);
		}
		else {

			int i = 0;
			while (i<primoNumero) {
				System.out.println(i);				
				i+=secondoNumero;
			}
		}
		scanner.close();

	}
}
