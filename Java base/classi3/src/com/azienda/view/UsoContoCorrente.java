package com.azienda.view;

import java.util.Scanner;

import com.azienda.model.Banca;
import com.azienda.model.ContoCorrente;
import com.azienda.model.Indirizzo;

public class UsoContoCorrente {
	public static void main(String[] args) {
		Indirizzo indirizzo = new Indirizzo("Lacchiarella", "Via Toscana", 3);
		System.out.println(indirizzo.descrizione());
		Banca banca = new Banca("BCC", indirizzo);
		System.out.println(banca.descrizione());
		ContoCorrente c1 = new ContoCorrente("IT3804920900000976", 6000, banca);
		System.out.println(c1.descrizione());
		ContoCorrente c2 = new ContoCorrente("IT1862940900000322", 5000, banca);
		System.out.println(c2.descrizione());
		System.out.println("Nome banca conto corrente 1: " + c1.getNomeBanca() + "\nCittà conto corrente 1:" + c1.getCittaBanca());
		System.out.println("Nome banca conto corrente 2: " + c2.getNomeBanca() + "\nCittà conto corrente 2:" + c2.getCittaBanca());
		
		
		System.out.println("\n \nDigitare importo:");
		Scanner scanner = new Scanner(System.in);
		float importo = scanner.nextFloat();
		scanner.close();
		if(c2.getSaldo()  - importo >= 0) {
			c1.setSaldo(c1.getSaldo() + importo);
			c2.setSaldo(c2.getSaldo() - importo);
			
			System.out.println(c1.descrizione()+"\n\n"+c2.descrizione());
		} else {
			System.err.println("Impossibile effettuare operazione, saldo c2 superiore all'importo");
		}
	}
}
