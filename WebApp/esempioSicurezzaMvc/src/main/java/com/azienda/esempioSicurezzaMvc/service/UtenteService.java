package com.azienda.esempioSicurezzaMvc.service;

import org.springframework.security.access.prepost.PreAuthorize;
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
public class UtenteService implements UserDetailsService{

	private final UtenteRepository utenteRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UtenteService(UtenteRepository utenteRepository, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.utenteRepository = utenteRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utente u = utenteRepository.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("Username not found") );
		return u;
	}

	private void creatUser(String s) {
		Utente admin = utenteRepository.findByUsername(s).orElse(null);
		if(admin == null) {
			admin = new Utente();
			admin.setUsername(s);
			admin.setPassword(passwordEncoder.encode(s));
			utenteRepository.save(admin);
		}
	}

	public void init() {
		creatUser("admin");
		creatUser("user");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void test() {
		System.out.println("Test security");
	}

}
