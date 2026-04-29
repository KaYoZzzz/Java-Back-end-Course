package com.azienda.esercizioCiclo;

import java.util.Scanner;

public class EsercizioCiclo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int primoNumero = 0;
		int secondoNumero = 0;


		System.out.print("Inserisci il primo numero intero: ");
		primoNumero = scanner.nextInt();

		System.out.print("Inserisci il secondo numero intero: ");
		secondoNumero = scanner.nextInt();
		scanner.close();
		if(primoNumero<=0) {
			System.out.println("Si deve inputare un numero maggiore di 0");
			return;
		}
		if(secondoNumero <= 0) {
			System.out.println("Si deve inputare un numero maggiore di 0");
			return;
		}
		
		if(secondoNumero>=primoNumero) {
			System.out.println("Si deve inputare un numero minore di "+primoNumero);
			return;
		} else {
			for(int i = 0; i<primoNumero;i++) {
				if(i==secondoNumero) {
					continue;
				}
				System.out.println(i);
			}
		}
		
	}
}
