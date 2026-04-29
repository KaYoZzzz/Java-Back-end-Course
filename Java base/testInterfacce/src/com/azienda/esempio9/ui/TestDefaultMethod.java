package com.azienda.esempio9.ui;

import com.azienda.esempio9.model.DBConnection;
import com.azienda.esempio9.model.MySQLConnection;
import com.azienda.esempio9.model.OracleConnection;

public class TestDefaultMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection ref = new OracleConnection();
		ref.open();
		ref.close();
		ref = new MySQLConnection();
		ref.open();
		ref.close();
		DBConnection.metodoStatico();
	}

}
