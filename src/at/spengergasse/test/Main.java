package at.spengergasse.test;

import java.io.*;
import at.spengergasse.utils.*;

public class Main {
	
	private static Highscore highscore = new Highscore();
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		highscore.read();
		highscore.add("Test", 10);
		highscore.print();
		highscore.write();
		
	}

}
