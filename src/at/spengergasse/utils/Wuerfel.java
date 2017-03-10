package at.spengergasse.utils;

import java.util.*;

public class Wuerfel {

	public Wuerfel() {
		// TODO Auto-generated constructor stub
	}

	public int wuerfeln(){
		Random rn = new Random();
		int w = rn.nextInt(6) + 1;
		return w;
	}
}
