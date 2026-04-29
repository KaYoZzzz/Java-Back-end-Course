package com.azienda.testConfronto;

import java.util.Scanner;

public class TestConfronto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci primo numero");
		int a = scanner.nextInt();
		System.out.println("inserisci secondo numero");
		int b = scanner.nextInt();
		scanner.close();
		int result = confronta(a, b);

		switch (result) {
		case -1:
			System.out.println("il primo numero è minore del secondo");
			break;
		

		case 0: 
			System.out.println("i due numeri sono uguali");
			break;
		

		case 1:
			System.out.println("il primo numero è maggiore del secondo");
			break;
		}

	}

	static int confronta(int a, int b) {

		if(a<b) {
			return -1;
		} else if (a == b) {
			return 0; 
		} else {
			return 1;
		}
	}

}

