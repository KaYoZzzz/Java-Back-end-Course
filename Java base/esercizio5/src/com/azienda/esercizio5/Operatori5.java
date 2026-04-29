package com.azienda.esercizio5;

import java.util.Scanner;

public class Operatori5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bool1;
		boolean bool2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci primo bool");
		bool1 = scanner.nextBoolean();
		System.out.println("inserisci secondo bool");
		bool2 = scanner.nextBoolean();
		scanner.close();
		
		System.out.println("La and di true e false vale:" + (bool1&&bool2));
		System.out.println("L'or di true e false vale:" + (bool1||bool2));
		System.out.println("not del primo booleano:" + (!bool1));
		System.out.println("not del secondo booleano:" + (!bool2));
		
	}

}
