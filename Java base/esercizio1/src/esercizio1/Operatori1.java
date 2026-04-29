package esercizio1;

/*Creare una classe Operatori1 con un metodo main, che:
dichiari una variabile byte e le assegni il valore di -2
dichiari una variabile short e le assegni il valore di 25
dichiari una variabile int e le assegni il valore di 32
dichiari una variabile long e le assegni il valore di 255
dichiari una variabile float e le assegni il valore di 15,32
dichiari una variabile double e le assegni il valore di 254,78
dichiari una variabile char e le assegni il valore «A»
dichiari una variabile boolean e le assegni il valore «true»
stampi a console  una scritta del tipo «valore della variabile x:» concatenata col valore della variabile, per ciascuna delle 8 variabili precedentemente definite
*/

public class Operatori1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte vbyte = -2;
		short vshort = 25;
		int vint = 32;
		long vlong = 255;
		float vfloat = 15.32f;
		double vdouble = 254.78;
		char vchar = 'A';
		boolean vboolean = true;
		
		System.out.println("Valore vbyte = " + vbyte);
		System.out.println("Valore vshort = " + vshort);
		System.out.println("Valore vint = " + vint);
		System.out.println("Valore vlong = " + vlong);
		System.out.println("Valore vfloat = " + vfloat);
		System.out.println("Valore vdouble = " + vdouble);
		System.out.println("Valore vchar = " + vchar);
		System.out.println("Valore vboolean = " + vboolean);
		
	}

}
