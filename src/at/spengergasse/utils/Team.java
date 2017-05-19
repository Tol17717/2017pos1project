package at.spengergasse.utils;


public class Team {
	
	private int tname;
	private Spielfigur sf1;
	private Spielfigur sf2;
	private Spielfigur sf3;
	private Spielfigur sf4;
	private boolean isBot;

	public Team(int tname, boolean isBot) {
		setTname(tname);
		sf1 = new Spielfigur(tname+"1", tname);
		sf2 = new Spielfigur(tname+"2", tname);
		sf3 = new Spielfigur(tname+"3", tname);
		sf4 = new Spielfigur(tname+"4", tname);
		setBot(isBot);
	}

	public int getName() {
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
	
	private void setTname(int tname) {
		this.tname = tname;
	}

	public boolean isBot() {
		return isBot;
	}

	private void setBot(boolean isBot) {
		this.isBot = isBot;
	}
	
	
}
