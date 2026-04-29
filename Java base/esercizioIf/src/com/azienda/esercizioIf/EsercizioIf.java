package com.azienda.esercizioIf;

import java.util.Scanner;

public class EsercizioIf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci il primo numero");
		int a = scanner.nextInt();
		System.out.println("inserisci il secondo numero");
		int b = scanner.nextInt();
		scanner.close();
		if(b == 0) {
			System.out.println("non si può dividere per 0");
		}
		if(a > 0 && b > 0 && b<=a) {
			double c = (double)a/b;
			System.out.println(a + "/" + b + "=" + c);
		}
	}
}
