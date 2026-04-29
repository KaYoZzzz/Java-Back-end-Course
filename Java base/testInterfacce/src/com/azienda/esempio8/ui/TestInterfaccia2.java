package com.azienda.esempio8.ui;

import com.azienda.esempio8.model.A;
import com.azienda.esempio8.model.ConcretaA;
import com.azienda.esempio8.model.ConcretaC;

public class TestInterfaccia2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A ref = new ConcretaA();
		ref.metodoA();
		ref = new ConcretaC();
		ref.metodoA();
		if (ref instanceof ConcretaC) {
			((ConcretaC) ref).metodoB();
			((ConcretaC) ref).metodoC();
		}
	}

}
