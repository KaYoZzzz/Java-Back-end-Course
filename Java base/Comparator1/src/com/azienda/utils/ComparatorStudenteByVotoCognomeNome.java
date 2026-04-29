package com.azienda.utils;

import java.util.Comparator;

import com.azienda.model.Studente;

public class ComparatorStudenteByVotoCognomeNome implements Comparator<Studente> {

	@Override
	public int compare(Studente s1, Studente s2) {
		// TODO Auto-generated method stub
		// 1. Confronto per Voto (Decrescente: s2 vs s1)
		int risultatoVoto = s2.getMediaVoti().compareTo(s1.getMediaVoti());
		if (risultatoVoto != 0) {
			return risultatoVoto;
		}
		// 2. Se il voto è uguale, confronto per Cognome (Crescente: s1 vs s2)
		int risultatoCognome = s1.getCognome().compareToIgnoreCase(s2.getCognome());

		if (risultatoCognome != 0) {
			return risultatoCognome;
		}

		// 3. Se anche il cognome è uguale, confronto per Nome (Crescente)
		return s1.getNome().compareToIgnoreCase(s2.getNome());
	}

}
