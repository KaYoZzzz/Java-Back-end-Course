package com.azienda.esempio1.ui;

import com.azienda.esempio1.model.InterfacciaFunzionale;
import com.azienda.esempio1.model.InterfacciaFunzionale2;

public class TestLambda {
	public static void main(String[] args) {
		try {

			InterfacciaFunzionale ref = (s) -> {
				System.out.println("ricevuto in input " + s);
				System.out.println("Trasformato in maiuscolo " + s.toUpperCase());
			};
			ref.metodo("ciao");
			///////////////////////////////////////
			InterfacciaFunzionale ref2 = (s) -> {
				if (s.length() >= 4) {
					System.out.println(s.substring(2));
				} else {
					System.out.println("Stringa più corta di 4 caratteri");
				}
			};
			ref2.metodo("buongiorno");
			//////////////////////////////////////
			InterfacciaFunzionale2 ref3 = (a, b, c) -> {
				System.out.println("Ricevuti in input " + a + ", " + b + ", " + c);
				return "Output " + a + ", " + b + ", " + c;
			};
			String risultato = ref3.metodo("Ciao", "Paolo", "Addio");
			System.out.println(risultato);
			/////////////////////////////////////
			InterfacciaFunzionale ref4 = (s) -> System.out.println(s);
			ref4.metodo("Ciao");
			test(ref4);
			/////////////////////////////////////
			InterfacciaFunzionale2 ref5 = (a, b, c) -> "Output " + a + ", " + b + ", " + c;
			System.out.println(ref5.metodo("Ciao", "Paolo", "Addio"));
			/////////////////////////////////////
			test(x -> System.out.println(x.toUpperCase()));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void test(InterfacciaFunzionale ref) {
		ref.metodo("Pippo");
	}
}
