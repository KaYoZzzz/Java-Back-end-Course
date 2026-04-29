package com.azienda.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.azienda.model.Articolo;

public class ApplicationService {
	private Connection connection;
	private ArticoloDao articoloDao;

	public ApplicationService(Connection connection) {
		this.connection = connection;
		this.articoloDao = new ArticoloDao(connection);
	}

	public void insertParametric(Articolo a) throws SQLException {
		try {
			articoloDao.create(a);
			connection.commit();
			System.out.println("Articolo creato con successo.");
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public List<Articolo> cercaPerNome(String nome) throws SQLException {
		try {
			List<Articolo> result = articoloDao.findByNomeParziale(nome);
			connection.commit();
			return result;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public List<Articolo> cercaSottoPrezzo(float prezzo) throws SQLException {
		try {
			List<Articolo> result = articoloDao.findByPrezzoMinore(prezzo);
			connection.commit();
			return result;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public List<Articolo> visualizzaOrdinatiNome() throws SQLException {
		try {
			List<Articolo> result = articoloDao.readOrderByName();
			connection.commit();
			return result;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public List<Articolo> visualizzaOrdinatiPrezzo() throws SQLException {
		try {
			List<Articolo> result = articoloDao.readOrderByPrice();
			connection.commit();
			return result;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public float getTotaleCarrello() throws SQLException {
		try {
			float totale = articoloDao.getSommaTotale();
			connection.commit();
			return totale;
		} catch (SQLException e) {
			connection.rollback();
			throw e;
		}
	}

	public void delete(String nome) throws SQLException {
		try {
			articoloDao.delete(nome);
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			throw e;
		}
	}
}