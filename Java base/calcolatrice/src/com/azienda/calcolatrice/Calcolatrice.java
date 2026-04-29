package com.azienda.calcolatrice;

import java.util.Scanner;

public class Calcolatrice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		int a, b;
		//ciclo infinito (finché non decido di chiudere la calcolatrice)
		while(true) {
			System.out.println("che operazione vuoi fare?\n1) somma\n2) differenza\n3) moltiplicazione\n4) divisione\n0 esci");
			choice = scanner.nextInt();
			
			check(choice, scanner);
			if(choice == 0) {
				scanner.close();
				return;
			}
			System.out.println("inserire primo numero");
			a=scanner.nextInt();
			System.out.println("inserire secondo numero");
			b=scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println(a+"+"+b+"="+addizione(a, b));
				break;
			case 2:
				System.out.println(a+"-"+b+"="+differenza(a, b));
				break;
			case 3:
				System.out.println(a+"*"+b+"="+moltiplicazione(a, b));
				break;
			case 4:
				System.out.println(a+"/"+b+"="+divisione(a, b));
				break;
			}
		}
	}

	private static void check (int choice, Scanner scanner) {
		do {
			
			if(choice > 4 || choice < 0) {
				System.out.println("inserire un valore valido");
			}
		} while (choice > 4 || choice < 0);
		//chiudo il programma solo con 0, chiudo il programma
		
	}
	
	private static int addizione (int a, int b) {
		return a+b;
	}
	private static int differenza (int a, int b) {
		return a-b;
	}
	private static int moltiplicazione (int a, int b) {
		return a*b;
	}
	private static float divisione (int a, int b) {
		
		return (float)a/b;
	}

}
