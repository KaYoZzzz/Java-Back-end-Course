package com.azienda.testMinMax;

import java.util.Scanner;

public class TestMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;
		boolean v;
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserire primo numero");
		a=scanner.nextInt();
		System.out.println("inserire secondo numero");
		b=scanner.nextInt();
		System.out.println("inserire terzo numero");
		c=scanner.nextInt();
		System.out.println("massimo o minimo?\ntrue = massimo, false = minimo");
		v = scanner.nextBoolean();
		int result = minMax(a, b, c, v);
		if(v==true) {
			System.out.println("il massimo è " + result);
		} else {
			System.out.println("il minimo è " + result);
		}
		scanner.close();
	}
	
	static int minMax(int a, int b, int c, boolean v) {
		if (v == true) {
			int max = Math.max(a, b);
			max = Math.max(max, c);
			return max;
		} else {
			int min = Math.min(a, b);
			min = Math.min(min, c);
			return min;
		}
	}
}
