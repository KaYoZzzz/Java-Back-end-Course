package com.azienda.esempioSpringData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.esempioSpringData.model.Lavoratore;
import com.azienda.esempioSpringData.model.Ruolo;
import com.azienda.esempioSpringData.model.Sede;
import com.azienda.esempioSpringData.repository.LavoratoreRepo;
import com.azienda.esempioSpringData.repository.PersonaRepo;
import com.azienda.esempioSpringData.repository.RuoloRepo;
import com.azienda.esempioSpringData.repository.SedeRepo;

import jakarta.transaction.Transactional;

//tag da utilizzare sulla classe che offre il servizio crud
@Service
//in automatico capisce se deve fare commit o rollback tramite un trycatch intrinseco
@Transactional
public class applicationService {
	@Autowired
	private PersonaRepo personaRepo;
	@Autowired
	private LavoratoreRepo lavoratoreRepo;
	@Autowired
	private SedeRepo sedeRepo;
	@Autowired
	private RuoloRepo ruoloRepo;

	public Sede createSede(String nome) {
		Sede sede = new Sede(nome);
		sedeRepo.save(sede);
		// dopo la save l'oggetto viene ancora monitorato da hybernate in quanto sta in
		// cache fino alla fine della transazione, fa scattare un update
		sede.setCitta("Milano"); // quindi, nonostante io abbia detto all'inizio di salvare sul database la
									// stringa in input metterà invece a prescindere questa
		return sede;
	}

	public void insertSedeWithLavoratori() {
		Sede s = new Sede("Roma");
		Lavoratore l1 = new Lavoratore(1000, 1000f);
		Lavoratore l2 = new Lavoratore(2001, 2001f);
		Lavoratore l3 = new Lavoratore(3002, 3002f);

		// primo metodo
		l1.setSede(s);
		// secondo metodo
		// s.getLavoratori().add(l1); //alcuni lo mettono per questione di sicurezza
		// (stile defensive, ma non strettamente necessario), se non si usa anche questo
		// bisogna stare attenti al disallineamento tra cache e db
		l2.setSede(s);
		l3.setSede(s);

		sedeRepo.save(s);
		lavoratoreRepo.save(l1);
		lavoratoreRepo.save(l2);
		lavoratoreRepo.save(l3);
		// PS. esiste anche una saveAll!

	}

	public void insertLavoratoriRuoli() {
		Lavoratore l1 = new Lavoratore(1000, 1000f);
		Lavoratore l2 = new Lavoratore(2001, 2001f);
		Lavoratore l3 = new Lavoratore(3002, 3002f);

		Ruolo dev = new Ruolo("Developer");
		Ruolo sis = new Ruolo("Sistemista");

		// primo metodo
		l1.getRuoli().add(dev);
		// secondo metodo dev.getLavoratori().add(l1); se non si usa anche questo
		// bisogna stare attenti al disallineamento tra cache e db
		l1.getRuoli().add(sis);
		l2.getRuoli().add(dev);
		l3.getRuoli().add(sis);

		lavoratoreRepo.save(l1);
		lavoratoreRepo.save(l2);
		lavoratoreRepo.save(l3);
		ruoloRepo.save(dev);
		ruoloRepo.save(sis);

	}

	public void updateSede() {
		List<Sede> sedi = sedeRepo.findAll();
		if (sedi.size() > 0) {
			Sede s = sedi.get(0);
			s.setCitta("Palermo"); // viene eseguito un update anche sul db
		}
	}

	public void deleteSede() {
		List<Sede> sedi = sedeRepo.findAll();
		if (sedi.size() > 0) {
			Sede s = sedi.get(0);
			sedeRepo.delete(s);
		}
	}

	public void updateSedeDue() {
		Optional<Sede> opt = sedeRepo.findById(1);
		Sede s = opt.orElse(null);
		if (s != null) {
			s.setCitta("Napoli");
			sedeRepo.delete(s);
		}
	}

	public void assumiLavoratore(String nomeCitta, Integer matricola, Float stipendio) {

		Optional<Sede> opt = sedeRepo.findByCitta(nomeCitta);
		Sede s = opt.orElseThrow(() -> new RuntimeException("Città non trovata"));

		Lavoratore l1 = new Lavoratore(matricola, stipendio);

		// primo metodo
		l1.setSede(s);
		// secondo metodo
		// s.getLavoratori().add(l1); //alcuni lo mettono per questione di sicurezza
		// (stile defensive, ma non strettamente necessario), se non si usa anche questo
		// bisogna stare attenti al disallineamento tra cache e db
		lavoratoreRepo.save(l1);
	}

	public void assegnaRuolo(Integer matricola, Float stipendio, String nomeRuolo) {
		Lavoratore lav = lavoratoreRepo.findByMatricolaAndStipendio(matricola, stipendio).orElse(null);
		if (lav != null) {
			Ruolo r = ruoloRepo.searchByName(nomeRuolo).orElseThrow(() -> new RuntimeException("Ruolo non trovato"));
			lav.getRuoli().add(r);
		} else {
			throw new RuntimeException("Lavoratore non trovato");
		}
	}

	// effettua la ricerca LIKE con la sequel injection nella stringa s
	public List<Ruolo> searchRuoliLike(String s) {
		return ruoloRepo.findByNomeLike(s);
	}
}
