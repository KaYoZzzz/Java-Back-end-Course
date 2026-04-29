package com.azienda.esercizio2MVCSecurity.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	// L'URL "/loginPage" è lo stesso che va definito in SecurityConfig.java
	// all'interno di .formLogin(form -> form.loginPage("/loginPage")).
	@GetMapping("/loginPage")
	public String loginPage(Model model,
			// Questo parametro si allaccia a .failureUrl("/loginPage?error=true") nel
			// SecurityConfig
			@RequestParam(value = "error", required = false) String error,
			// Questo parametro si allaccia a .logoutSuccessUrl("/loginPage?logout=true")
			// nel SecurityConfig
			@RequestParam(value = "logout", required = false) String logout) {
		// Se Spring Security ha reindirizzato qui a causa di un login fallito, entra in
		// questo if.
		if ("true".equals(error)) {
			model.addAttribute("errorMessage", "Credenziali errate. Riprova.");
		}
		// Se Spring Security ha reindirizzato qui dopo un logout concluso, entra in
		// questo if.
		if ("true".equals(logout)) {
			model.addAttribute("successMessage", "Logout effettuato con successo.");
		}
		return "login";
	}
}