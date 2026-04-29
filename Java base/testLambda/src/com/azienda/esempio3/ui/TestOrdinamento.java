package com.azienda.esempio3.ui;

import java.util.Arrays;
import java.util.List;

import com.azienda.esempio3.model.Persona;

public class TestOrdinamento {
	public static void main(String[] args) {
		try {
			List<Persona> persone = Arrays.asList(new Persona("Mario", "Rossi"), new Persona("Anna", "Rossi"),
					new Persona("Mario", "Bianchi"), new Persona("Andrea", "Verdi"));
			persone.sort((p1, p2) -> p1.getCognomeString().compareTo(p2.getCognomeString()));
			System.out.println("Stampa ordinata per cognome");
			persone.forEach(System.out::println);

			persone.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
			System.out.println("Stampa ordinata per nome");
			persone.forEach(System.out::println);

			// dati due soggetti, va prima a confrontarli per cognome, se hanno il cognome
			// uguale va a controllare il nome
			persone.sort((p1, p2) -> {
				int risultato = p1.getCognomeString().compareTo(p2.getCognomeString());
				if (risultato != 0) {
					return risultato;
				}
				return p1.getNome().compareTo(p2.getNome());
			});
			System.out.println("Stampa ordinata prima per cognome e poi per nome");
			persone.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
