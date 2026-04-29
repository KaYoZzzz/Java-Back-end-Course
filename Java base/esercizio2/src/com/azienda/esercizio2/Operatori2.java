package com.azienda.esercizio2;

import java.util.Scanner;

public class Operatori2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.println("Inserisci due numeri interi:");
		a = sc.nextInt();
		b = sc.nextInt();
		sc.close();
		System.out.println("la somma dei due numeri fa: " + (a+b));
	}
}
