package com.azienda.esempioSicurezzaMvc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.azienda.esempioSicurezzaMvc.service.UtenteService;

@Controller
public class TestController {
	
	private final UtenteService utenteService;
	
	
	public TestController(UtenteService utenteService) {
		super();
		this.utenteService = utenteService;
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/usr")
	public String usr() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/loginPage")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		if("true".equals(error)) {
			model.addAttribute("errorMessage", "Credenziali Errate");
		}
		if("true".equals(logout)) {
			model.addAttribute("errorMessage", "Logout Effetuato");
		}
		return "login";
	}
	
	@GetMapping("/test")
	public String test(Principal prin) {
		utenteService.test();
		return "home";
	}
	
	
}
