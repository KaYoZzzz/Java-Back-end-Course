package com.azienda.control;

import com.azienda.model.NumeroNegativoException;
import com.azienda.model.NumeroZeroException;

public class Controller {
	public static void checkPositive(int checked) throws NumeroNegativoException {
		if (checked < 0) {
			throw new NumeroNegativoException("Numero minore di 0", null);
		}

	}

	public static void checkNotZero(int checked) throws NumeroZeroException {
		if (checked == 0) {
			throw new NumeroZeroException("Numero uguale a 0", null);
		}
	}
}
