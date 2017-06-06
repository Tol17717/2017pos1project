package at.spengergasse.test;

import at.spengergasse.utils.*;

public class Test {

	public static void main(String[] args) {
	
		Game g = new Game(false, false, false, false);
		System.out.println(g.toString());
		g.moveOutOfStart(1, 0, 6);
		System.out.println(g.toString());
		g.moveFromField(1, 0, 40);
		System.out.println(g.toString());
		
		g.moveOutOfStart(1, 1, 6);
		System.out.println(g.toString());
		g.moveFromField(1, 0, 41);
		System.out.println(g.toString());
		
		g.moveOutOfStart(1, 2, 6);
		System.out.println(g.toString());
		g.moveFromField(1, 0, 42);
		System.out.println(g.toString());
		
		g.moveOutOfStart(1, 3, 6);
		System.out.println(g.toString());
		g.moveFromField(1, 0, 43);
		System.out.println(g.toString());
		
	}

}
