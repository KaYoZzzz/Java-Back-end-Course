package com.azienda.esempio10.ui;

import com.azienda.esempio10.model.Concreta1;
import com.azienda.esempio10.model.Concreta2;
import com.azienda.esempio10.model.EsempioAstratta;

public class TestAstratta {
	public static void main(String[] args) {
		EsempioAstratta ref = new Concreta1();
		ref.metodoAstratto();
		ref.metodoConcreto();
		if (ref instanceof Concreta1) {
			((Concreta1) ref).specifico1();
		}
		ref = new Concreta2();
		ref.metodoAstratto();
		ref.metodoConcreto();
		if (ref instanceof Concreta2) {
			((Concreta2) ref).specifico2();

		}

		metodo1(ref);
	}

	// best practice, più flessibile
	private static void metodo1(EsempioAstratta x) {
		System.out.println("\n");
		x.metodoConcreto();
		x.metodoAstratto();
	}

	// sbagliato!!
	private static void metodo2(Concreta1 x) {

		System.out.println("\n");
		x.metodoConcreto();
		x.metodoAstratto();
	}

	// best practice
	private static void metodo3(EsempioAstratta x) {

		System.out.println("\n");
		x.metodoConcreto();
		x.metodoAstratto();

		if (x instanceof Concreta1) {
			((Concreta1) x).specifico1();
		}
	}

	// OK, solo se serve un metodo specifico di una particolare classe
	private static void metodo4(Concreta1 x) {

		System.out.println("\n");
		x.metodoConcreto();
		x.metodoAstratto();
		x.specifico1();
	}
}
