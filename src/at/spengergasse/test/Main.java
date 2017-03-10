package at.spengergasse.test;

import at.spengergasse.utils.*;

public class Main {
	
	private static Wuerfel m = new Wuerfel();

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++){
		System.out.println(m.wuerfeln());
		}
		
	}

}
