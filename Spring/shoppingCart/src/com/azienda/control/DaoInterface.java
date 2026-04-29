package com.azienda.control;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {
	void create(T ref) throws SQLException;

	List<T> read() throws SQLException;

	void update(T ref) throws SQLException;

	void delete(String ref) throws SQLException;
}
