package com.azienda.esercizio1Mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.azienda.esercizio1Mvc.model.Indirizzo;
import com.azienda.esercizio1Mvc.model.ParametriRicerca;

@Controller
public class IndirizzoController {
	// Attributo privato come richiesto
	private final List<Indirizzo> listaIndirizzi = new ArrayList<>();

	// Costruttore per inizializzare la lista
	public IndirizzoController() {
		this.listaIndirizzi.add(new Indirizzo("Milano", "Via Roma", "10"));
		this.listaIndirizzi.add(new Indirizzo("Roma", "Via Milano", "25"));
		this.listaIndirizzi.add(new Indirizzo("Napoli", "Corso Umberto", "5"));
	}

	@GetMapping("/indirizzi")
	public String getAllIndirizzi(Model model) {
		model.addAttribute("elenco", listaIndirizzi);
		return "listaIndirizzi";
	}

	@GetMapping("/getParIndirizzi/{parametro}")
	public String getParIndirizzi(@PathVariable("parametro") String parametro, Model model) {
		List<Indirizzo> resultList = new ArrayList<>();
		for (Indirizzo indirizzo : listaIndirizzi) {
			if (indirizzo.getCitta().toLowerCase().contains(parametro.toLowerCase())) {
				resultList.add(indirizzo);
			}
		}
		model.addAttribute("elenco", resultList);
		return "listaIndirizzi";
	}

//////////

	// Inizializza l'oggetto della form per ogni richiesta
	@ModelAttribute("parametriRicerca")
	public ParametriRicerca initParametri() {
		return new ParametriRicerca("Milano", "Via Milano");
	}

	@GetMapping("/goToRicerca")
	public String goToRicerca() {
		return "ricerca"; // Nome della JSP con la form
	}

	@PostMapping("/ricercaIndirizzi")
	public String ricerca(@ModelAttribute("parametriRicerca") ParametriRicerca p, Model model) {
		List<Indirizzo> risultati = new ArrayList<>();

		for (Indirizzo ind : listaIndirizzi) {
			// Logica: cerchiamo se città o via contengono quanto inserito nella form
			boolean matchCitta = p.getCitta() != null && !p.getCitta().isBlank()
					&& ind.getCitta().toLowerCase().contains(p.getCitta().toLowerCase());

			boolean matchVia = p.getVia() != null && !p.getVia().isBlank()
					&& ind.getVia().toLowerCase().contains(p.getVia().toLowerCase());

			if (matchCitta || matchVia) {
				risultati.add(ind);
			}
		}

		model.addAttribute("elenco", risultati);
		return "listaIndirizzi"; // Riutilizziamo la JSP che mostra la tabella
	}
}
