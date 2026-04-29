package com.azienda.classiAvanzate.parteB.esercizi.a;

import java.util.Objects;

public class A {
	protected String s;
	protected int i;

	public A(String s, int i) {
		super();
		this.s = s;
		this.i = i;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "La stringa S vale:" + s + "\nLa stringa I vale:" + i;
	}

	// fare in modo in modo che l’uguaglianza di due oggetti di classe A sia basata
	// sull’uguaglianza dei valori degli attributi s ed i

	@Override
	public int hashCode() {
		return Objects.hash(i, s);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		A other = (A) obj;
		return i == other.i && Objects.equals(s, other.s);
	}

}
