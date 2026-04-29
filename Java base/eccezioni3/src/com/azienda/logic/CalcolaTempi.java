package com.azienda.logic;

import com.azienda.customException.VeicoloNonValidoException;
import com.azienda.model.Veicolo;

public interface CalcolaTempi {

	public float calcolaTempiPercorrenza(Veicolo veicolo, float distanza);

	public void informazioniMovimento(Veicolo veicolo) throws VeicoloNonValidoException;

}
