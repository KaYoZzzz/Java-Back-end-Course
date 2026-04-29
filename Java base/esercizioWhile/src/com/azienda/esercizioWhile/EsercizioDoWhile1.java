package com.azienda.esercizioWhile;

import java.util.Scanner;

public class EsercizioDoWhile1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("inserisci un numero intero positivo");
			 input = scanner.nextInt();
		} while (input <= 0);
		int i = 0;
		do {
			System.out.println(i++);
			
		} while(i<input);
		scanner.close();
	}

}