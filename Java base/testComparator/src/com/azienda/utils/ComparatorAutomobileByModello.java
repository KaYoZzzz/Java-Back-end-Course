package com.azienda.utils;

import java.util.Comparator;

import com.azienda.model.Automobile;

public class ComparatorAutomobileByModello implements Comparator<Automobile> {

	@Override
	public int compare(Automobile o1, Automobile o2) {
		// TODO Auto-generated method stub

		int risultatoConfronto = o1.getModello().compareTo(o2.getModello());
		if (risultatoConfronto != 0) {
			return risultatoConfronto;
		}
		return o1.getCilindrata().compareTo(o2.getCilindrata());
	}

}
