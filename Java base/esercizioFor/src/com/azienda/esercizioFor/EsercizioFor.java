package com.azienda.esercizioFor;

import java.util.Scanner;

public class EsercizioFor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci il primo numero");
		int input = scanner.nextInt();
		scanner.close();
		if(input<=0) {
			System.out.println("Si deve inputare un numero maggiore di 0");
		} else {
			for (int i = 0; i<input; i++) {
				System.out.println(i);
			}
		}
	}
}
