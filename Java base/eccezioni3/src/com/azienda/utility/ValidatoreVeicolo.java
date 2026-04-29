package com.azienda.utility;

import com.azienda.common.Constants;
import com.azienda.customException.VeicoloNonValidoException;

public class ValidatoreVeicolo {
	public static void checkVehicle(String v) throws VeicoloNonValidoException {
		if (!v.toLowerCase().equals(Constants.AEREO) && !v.toLowerCase().equals(Constants.TRENO)) {
			throw new VeicoloNonValidoException("Veicolo " + v + " non usabile");
		}
	}
}
