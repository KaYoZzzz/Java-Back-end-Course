package com.azienda.esempio9.model;

public class MySQLConnection implements DBConnection {

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("MySQL Open Connection");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("MySQL Close Connection");
	}
}
