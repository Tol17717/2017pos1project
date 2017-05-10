package at.spengergasse.test;

import java.io.*;
import at.spengergasse.utils.*;

public class Main {
	
	private static Highscore highscore = new Highscore();
	private static Person p = new Person("Test");
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		highscore.read();
		highscore.add("Raphael", 6);
		highscore.add("Chris", 8);
		highscore.add("Elliott", 4);
		highscore.print();
		highscore.write();
		/*highscore.read();
		highscore.print();*/
		/*highscore.add("Chris", 25);
		highscore.print();
		highscore.write();
		highscore.read();
		highscore.print();*/
	}

}
