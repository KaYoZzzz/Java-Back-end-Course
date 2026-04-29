package com.azienda.esercizio3;

import java.util.Scanner;

public class Operatori3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		System.out.println("inserire numero:");
		Scanner scanner = new Scanner(System.in);
		
		input = scanner.nextInt();
		scanner.close();
		System.out.println("numero contemporaneamente un post-incremento: " + input++);
		System.out.println("numero successivamente rispetto al post-incremento: " + input);
		System.out.println("numero contemporaneamente un pre-incremento: " + ++input);
		System.out.println("numero successivamente rispetto al pre-incremento: " + input);
	}

}
