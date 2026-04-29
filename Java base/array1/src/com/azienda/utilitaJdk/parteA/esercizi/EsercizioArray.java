package com.azienda.utilitaJdk.parteA.esercizi;

import java.util.Scanner;

public class EsercizioArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digitare la dimensione dell'array");
		int arrayLenght = scanner.nextInt();
		Integer[] array = new Integer[arrayLenght];
		riempiArray(array, arrayLenght);
		stampaArray(array);
		scanner.close();
	}

	private static void riempiArray(Integer[] array, int arrayLenght) {
		for (int i = 0; i < arrayLenght; i++) {
			array[i] = i * i;
		}
	}

	private static void stampaArray(Integer[] array) {
		// TODO Auto-generated method stub
		for (Integer i : array) {
			System.out.println(i);
		}
	}
}
