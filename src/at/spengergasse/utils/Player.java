package at.spengergasse.utils;

import java.awt.Color;

public class Player {
	
	private Figur f1;
	private Figur f2;
	private Figur f3;
	private Figur f4;
	private Color tf;
	
	public Player(Color tf) {
		f1 = new Figur(tf);
		f2 = new Figur(tf);
		f3 = new Figur(tf);
		f4 = new Figur(tf);
	}
}
		
