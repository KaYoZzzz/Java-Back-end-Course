package com.azienda.esercizio4;

import java.util.Scanner;

public class Operatori4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.println("Inserisci primo numero:");
		a = sc.nextInt();
		System.out.println("Inserisci secondo numero:");
		b = sc.nextInt();
		sc.close();
		String s = (a>=b) ? "a maggiore o uguale di b" : "b maggiore di a";
		System.out.println(s);
	}
}