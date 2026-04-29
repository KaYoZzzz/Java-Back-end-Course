package com.azienda.classiAvanzate.parteB.esercizi.a;

public class MainC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A object = new A("prova", 2);
		object.toString();
		A object2 = new A("prova", 2);
		System.out.println(object.equals(object2));
		object = new B("Stringa del Padre", 100, 3.14f);
		System.out.println(object.toString());
		System.out.println(object.getS());
		object.setS("Nuova stringa FIGLIO");
		System.out.println("Nuovo valore getS(): " + object.getS());
		if (object instanceof B) {
			String sPadre = ((B) object).getParentS();
			System.out.println("Valore getParentS(): " + sPadre);
		}
	}
}