package at.spengergasse.test;

import javax.swing.JFrame;

import at.spengergasse.utils.*;

public class Test {

	public static void main(String[] args) {
		Team team = null;
		String eingabe="";
		Game g = new Game("Team1","Team2","Team3","Team4");
		JFrame win = new JFrame("Hinweis");
		g.teamsSetup();
		win.setTitle("Wählen sie ihr Team.");
		
		win.pack();
		win.setVisible(true);
		
		

	}

}
