package com.azienda.esempioSpringData.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Lavoratore {
	// chiave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer matricola;
	private Float stipendio;

	// lato proprietario della relazione. fa capire a persona che sono collegate
	// (1,1)
	// Poiché qui non c'è mappedBy, JPA creerà in questa tabella una colonna (di
	// default persona_id) che farà da Foreign Key verso la tabella Persona
	@OneToOne
	private Persona persona;

	// per quanto il modello ER ci insegna a dire "un lavoratore sta in una
	// azienda", bisogna pensarla nel collettivo,
	// quindi più lavoratori possono stare in una sede
	@ManyToOne
	// @JoinColumn name = .. è opzionale se si vuole dare un nome custom alla
	// foreign key
	@JoinColumn(name = "id_sede")
	private Sede sede;
	@ManyToMany
	@JoinTable(name = "lavoratore_ruolo", joinColumns = @JoinColumn(name = "lavoratore_id"), inverseJoinColumns = @JoinColumn(name = "ruolo_id"))
	private List<Ruolo> ruoli = new ArrayList<>();

	public Lavoratore() {
		super();
	}

	public Lavoratore(Integer matricola, Float stipendio) {
		super();
		this.matricola = matricola;
		this.stipendio = stipendio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public Float getStipendio() {
		return stipendio;
	}

	public void setStipendio(Float stipendio) {
		this.stipendio = stipendio;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	@Override
	public String toString() {
		return "Lavoratore [id=" + id + ", matricola=" + matricola + ", stipendio=" + stipendio + "]";
	}

}
