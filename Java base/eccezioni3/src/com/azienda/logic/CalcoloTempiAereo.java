package com.azienda.logic;

import com.azienda.customException.VeicoloNonValidoException;
import com.azienda.model.Aereo;
import com.azienda.model.Veicolo;

public class CalcoloTempiAereo extends CalcolaTempiAbstract {

	public CalcoloTempiAereo() {
		super();
	}

	@Override
	public void informazioniMovimento(Veicolo veicolo) throws VeicoloNonValidoException {
		// TODO Auto-generated method stub
		if (veicolo instanceof Aereo) {
			System.out.println(((Aereo) veicolo).vola());
		} else {
			throw new VeicoloNonValidoException("Errore, non è un aereo");
		}

	}

}
