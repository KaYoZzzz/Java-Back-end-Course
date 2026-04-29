package com.azienda.view;

import java.util.Scanner;

import com.azienda.logic.CalcolaTempi;
import com.azienda.logic.CalcoloTempiAereo;
import com.azienda.logic.CalcoloTempiTreno;
import com.azienda.model.Aereo;
import com.azienda.model.Treno;
import com.azienda.model.Veicolo;
import com.azienda.utility.ValidatoreTipo;
import com.azienda.utility.VeicoloFactory;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Che tipo di veicolo vuoi utilizzare?\nAereo\nTreno\nESC");
			String veicoloString = scanner.nextLine().toLowerCase();

			if (veicoloString.equals("esc")) {
				scanner.close();
				return;
			} else {
				Veicolo v = VeicoloFactory.createVehicle(veicoloString, scanner);
				Float distanza = ValidatoreTipo.checkFloat(scanner, "Digitare la distanza da percorrere");

				CalcolaTempi logic = null;
				if (v instanceof Aereo) {
					logic = new CalcoloTempiAereo();
				} else if (v instanceof Treno) {
					logic = new CalcoloTempiTreno();
				}
				float tempo = logic.calcolaTempiPercorrenza(v, distanza);
				System.out.println("Tempo stimato per " + v.getModello() + ": " + tempo + " ore");
				scanner.next();
			}
		}
	}
}
