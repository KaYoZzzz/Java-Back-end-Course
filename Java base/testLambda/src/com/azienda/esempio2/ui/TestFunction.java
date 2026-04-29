package com.azienda.esempio2.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class TestFunction {
	public static void main(String[] args) {
		try {
			// il primo è parametro di input, il secondo di output
			Function<String, Integer> function = x -> x.length();
			int lunghezza = function.apply("Swag");
			System.out.println(lunghezza);
			// crea una funzione che data una mappa con chiave integer e valore string,
			// metta le stringhe nella lista
			Function<Map<Integer, String>, List<String>> function2 = m -> new ArrayList<String>(m.values());
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(1, "Mario");
			map.put(2, "Emilia");
			map.put(3, "Claudia");
			function2.apply(map).forEach(System.out::println);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
