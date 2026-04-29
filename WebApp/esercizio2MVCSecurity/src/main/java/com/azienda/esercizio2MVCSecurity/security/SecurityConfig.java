package com.azienda.esercizio2MVCSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType; // <-- Aggiunta

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				// 1. Permette a Spring di gestire i forward interni (es. il passaggio da un
				// Controller a una JSP)
				// senza far scattare un blocco di sicurezza inappropriato.
				.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()

				// 2. Rende pubbliche le risorse di base. Chiunque, anche non loggato,
				// può vedere la pagina di login ed elaborare le risorse statiche (CSS/JS).
				.requestMatchers("/loginPage", "/login", "/css/**", "/js/**").permitAll()

				// 3. Regola di Autorizzazione: Solo gli utenti a cui è stato assegnato il ruolo
				// "ADMIN"
				// (definito nel file Utente.java) possono visitare le pagine di
				// inserimento.
				.requestMatchers("/goToInserisci", "/inserisciIndirizzo").hasRole("ADMIN")

				// 4. Regola di Autorizzazione: Sia gli utenti normali ("USER") che gli
				// amministratori ("ADMIN")
				// possono vedere la lista degli indirizzi e usare la barra di ricerca.
				.requestMatchers("/indirizzi", "/getParIndirizzi/**", "/goToRicerca", "/ricercaIndirizzi")
				.hasAnyRole("USER", "ADMIN")

				// 5. Regola di chiusura (Catch-all): Qualsiasi altro URL non specificato
				// esplicitamente
				// sopra richiederà che l'utente sia almeno loggato.
				.anyRequest().authenticated())

				// Configurazione del Form di Login
				.formLogin(form -> form.loginPage("/loginPage") // Dici a Spring di usare il tuo endpoint custom, non la
																// sua pagina di default.
						.loginProcessingUrl("/loginPage") // L'URL a cui il form HTML (nella JSP) fa la POST. Spring
															// lo intercetta in automatico.
						.permitAll().defaultSuccessUrl("/indirizzi", true) // Dove reindirizzare se le credenziali sono
																			// corrette.
						.failureUrl("/loginPage?error=true") // Dove reindirizzare se le credenziali sono sbagliate.
						.usernameParameter("un") // Spring di default si aspetta che l'input HTML si chiami "username",
													// qui gli dici di cercare "un".
						.passwordParameter("pwd")) // Stessa cosa: gli dici di cercare l'input HTML "pwd" invece di
													// "password".

				// Configurazione del Logout
				.logout(logout -> logout.logoutSuccessUrl("/loginPage?logout=true").invalidateHttpSession(true) // Distrugge
																												// la
																												// sessione
																												// dell'utente
																												// sul
																												// server.
						.deleteCookies("JSESSIONID") // Elimina il cookie di sessione dal browser, completando l'uscita.
						.permitAll());

		return http.build();
	}
}