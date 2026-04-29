package com.azienda.utilitaJdk.parteA.esercizi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EsercizioList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ESC = "esc";
		String newLine;
		List<String> list = new ArrayList<>();
		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out.println("Inserire stringa nella lista:");
				newLine = scanner.nextLine();
				if (!newLine.toLowerCase().equals(ESC)) {
					list.add(newLine);
				}
			} while (!newLine.toLowerCase().equals(ESC));
			printList(list);
			System.out.println("");
			printList2(list);
			System.out.println("");
			printList3(list);

			do {
				System.out.println("Digitare l'elemento da verificare:");
				newLine = scanner.nextLine();
				if (!newLine.toLowerCase().equals(ESC)) {
					int counter = 0;
					for (String item : list) {
						if (item.toLowerCase().contains(newLine.toLowerCase())) {
							System.out.println(item);
							counter++;
						}
					}
					if (counter == 0) {
						System.out.println("\nNessun elemento trovato con la stringa " + newLine);
					}
				}
			} while (!newLine.toLowerCase().equals(ESC));
		}
	}

	public static void printList(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}

	public static void printList2(List<String> lista) {
		for (String s : lista) {
			System.out.println(s);
		}
	}

	public static void printList3(List<String> lista) {
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}

}
