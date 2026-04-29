package com.azienda.testBancomat;

import java.util.Scanner;

public class TestBancomat {
	public static void main(String[] args) {
		int saldo;
		int choice;
		boolean check;
		boolean check2=false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci totale saldo");
		saldo=scanner.nextInt();
		while(check2!=true) {
			do {
				System.out.println("0) esci\n1) preleva\n2)versa");
				choice = scanner.nextByte();
				check = controllo(choice);
			} while (check != true);


			switch (choice){
			case 0:
				scanner.close();
				check2 = true;
				break;

			case 1:
				System.out.println("inserisci importo da prelevare");
				int prelievo = scanner.nextInt();
				if(prelievo>saldo) {
					System.out.println("impossibile effettuare il prelievo, saldo insufficiente");
				} 
				else {
					saldo-=prelievo;
					System.out.println("prelievo effettuato, saldo: " + saldo);
				}
				break;

			case 2: 
				System.out.println("inserisci importo versato");
				saldo+=scanner.nextInt();
				System.out.println("versamento effettuato, saldo: " + saldo);
				break;
			}


		}

	}
	private static boolean controllo(int choice) {
		if(choice<0||choice>2) {
			System.out.println("inserire un valore valido");
			return false;
		} 
		return true;
	}
}
