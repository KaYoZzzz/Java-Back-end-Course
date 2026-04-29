package com.azienda.jdbcEsercizio.businessLogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.azienda.jdbcEsercizio.dao.AutomobileDao;
import com.azienda.jdbcEsercizio.model.Automobile;

public class ApplicationService {
	private Connection con;
	private AutomobileDao automobileDao;

	public ApplicationService(Connection con) {
		super();
		this.con = con;
		automobileDao = new AutomobileDao(con);
	}

	public void insertParametric(Automobile a) throws SQLException {
		try {
			if (!this.checkAutoIfExists(a)) {
				automobileDao.create(a);
				con.commit();
				System.out.println("Automobile creata");
			} else {
				System.out.println("Automobile già esistente");
			}

		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

	public void delete() throws SQLException {
		try {
			automobileDao.delete(null);
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

	public void updateParametric(Automobile a) throws SQLException {
		try {
			automobileDao.update(a);
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

	public List<Automobile> selectAll() throws SQLException {
		try {
			List<Automobile> result = automobileDao.read();
			con.commit();
			return result;
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

	public boolean checkAutoIfExists(Automobile toCheck) throws SQLException {
		return automobileDao.checkAutomobileIfExist(toCheck);
	}

	public int deleteMacchinaPerMarca(String marca) throws SQLException {
		try {
			int righeCancellate = automobileDao.deleteMacchinaPerMarca(marca);
			con.commit();
			return righeCancellate;
		} catch (SQLException e) {
			con.rollback();
			throw e;
		}
	}

	public int updateTargaFromMarca(String marca, String targa) throws SQLException {
		int righeAffette = automobileDao.updateTargaFromMarca(marca, targa);
		con.commit();
		return righeAffette;
	}
}
