package at.spengergasse.utils;

import java.util.Random;

public class Wuerfeln {

	public Wuerfeln() {
	}

	public int wuerfeln(){
		Random rn = new Random();
		int w = rn.nextInt(6) + 1;
		return w;
	}

}