package com.azienda.esempio2.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
	public static void main(String[] args) {
		try {
			Predicate<String> predicate = s1 -> s1.length() > 8;
			boolean b = predicate.test("Buongiorno");
			System.out.println(b);
			List<String> nomi = Arrays.asList("Mario", "Giovanna", "Francesco", "Mariagrazia");
			List<String> risultati = new ArrayList<String>();
			for (String s : nomi) {
				if (predicate.test(s)) {
					risultati.add(s);
				}
			}
			risultati.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
