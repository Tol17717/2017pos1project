package at.spengergasse.utils;

public class Team {
	
	private String tname;
	private Spielfigur sf1;
	private Spielfigur sf2;
	private Spielfigur sf3;
	private Spielfigur sf4;

	public Team(String tname) {
		setTname(tname);
		sf1 = new Spielfigur(tname+"1", tname);
		sf2 = new Spielfigur(tname+"1", tname);
		sf3 = new Spielfigur(tname+"1", tname);
		sf4 = new Spielfigur(tname+"1", tname);
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
	
	
	private void setTname(String tname) {
		this.tname = tname;
	}
}
