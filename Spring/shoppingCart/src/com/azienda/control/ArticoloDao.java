package com.azienda.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.azienda.model.Articolo;

class ArticoloDao implements DaoInterface<Articolo> {

	private Connection connection;

	public ArticoloDao(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Articolo ref) throws SQLException {
		String sql = "INSERT INTO articolo (nome, prezzo) VALUES (?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, ref.getNome());
			ps.setFloat(2, ref.getPrezzo());
			ps.executeUpdate();
		}
	}

	@Override
	public List<Articolo> read() throws SQLException {
		String sql = "SELECT * FROM articolo";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			List<Articolo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new Articolo(rs.getString("nome"), rs.getFloat("prezzo")));
			}
			return result;
		}
	}

	@Override
	public void update(Articolo ref) throws SQLException {
		String sql = "UPDATE articolo SET prezzo = ? WHERE nome = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setFloat(1, ref.getPrezzo());
			ps.setString(2, ref.getNome());
			ps.executeUpdate();
		}
	}

	@Override
	public void delete(String nome) throws SQLException {
		String sql = "DELETE FROM articolo WHERE nome = ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, nome);
			ps.executeUpdate();
		}
	}

	// --- NUOVE FUNZIONALITÀ ---

	public List<Articolo> findByNomeParziale(String partialName) throws SQLException {
		String sql = "SELECT * FROM articolo WHERE nome LIKE ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, "%" + partialName + "%");
			ResultSet rs = ps.executeQuery();
			List<Articolo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new Articolo(rs.getString("nome"), rs.getFloat("prezzo")));
			}
			return result;
		}
	}

	public List<Articolo> findByPrezzoMinore(float soglia) throws SQLException {
		String sql = "SELECT * FROM articolo WHERE prezzo < ?";
		try (PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setFloat(1, soglia);
			ResultSet rs = ps.executeQuery();
			List<Articolo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new Articolo(rs.getString("nome"), rs.getFloat("prezzo")));
			}
			return result;
		}
	}

	public List<Articolo> readOrderByName() throws SQLException {

		String sql = "SELECT * FROM articolo ORDER BY nome ASC";
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			List<Articolo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new Articolo(rs.getString("nome"), rs.getFloat("prezzo")));
			}
			return result;
		}
	}

	public List<Articolo> readOrderByPrice() throws SQLException {

		String sql = "SELECT * FROM articolo ORDER BY prezzo ASC";
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			List<Articolo> result = new ArrayList<>();
			while (rs.next()) {
				result.add(new Articolo(rs.getString("nome"), rs.getFloat("prezzo")));
			}
			return result;
		}
	}

	public float getSommaTotale() throws SQLException {
		String sql = "SELECT SUM(prezzo) AS totale FROM articolo";
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
			return rs.next() ? rs.getFloat("totale") : 0.0f;
		}
	}
}