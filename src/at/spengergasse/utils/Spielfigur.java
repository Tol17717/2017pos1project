package at.spengergasse.utils;

public class Spielfigur {

	private int team;

	public Spielfigur(int team) {
		this.team = team;
	}

	public int getTeam(){
		return team;
	}
	
	@Override
	public String toString() {
		return "Spielfigur [team=" + team + "]";
	}	
}
