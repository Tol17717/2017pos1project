package at.spengergasse.utils;

import java.util.Random;

public class Wuerfeln {

	public Wuerfeln() {
	}

	/*
	 * Übernimmt die Logik des Würfels
	 */
	public int wuerfeln(){
		Random rn = new Random();
		int w = rn.nextInt(6);
		return w;
	}

}