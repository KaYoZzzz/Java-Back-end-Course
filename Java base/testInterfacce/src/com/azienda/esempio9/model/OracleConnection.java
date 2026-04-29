package com.azienda.esempio9.model;

public class OracleConnection implements DBConnection {

	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("Oracle Open Connection");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Oracle Close Connection");
	}
}
