package com.azienda.classiAvanzate.parteB.esercizi.a;

import java.util.Objects;

public class B extends A {

	private String s;
	private float f;

	public B(String sPadre, int iPadre, float f) {
		super(sPadre, iPadre);
		this.f = f;
	}

	@Override
	public String getS() {
		return s;
	}

	@Override
	public void setS(String s) {
		this.s = s;
	}

	public String getParentS() {
		return super.s;
	}

	public void setParentS(String s) {
		super.s = s;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	@Override
	public String toString() {
		return "stringa s(child): " + this.s + "  - float: " + this.f;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(f, s);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		B other = (B) obj;
		return Float.floatToIntBits(f) == Float.floatToIntBits(other.f) && Objects.equals(s, other.s);
	}

}
