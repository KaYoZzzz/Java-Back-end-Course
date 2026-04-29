package com.azienda.esempio1.ui;

import com.azienda.esempio1.model.InterfacciaFunzionale;
import com.azienda.esempio1.utils.Utility;

public class TestLambda2 {
	public static void main(String[] args) {
		try {
			InterfacciaFunzionale ref = x -> System.out.println(x);
			ref.metodo("Mario");
			InterfacciaFunzionale ref2 = System.out::println;
			ref2.metodo("Paolo");
			System.out.println(Utility.util(4, 5f, false));
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
