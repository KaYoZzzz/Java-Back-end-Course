package com.azienda.logic;

import com.azienda.model.Veicolo;

public abstract class CalcolaTempiAbstract implements CalcolaTempi {

	@Override
	public float calcolaTempiPercorrenza(Veicolo veicolo, float distanza) {
		// TODO Auto-generated method stub
		return distanza / veicolo.getVelocita();
	}

}
