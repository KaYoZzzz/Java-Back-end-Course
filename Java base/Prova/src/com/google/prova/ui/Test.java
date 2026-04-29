package com.google.prova.ui;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ciao!\nScrivi il tuo nome");
		String s = scanner.nextLine();
		
		System.out.println("Ciao! "+ s);
		scanner.close();
		
	}
}