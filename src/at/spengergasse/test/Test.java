package at.spengergasse.test;

import at.spengergasse.utils.*;

public class Test {

	public static void main(String[] args) {
	
		Game g = new Game(false, false, false, false);
		System.out.println(g.toString());
		g.moveOutOfStart(1, 0, 6);
		System.out.println(g.toString());
		System.out.println(g.moveFromWinField(1, 0, 1));
			
		
	}
	
	

}
