package com.azienda.utilitaJdk.parteA.esercizi;

import java.util.Scanner;

public class EsercizioArray2 {
	public static void main(String[] args) {
		int n;
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Inserire un numero intero positivo");
				n = scanner.nextInt();
			} while (n < 0);
			Integer[][] matrix = new Integer[n][n];
			riempiArray(matrix, n);
			stampaArray(matrix);
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
	}

	private static void riempiArray(Integer[][] matrix, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == i) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = 0;
				}
			}
		}
	}

	private static void stampaArray(Integer[][] matrix) {
		for (Integer[] array : matrix) {
			for (Integer i : array) {
				System.out.print(i);
			}
			System.out.println("");
		}
	}
}
