package com.azienda.esempio2.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class TestSupplier {
	public static void main(String[] args) {
		try {
			Supplier<Integer> supplier = () -> new Random().nextInt(11);
			Integer numeroInteger = supplier.get();
			System.out.println(numeroInteger);

			Supplier<List<String>> supplier2 = () -> {
				List<String> nomi = new ArrayList<String>();
				nomi.add("Mario");
				nomi.add("Laura");
				nomi.add("Claudia");
				return nomi;
			};

			supplier2.get().forEach(x -> System.out.println(x));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
