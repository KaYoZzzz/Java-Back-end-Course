package com.azienda.view;

import java.util.Scanner;

import com.azienda.model.Aereo;
import com.azienda.model.Automobile;
import com.azienda.model.Nave;
import com.azienda.model.Treno;
import com.azienda.model.Veicolo;

public class TestVeicolo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Veicolo veicolo = null;

		System.out.println("Quale veicolo vuoi creare?");
		System.out.println("1) Automobile\n2) Treno\n3) Aereo\n4) Nave");
		int scelta = scanner.nextInt();

		System.out.println("Inserisci la velocità massima:");
		int vMax = scanner.nextInt();

		switch (scelta) {
		case 1 -> veicolo = new Automobile(1400);
		case 2 -> veicolo = new Treno("Milano", "Napoli");
		case 3 -> veicolo = new Aereo(true);
		case 4 -> veicolo = new Nave(1550);
		default -> System.out.println("Scelta non valida.");
		}

		stampaInfo(veicolo, vMax);
		scanner.close();
	}

	private static void stampaInfo(Veicolo v, int vMax) {
		v.setVelocitaMax(vMax);
		v.getVelocitaMax();
		if (v instanceof Automobile) {
			((Automobile) v).getCilindrata();
		} else if (v instanceof Treno) {
			((Treno) v).getLocalitaPartenza();
			((Treno) v).getLocalitaArrivo();

		} else if (v instanceof Aereo) {
			((Aereo) v).isDiLinea();
		} else {
			((Nave) v).getNumeroCabine();
		}
		System.out.println(v.toString());
	}
}
