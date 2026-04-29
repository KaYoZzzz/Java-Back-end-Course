package com.azienda.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.azienda.model.Automobile;

public class Main {
	public static void main(String[] args) {
		try {
			// 1 crei una Map<Integer,Automobile> tramite un Supplier
			Supplier<Map<Integer, Automobile>> supplier = () -> {
				Map<Integer, Automobile> map = new HashMap<Integer, Automobile>();
				map.put(1, new Automobile("Ferrari", "F40", "12/04/2005", 3000));
				map.put(2, new Automobile("Lamborghini", "Miura", "15/05/1966", 3900));
				map.put(3, new Automobile("Porsche", "911 Carrera", "20/09/1990", 3600));
				map.put(4, new Automobile("Lancia", "Delta Integrale", "10/01/1992", 1995));
				map.put(-5, new Automobile("Fiat", "500", "04/07/1957", 479));
				map.put(6, new Automobile("Alfa Romeo", "Giulia Quadrifoglio", "24/06/2015", 2891));
				return map;
			};
			// 2 stampi la mappa del punto 1 tramite forEach
			supplier.get().forEach((id, auto) -> {
				System.out.println("ID: " + id + " - Dettagli: " + auto.toString());
			});

			// le automobili associate alle chiavi con valore positivo e con cilindrata
			// maggiore di un certo numero x

			// Il predicato riceve una Entry (chiave-valore) e restituisce true se rispetta
			// i parametri
			final int max = 2000;
			Predicate<Entry<Integer, Automobile>> predicate1 = entry -> entry.getKey() > 0
					&& entry.getValue().getCilindrata() > max;
			final int min = 500;
			// le automobili associate alle chiavi con valore negativo e la cilindrata
			// minore di un certo numero y
			Predicate<Entry<Integer, Automobile>> predicate2 = entry -> entry.getKey() < 0
					&& entry.getValue().getCilindrata() < min;
			// utilizzare un Predicate per il test dei due punti precedenti
			Predicate<Entry<Integer, Automobile>> combinedPredicate = predicate1.or(predicate2);

			// 3 crei una nuova Map<Integer,Automobile> a partire da quella del punto 1 che
			// contenga
			// mappa che parte dalla entry
			Map<Integer, Automobile> map = supplier.get();
			// rimuovere tutte quelle che non soddisfano entrambi i predicate tramite
			// map.foreach
			Map<Integer, Automobile> filteredMap = new HashMap<>();
			// cicliamo ogni entry (coppia chiave valore)
			map.entrySet().forEach(entry -> {
				if (combinedPredicate.test(entry)) {
					filteredMap.put(entry.getKey(), entry.getValue());
				}
			});
			// 4 stampi la mappa creata al passo 3 tramite forEach
			System.out.println("\n--- Risultati Filtrati ---");
			filteredMap.forEach((id, auto) -> System.out.println("ID: " + id + " - " + auto.getModello()));

			// 5 trasformi la mappa del punto 3 in una List<Automobile>:
			// a prendendo in considerazioni solo le auto associate a chiavi positive
			// b utilizzando una Function<T,R> per la trasformazione

			// T è Entry<Integer, Automobile>, R è Automobile
			Function<Entry<Integer, Automobile>, Automobile> trasformatore = entry -> entry.getValue();
			List<Automobile> listAuto = new ArrayList<>();
			filteredMap.entrySet().forEach(entry -> {
				if (entry.getKey() > 0) {
					// Utilizziamo la Function per ottenere l'oggetto Automobile
					Automobile auto = trasformatore.apply(entry);
					listAuto.add(auto);
				}
			});
			// 6 stampi la lista del punto 5 tramite forEach
			System.out.println("\n--- Lista Finale (Solo Chiavi Positive) ---");
			listAuto.forEach(auto -> System.out.println(auto.toString()));

			// 7 ordini le automobili della mappa iniziale (quella del punto 1) in base alla
			// data di immatricolazione sfruttando una lambda expression per l’ordinamento
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Comparator<Entry<Integer, Automobile>> compareData = (d1, d2) -> {
				LocalDate data1 = LocalDate.parse(d1.getValue().getDataImmatricolazione(), formatter);
				LocalDate data2 = LocalDate.parse(d2.getValue().getDataImmatricolazione(), formatter);
				return data1.compareTo(data2);
			};
			Map<Integer, Automobile> mapOriginale = supplier.get();
			// passiamo le entry a una lista per poterle ordinare
			List<Entry<Integer, Automobile>> listaOrdinate = new ArrayList<>(mapOriginale.entrySet());
			// ordiniamo la lista usando il comparatore
			listaOrdinate.sort(compareData);
			// 8 stampi la lista del punto 7 tramite forEach
			System.out.println("\n--- Lista Automobili Ordinate Cronologicamente ---");
			listaOrdinate.forEach(auto -> {
				System.out.println(auto.toString());
			});
			// 9 ordini le automobili della mappa iniziale (quella del punto 1) in base alla
			// cilindrata sfruttando una lambda expression per l’ordinamento
			List<Entry<Integer, Automobile>> listaCilindrata = new ArrayList<>(mapOriginale.entrySet());
			listaCilindrata
					.sort((e1, e2) -> Integer.compare(e1.getValue().getCilindrata(), e2.getValue().getCilindrata()));
			// 10 stampi la lista del punto 9 tramite forEach
			System.out.println("\n--- Lista Automobili Ordinate per Cilindrata ---");
			listaCilindrata.forEach(entry -> System.out.println(entry.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
