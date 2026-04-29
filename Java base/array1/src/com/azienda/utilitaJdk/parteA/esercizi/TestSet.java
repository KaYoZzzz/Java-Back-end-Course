package com.azienda.utilitaJdk.parteA.esercizi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {
	public static void main(String[] args) {
		try {
			Set<String> nomi = new HashSet();
			// la Set aggiunge in maniera casuale, quindi potrebbe succede di avere ad
			// esempio [Luca, Claudio, Mario, Luisa]
			nomi.add("Mario");
			nomi.add("Mario");// ignorato, esiste già, nelle Set non esistono i duplicati
			nomi.add("Mario");// ignorato, esiste già, nelle Set non esistono i duplicati
			nomi.add("Claudio");
			nomi.add("Luisa");
			nomi.add("Luca");
			System.out.println("Numeri elementi: " + nomi.size());
			boolean b = nomi.contains("Luca");
			b = nomi.contains("luca");// non esiste
			nomi.remove("luca");// ignorato, non esiste
			nomi.remove("Luca");
			System.out.println("\nEnhanced for:");
			for (String s : nomi) {
				System.out.println(s);
			}
			System.out.println("\nIterator :");
			Iterator<String> it = nomi.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
