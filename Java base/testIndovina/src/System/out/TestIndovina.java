package System.out;

import java.util.Random;
import java.util.Scanner;


public class TestIndovina {
	public static void main(String[] args) {
		int input, result, max;
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci il numero massimo da indovinare");
		max = scanner.nextInt();

		do {
			result = controlla(max);
			System.out.println("indovina il numero");
			input = scanner.nextInt();

			if(input == result) {
				System.out.println("hai indovinato");
			} else {
				System.out.println("hai sbagliato, il numero da indovinare era " + result);
			}
			
		} while (input != result);
		scanner.close();
		
	}
	private static int controlla(int max) {
		return new Random().nextInt(max);
	}
}
