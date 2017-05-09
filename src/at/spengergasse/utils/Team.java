package at.spengergasse.utils;

import javafx.scene.paint.Color;

public class Team {
	
	private String tname;
	private Spielfigur sf1;
	private Spielfigur sf2;
	private Spielfigur sf3;
	private Spielfigur sf4;
	private Color c;
	private boolean isBot;

	public Team(String tname, Color c, boolean isBot) {
		setTname(tname);
		sf1 = new Spielfigur(tname+"1", tname);
		sf2 = new Spielfigur(tname+"2", tname);
		sf3 = new Spielfigur(tname+"3", tname);
		sf4 = new Spielfigur(tname+"4", tname);
		setColor(c);
		setBot(isBot);
	}

	public String getName() {
		return tname;
	}
	public Spielfigur getSf1() {
		return sf1;
	}
	public Spielfigur getSf2() {
		return sf2;
	}
	public Spielfigur getSf3() {
		return sf3;
	}
	public Spielfigur getSf4() {
		return sf4;
	}
	public Color getColor() {
		return c;
	}
	
	private void setColor(Color c){
		this.c = c;
	}
	
	private void setTname(String tname) {
		this.tname = tname;
	}

	public boolean isBot() {
		return isBot;
	}

	private void setBot(boolean isBot) {
		this.isBot = isBot;
	}
	
	
}
