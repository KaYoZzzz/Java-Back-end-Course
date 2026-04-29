package com.azienda.esercizio2MVCSecurity.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; // <-- INTERFACCIA CHIAVE

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@SuppressWarnings("serial")
@Entity
//Implementando UserDetails, stai dicendo a Spring Security: 
//"Tratta questa classe come l'entità ufficiale che rappresenta un utente loggato".
public class Utente implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String password;

	// Questo metodo è richiesto da UserDetails.
	// Serve a Spring Security per capire quali "permessi" (Roles) ha l'utente.
	// Si allaccia direttamente a SecurityConfig.java: quando lì scrivi
	// .hasRole("ADMIN"),
	// Spring Security chiama questo metodo per verificare se l'utente ha
	// "ROLE_ADMIN".
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// NOTA OGGETTIVA SUL RAGIONAMENTO:
		// Per un esercizio va bene, ma legare i ruoli direttamente al nome utente (if
		// "admin".equals(username))
		// è un approccio fragile. In un'applicazione reale, se crei un secondo
		// amministratore chiamato "mario",
		// non avrà i permessi. La soluzione corretta sarebbe aggiungere una colonna
		// "ruolo" (es. una String o una lista di ruoli)
		// nel database e leggere da lì, anziché fare controlli hardcoded sull'username.
		if ("admin".equals(username)) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}
		if ("user".equals(username)) {
			return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
		return null;
	}

	// Metodo richiesto da UserDetails. Spring Security lo userà in automatico
	// per confrontare la password digitata nel form di login con questa salvata nel
	// DB.
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	// di default questi sono stati messi da UserDetails a true nelle versioni più
	// recenti, quindi non è necessario implementarli
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}