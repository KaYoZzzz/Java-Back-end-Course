package com.azienda.esercizio6;

import java.util.Scanner;

public class Operatori6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci numero:");
		int input = scanner.nextInt();
		scanner.close();
		int saveInput=input;
		int out = input +=10;
		System.out.println("Incrementando " + saveInput + " di 10 si ottiene " + out);
	}

}
