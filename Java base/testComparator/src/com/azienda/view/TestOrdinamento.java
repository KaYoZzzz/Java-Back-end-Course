package com.azienda.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.azienda.model.Automobile;
import com.azienda.utils.ComparatorAutomobileByModello;

public class TestOrdinamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			List<String> note = Arrays.asList("Do", "Re", "Mi", "Fa", "Sol", "La", "Si");
			Collections.sort(note);
			System.out.println("Stampa ordinata in verso crescente");
			stampaLista(note);

			Collections.reverse(note);
			System.out.println("Stampa ordinata in verso decrescente");
			stampaLista(note);

			List<Automobile> automobili = Arrays.asList(new Automobile("ModelloX", 3500f),
					new Automobile("ModelloY", 2500f), new Automobile("ModelloZ", 1500f));

			Collections.sort(automobili); // si può fare se Automobile implements Comparable<Automobile>
			System.out.println("Stampa delle auto ordinata in verso crescente per la cilindrata");
			stampaAutomobili(automobili);

			Collections.sort(automobili, new ComparatorAutomobileByModello());
			System.out.println("Stampa delle auto ordinata in verso crescente prima per modello e poi per cilindrata");
			stampaAutomobili(automobili);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void stampaLista(List<String> list) {
		for (String s : list) {
			System.out.println(s + " ");
		}
		System.out.println("");
	}

	private static void stampaAutomobili(List<Automobile> listAuto) {
		for (Automobile automobile : listAuto) {
			System.out.println(automobile.toString() + " ");
		}
		System.out.println("");
	}
}
