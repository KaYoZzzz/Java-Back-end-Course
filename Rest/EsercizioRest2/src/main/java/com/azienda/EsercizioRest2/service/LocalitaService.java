package com.azienda.EsercizioRest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.EsercizioRest2.model.Localita;
import com.azienda.EsercizioRest2.repos.LocalitaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocalitaService {
	@Autowired
	private LocalitaRepo localitaRepo;

	// Inserisce o aggiorna una località
	public Localita save(Localita localita) {
		return localitaRepo.save(localita);
	}

	// Restituisce tutta la lista
	public List<Localita> findAll() {
		return localitaRepo.findAll();
	}

	// Sostituisce il tuo vecchio findById con il for-loop
	public Localita findById(Integer id) {
		// orElse(null) ci permette di restituire null se non lo trova,
		// mantenendo intatta la logica che hai già scritto nel Controller
		return localitaRepo.findById(id).orElse(null);
	}

	// Sostituisce il tuo vecchio findByNome
	public Localita findByNome(String nome) {
		return localitaRepo.findByNome(nome).orElse(null);
	}

	public List<Localita> findTempBelow(Float temp) {
		return localitaRepo.findByTemperaturaLessThan(temp);
	}

	public List<Localita> findTempAbove(Float temp) {
		return localitaRepo.findByTemperaturaGreaterThan(temp);
	}

	public Localita putLocalita(Integer id, Localita datiAggiornati) {
		Localita localitaInDB = localitaRepo.findById(id).orElse(null);

		if (localitaInDB != null) {
			// L'entità è "Managed" perché siamo dentro un metodo @Transactional
			localitaInDB.setNome(datiAggiornati.getNome());
			localitaInDB.setTemperatura(datiAggiornati.getTemperatura());

			// Non serve chiamare localitaRepo.save(localitaInDB)!
			// Al termine di questo metodo, Hibernate farà il flush delle modifiche sul DB.
		}

		return localitaInDB;
	}

	public Localita patchLocalita(Integer id, Localita datiAggiornati) {
		Localita localitaInDB = localitaRepo.findById(id).orElse(null);
		if (localitaInDB != null) {
			if (datiAggiornati.getNome() != null && !datiAggiornati.getNome().trim().isEmpty()) {
				localitaInDB.setNome(datiAggiornati.getNome());
			}
			if (datiAggiornati.getTemperatura() != null) {
				localitaInDB.setTemperatura(datiAggiornati.getTemperatura());
			}
		}

		return localitaInDB;
	}

	public void deleteById(Integer id) {
		localitaRepo.deleteById(id);
	}

	public void deleteBelowTemp(Float temp) {
		localitaRepo.deleteByTemperaturaLessThan(temp);
	}

	public void deleteAboveTemp(Float temp) {
		localitaRepo.deleteByTemperaturaGreaterThan(temp);
	}
}
