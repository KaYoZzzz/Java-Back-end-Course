package com.azienda.esempio2.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TestConsumer {
	public static void main(String[] args) {
		try {
			List<String> nomi = Arrays.asList("Mario", "Laura", "Claudia");
			Consumer<String> lambda = x -> System.out.println(x);
			lambda.accept("Pippo");
			nomi.forEach(lambda);
			nomi.forEach(x -> System.out.println(x));
			nomi.forEach(System.out::println);
			customForEach(nomi, System.out::println);
			BiConsumer<Integer, String> lambda2 = (x, y) -> System.out.println(x + " " + y);
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(1, "Mario");
			map.put(2, "Laura");
			map.put(3, "Claudia");
			map.forEach(lambda2);
			map.forEach((x, y) -> System.out.println(x + " " + y));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void customForEach(List<String> l, Consumer<String> c) {
		for (String s : l) {
			c.accept(s);
		}
	}
}
