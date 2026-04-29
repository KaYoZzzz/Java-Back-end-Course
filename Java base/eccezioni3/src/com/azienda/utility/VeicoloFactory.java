package com.azienda.utility;

import java.util.Scanner;

import com.azienda.common.Constants;
import com.azienda.customException.VeicoloNonValidoException;
import com.azienda.model.Aereo;
import com.azienda.model.Treno;
import com.azienda.model.Veicolo;

public class VeicoloFactory {
	public static Veicolo createVehicle(String veicoloString, Scanner scanner) {
		String modello;
		float velocita;
		boolean isDiLinea;
		boolean isRegionale;
		Veicolo veicolo = null;

		while (veicolo == null) {
			try {
				ValidatoreVeicolo.checkVehicle(veicoloString);
				if (veicoloString.toLowerCase().equals(Constants.AEREO)) {
					veicolo = new Aereo(null, 0, false);
				} else if (veicoloString.toLowerCase().equals(Constants.TRENO)) {
					veicolo = new Treno(null, 0, false);
				}
			} catch (VeicoloNonValidoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				System.out.println("Inserire tipo veicolo (" + Constants.AEREO + " o " + Constants.TRENO + "):");
				veicoloString = scanner.nextLine(); // Richiedo input in caso di errore
			}
		}
		System.out.println("inserire modello");
		modello = scanner.nextLine();
		velocita = ValidatoreTipo.checkFloat(scanner, "Inserire velocità media");
		veicolo.setVelocita(velocita);
		veicolo.setModello(modello);
		if (veicolo instanceof Aereo) {
			isDiLinea = ValidatoreTipo.checkBoolean(scanner, "L'aereo è di linea? (true, false)");
			((Aereo) veicolo).setDiLinea(isDiLinea);
		} else if (veicolo instanceof Treno) {
			isRegionale = ValidatoreTipo.checkBoolean(scanner, "Il treno è regionale? (true, false)");
			((Treno) veicolo).setRegionale(isRegionale);
		}
		return veicolo;

	}
}
