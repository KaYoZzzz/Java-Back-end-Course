package com.azienda.esercizio2MVCSecurity.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.esercizio2MVCSecurity.model.Utente;
import com.azienda.esercizio2MVCSecurity.repos.UtenteRepository;

@Service
@Transactional
//Implementando UserDetailsService, questa classe viene registrata automaticamente 
//da Spring Security come il fornitore ufficiale di utenti.
public class UtenteService implements UserDetailsService {

	private final UtenteRepository utenteRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UtenteService(UtenteRepository utenteRepository, BCryptPasswordEncoder passwordEncoder) {
		this.utenteRepository = utenteRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Questo è IL metodo più importante per il login.
	// Quando l'utente preme "Accedi" nel form HTML, Spring Security prende
	// l'username inserito e lo passa a questo metodo. Il tuo compito qui è solo
	// cercare l'utente nel DB.
	// Spring Security si occuperà poi, da solo, di confrontare la password.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return utenteRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}

	private void createUtente(String s) {
		Utente u = utenteRepository.findByUsername(s).orElse(null);
		if (u == null) {
			u = new Utente();
			u.setUsername(s);
			// REGOLE DI SICUREZZA: Le password non vanno mai salvate in chiaro nel DB.
			// Qui usi il passwordEncoder (BCrypt) per criptare la password prima di
			// salvarla.
			// Questo si allaccia a Spring Security che userà lo stesso algoritmo per
			// verificare la password digitata durante il login.
			u.setPassword(passwordEncoder.encode(s));
			utenteRepository.save(u);
		}
	}

	public void init() {
		createUtente("admin");
		createUtente("user");
	}
}