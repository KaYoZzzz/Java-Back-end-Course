package com.azienda.esercizio2MVC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.azienda.esercizio2MVC.model.Indirizzo;
import com.azienda.esercizio2MVC.model.ParametriRicerca;
import com.azienda.esercizio2MVC.service.ApplicationService;

import jakarta.annotation.PostConstruct;

@Controller
public class IndirizzoController {

	@Autowired
	private ApplicationService service;

	// Costruttore per inizializzare la lista
	public IndirizzoController() {
	}

	@PostConstruct
	public void init() {
		// Questo metodo viene chiamato da Spring DOPO che il service è stato iniettato
		service.insertIndirizzo("Milano", "Via Roma", "10");
		service.insertIndirizzo("Roma", "Via Milano", "25");
		service.insertIndirizzo("Napoli", "Corso Umberto", "5");
	}

	@GetMapping("/indirizzi")
	public String getAllIndirizzi(Model model) {
		model.addAttribute("elenco", service.findAllIndirizzi());
		return "listaIndirizzi";
	}

	@GetMapping("/getParIndirizzi/{parametro}")
	public String getParIndirizzi(@PathVariable("parametro") String parametro, Model model) {
		List<Indirizzo> resultList = new ArrayList<>();
		resultList = service.findByCitta(parametro);
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

		risultati = service.findByCittaOrVia(p.getCitta(), p.getVia());

		model.addAttribute("elenco", risultati);
		return "listaIndirizzi"; // Riutilizziamo la JSP che mostra la tabella
	}

	@GetMapping("/goToInserisci")
	public String inserisci(Model model) {
		model.addAttribute("nuovoIndirizzo", new Indirizzo());
		return "inserisci";
	}

	@PostMapping("/inserisciIndirizzo")
	public String inserisciIndirizzo(@ModelAttribute("nuovoIndirizzo") Indirizzo nuovoIndirizzo) {

		// Passiamo i dati estratti dal form al metodo del tuo service
		service.insertIndirizzo(nuovoIndirizzo.getCitta(), nuovoIndirizzo.getVia(), nuovoIndirizzo.getCivico());

		// Reindirizziamo l'utente alla lista completa per mostrare il nuovo dato
		return "redirect:/indirizzi";
	}
}
