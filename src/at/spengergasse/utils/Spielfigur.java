package at.spengergasse.utils;

/*
 * Spielfigur Klasse, welche für die Teams und das Spiel gebraucht wird
 */
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
