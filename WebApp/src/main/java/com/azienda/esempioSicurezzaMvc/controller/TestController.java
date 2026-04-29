package com.azienda.esempioSicurezzaMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
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
			model.addAttribute("errorMessage", "Credenziali errate");
		}
		if("true".equals(logout)) {
			model.addAttribute("errorMessage", "Logout effettuato");
		}
		return "login";
	}
}
