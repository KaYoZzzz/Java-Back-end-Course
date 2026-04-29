package com.azienda.EsempioMvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.azienda.EsempioMvc.model.Persona;

import jakarta.servlet.http.HttpServletRequest;

@Controller
//dichiaro che questo attributo viene messo in sessione
@SessionAttributes({ "chiaveForm" })
public class TestController {
	@GetMapping("/home")
	public String goToHome() {

		return "home";
	}

	// puoi provarlo facendo http://localhost:8080/benvenuto
	@GetMapping("/benvenuto")
	// model è sinonimo di request
	public String benvenuto(Model model) {
		Persona p = new Persona("Mario", "Rossi");
		// come fare request.setattribute
		model.addAttribute("chiavePersona", p);
		return "benvenuto";
	}

	// puoi provarlo facendo http://localhost:8080/ciao?n=Davide&c=Santoro
	@GetMapping("/ciao")
	public String ciao(@RequestParam("n") String nome, @RequestParam("c") String cognome, Model model) {
		Persona p = new Persona(nome, cognome);
		model.addAttribute("chiavePersona", p);
		return "benvenuto";
	}

	// puoi provarlo facendo http://localhost:8080/salve/Paolo/Bonolis
	@GetMapping("/salve/{n}/{c}")
	public String salve(@PathVariable("n") String nome, @PathVariable("c") String cognome, Model model) {
		Persona p = new Persona(nome, cognome);
		model.addAttribute("chiavePersona", p);
		// definisce in quale jsp deve finire
		return "benvenuto";
	}

	@GetMapping("/afterFwRed")
	public String afterFwRed(Model model, HttpServletRequest request) {
		String nome = request.getParameter("n");
		String cognome = request.getParameter("c");
		Persona p = new Persona(nome, cognome);
		model.addAttribute("chiavePersona", p);
		// definisce in quale jsp deve finire
		return "benvenuto";
	}

	// chiamando forward (http://localhost:8080/forward?n=Davide&c=Santoro), lei fa
	// un forward ad afterFwRed che porta tutto sulla
	// pagina di benvenuto
	@GetMapping("/forward")
	public String forward(@RequestParam("n") String nome, @RequestParam("c") String cognome, Model model) {
		// forward: (lo fa di default se non viene scritto) parola chiave per fare
		// capire a spring che vuoi fare una forward.
		// viene mantenuta la stessa request, quindi i dati vengono passati
		return "forward:/afterFwRed";
	}

	@GetMapping("/redirect")
	public String redirect(@RequestParam("n") String nome, @RequestParam("c") String cognome, Model model) {
		// redirect: parola chiave per fare capire a spring che vuoi fare una redirect.
		// viene creata una nuova request, quindi i dati non esistono
		return "redirect:/afterFwRed";
		// return "redirect:/afterFwRed?n="+nome+"&c="+cognome;
		// questo fa effettivamente passare i dati, con sempre però una nuova request
	}

	@GetMapping("/lista")
	public String lista(Model model) {
		List<Persona> persone = Arrays.asList(new Persona("Mario", "Rossi"), new Persona("Luigi", "Verdi"),
				new Persona("Wario", "Gialli"));
		model.addAttribute("chiaveLista", persone); // come request.setAttribute
		return "elenco";
	}

/////////////////////////////
	// parti da qui
	@GetMapping("/goToRicerca")
	public String goToRicerca() {
		return "ricerca";
	}

	// Se non è in sessione, su ogni request, anche se chiami un metodo che non
	// c'entra niente come home,
	// passa sempre da qui
	@ModelAttribute("chiaveForm")
	public Persona initForm() {
		return new Persona("Paolo", "Bonolis");
	}

	@PostMapping("/ricerca")
	public String ricerca(Model model, @ModelAttribute("chiaveForm") Persona p) {
		model.addAttribute("chiavePersona", p);
		return "benvenuto";
	}
/////////////////////////////

}
