package com.azienda.esempio9.model;

public interface DBConnection {
	public void open();

	public default void close() {
		System.out.println("Default Close");
	}

	public static void metodoStatico() {
		System.out.println("Metodo Statico");
	}
}
