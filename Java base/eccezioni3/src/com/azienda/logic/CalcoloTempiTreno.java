package com.azienda.logic;

import com.azienda.customException.VeicoloNonValidoException;
import com.azienda.model.Treno;
import com.azienda.model.Veicolo;

public class CalcoloTempiTreno extends CalcolaTempiAbstract {

	public CalcoloTempiTreno() {
		super();
	}

	@Override
	public void informazioniMovimento(Veicolo veicolo) throws VeicoloNonValidoException {
		// TODO Auto-generated method stub
		if (veicolo instanceof Treno) {
			System.out.println(((Treno) veicolo).percorreBinari());
		} else {
			throw new VeicoloNonValidoException("Errore, non è un treno");
		}

	}

}
