package com.azienda.esempioSicurezzaMvc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azienda.esempioSicurezzaMvc.model.Utente;
import com.azienda.esempioSicurezzaMvc.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService implements UserDetailsService{ // non si dovrebbe implementare qui
	private final UtenteRepository utenteRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UtenteService(UtenteRepository utenteRepository, BCryptPasswordEncoder passwordEncoder) {
		this.utenteRepository = utenteRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente utente = utenteRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("Username not found") );
		return utente;
	}
	
	public void init() {
		createUser("admin");
		createUser("user");
	}
	
	private void createUser(String username) {
		Utente utente = utenteRepository.findByUsername(username).orElse(null);
		if (utente == null) {
			utente = new Utente();
			utente.setUsername(username);
			utente.setPassword(passwordEncoder.encode(username));
			utenteRepository.save(utente);
		}
	}

}
