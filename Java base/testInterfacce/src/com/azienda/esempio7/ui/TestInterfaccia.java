package com.azienda.esempio7.ui;

import com.azienda.esempio7.model.EsempioInterfaccia;
import com.azienda.esempio7.model.Impl1;
import com.azienda.esempio7.model.Impl2;

public class TestInterfaccia {
	public static void main(String[] args) {
		EsempioInterfaccia ref = new Impl1();
		ref.metodo();
		if (ref instanceof Impl1) {
			((Impl1) ref).specifico1();

		}
		ref = new Impl2();
		ref.metodo();
		if (ref instanceof Impl2) {
			((Impl2) ref).specifico2();
		}

	}

	private static void metodo1(EsempioInterfaccia x) {
		x.metodo();
	}

	private static void metodo2(Impl1 x) {
		x.metodo();
	}

	private static void metodo3(EsempioInterfaccia x) {
		x.metodo();
		if (x instanceof Impl1) {
			((Impl1) x).specifico1();
		}
	}

	private static void metodo4(Impl1 x) {
		x.metodo();
		x.specifico1();
	}
}
