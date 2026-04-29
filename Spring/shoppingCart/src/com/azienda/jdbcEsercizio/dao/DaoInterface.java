package com.azienda.jdbcEsercizio.dao;

import java.sql.SQLException;
import java.util.List;

interface DaoInterface<T> {
	void create(T ref) throws SQLException;

	List<T> read() throws SQLException;

	void update(T ref) throws SQLException;

	void delete(T ref) throws SQLException;
}
