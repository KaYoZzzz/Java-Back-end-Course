package com.azienda.utilitaJdk.parteA.esercizi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(15, "Mario");
			map.put(15, "Luigi"); // sovrascrive mario con luigi
			map.put(-12, "Eva");
			map.put(4, "Giovanni");
			System.out.println("Numeri di coppie: " + map.size());
			boolean b = map.containsKey(4);// true
			b = map.containsKey(3);// false
			b = map.containsValue("Giovanni");// true
			String nome = map.get(4); // chiave 4 -> Giovanni
			nome = map.get(1); // chiave 1 -> Null
			map.remove(-12); // rimuove Eva
			map.remove(1); // non fa niente

			System.out.println("Accesso tramite le chiavi (n+1 accessi)");
			Set<Integer> chiavi = map.keySet(); // copia tutte le chiavi della mappa nel set

			for (Integer chiave : chiavi) {
				String valore = map.get(chiave);
				System.out.println(chiave + " - " + valore);
			}
			System.out.println("Accesso tramite set delle coppie (un accesso)");
			// per avere una coppia in un set, bisogna utilizzare la classe Entry
			// all'interno di Set
			Set<Entry<Integer, String>> coppie = map.entrySet();
			for (Entry<Integer, String> coppia : coppie) {
				System.out.println(coppia.getKey() + " - " + coppia.getValue());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
