package com.azienda.esempioConversioni;


public class EsempioConversioni {
	public static void main(String[] args) {
		int intero = 128;
		byte b = 3;
		intero = b;
		intero = 128;
		b = (byte)intero; //fuori dal range del byte (range va da -128 a 127)
		System.out.println(b); //stampa -128 perchè "fa il giro"
		long x = 3000000000L;
		System.out.println(x);
		float f = 42.99f;
		intero = (int)f; //taglia la parte decimale per difetto
		System.out.println(intero);
		f=intero;
		float risultato = intero/f;
		System.out.println(risultato);
		int a = 5, b2 = 3, c3 = a/b2;

		System.out.println(c3); //numero castrato

		float f2 = a/(float)b2;
		System.out.println(f2); //numero con la virgola

		byte n1 = 2, n2 = 127, n3 = (byte)(n1+n2); //fa il giro
		System.out.println(n3);
		int n4 = (n1+n2);
		System.out.println(n4); //se si sommano byte,short,char.. diventa un int (almeno che faccio casting


	}	
}
