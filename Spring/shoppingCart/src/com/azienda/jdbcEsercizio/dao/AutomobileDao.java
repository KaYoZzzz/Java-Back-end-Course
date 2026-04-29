package com.azienda.jdbcEsercizio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.azienda.jdbcEsercizio.model.Automobile;

public class AutomobileDao implements DaoInterface<Automobile> {

	private Connection con;

	public AutomobileDao(Connection connection) {
		super();
		this.con = connection;
	}

	@Override
	public void create(Automobile ref) throws SQLException {
		String sql = "insert into automobile (id, marca, modello, targa, colore, cilindrata) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, this.getMaxID() + 1);
		ps.setString(2, ref.getMarca());
		ps.setString(3, ref.getModello());
		ps.setString(4, ref.getTarga());
		ps.setString(5, ref.getColore());
		ps.setFloat(6, ref.getCilindrata());

		ps.executeUpdate();

	}

	@Override
	public List<Automobile> read() throws SQLException {
		String sql = "select * from automobile";
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		List<Automobile> result = new ArrayList<Automobile>();
		while (rs.next()) {
			Integer id = rs.getInt("id");
			String marca = rs.getString("marca");
			String modello = rs.getString("modello");
			String targa = rs.getString("targa");
			String colore = rs.getString("colore");
			Float cilindrata = rs.getFloat("cilindrata");
			Automobile a = new Automobile(id, marca, modello, targa, colore, cilindrata);
			result.add(a);
		}
		return result;
	}

	@Override
	public void update(Automobile ref) throws SQLException {
		String sql = "update automobile set marca = ? where id= ? ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, ref.getMarca());
		ps.setInt(2, ref.getId());

		ps.executeUpdate();
	}

	@Override
	public void delete(Automobile ref) throws SQLException {
		Statement st = con.createStatement();
		String sql = "delete from automobile";
		st.executeUpdate(sql);

	}

	/**
	 * controlla se l'automobile esiste nel database
	 * 
	 * @param toCheck
	 * @return true se la trova
	 * @return false se non la trova
	 * @throws SQLException
	 */
	public boolean checkAutomobileIfExist(Automobile toCheck) throws SQLException {
		String sql = "SELECT COUNT(*) FROM automobile WHERE marca = ? AND modello = ? AND targa = ? AND cilindrata = ? AND colore = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, toCheck.getMarca());
			ps.setString(2, toCheck.getModello());
			ps.setString(3, toCheck.getTarga());
			ps.setFloat(4, toCheck.getCilindrata());
			ps.setString(5, toCheck.getColore());

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1); // Legge il valore del COUNT(*)
					return count > 0; // Ritorna true se il conteggio è almeno 1
				}
			}
		}
		return false;
	}

	public int getMaxID() throws SQLException {
		String sql = "SELECT MAX(id) FROM automobile";
		try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

			if (rs.next()) {
				// Estraiamo il valore dalla prima colonna del risultato
				int maxId = rs.getInt(1);
				return maxId;
			}
		}
		return 0; // Valore di default se la tabella è vuota

	}

	public int deleteMacchinaPerMarca(String marca) throws SQLException {
		String sql = "DELETE FROM automobile WHERE marca LIKE ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {
			// Concateniamo la stringa dell'utente con il jolly %
			// Esempio: se ricevi "Fia", diventerà "Fia%"
			ps.setString(1, marca + "%");

			// executeUpdate() restituisce il numero di righe cancellate
			int righeCancellate = ps.executeUpdate();

			return righeCancellate;
		}

	}

	public int updateTargaFromMarca(String marca, String targa) throws SQLException {
		String sql = "UPDATE automobile SET targa = ? WHERE marca LIKE ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, targa);
			ps.setString(2, marca + "%");

			int righeAggiornate = ps.executeUpdate();

			return righeAggiornate;
		}
	}
}
