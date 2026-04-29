package com.azienda.esempioSicurezzaMvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
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
	public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {
		return http.authorizeHttpRequests(
				(httpRequests) ->
				httpRequests.requestMatchers("/resources/**").permitAll().
				requestMatchers("/usr").hasRole("USER").
				requestMatchers("/admin").hasRole("ADMIN").
				anyRequest().permitAll()
				)
				.formLogin( form ->
				form.loginPage("/loginPage").permitAll().defaultSuccessUrl("/usr").
				failureUrl("/loginPage?error=true").usernameParameter("un").
				passwordParameter("pwd")
						).
				logout( logout -> logout.logoutSuccessUrl("/loginPage?logout=true").invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll())
				//.csrf( csrfConf -> csrfConf.disable())
				.build();
	}
	

}
