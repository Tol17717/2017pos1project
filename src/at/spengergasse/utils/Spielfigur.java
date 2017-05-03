package at.spengergasse.utils;

public class Spielfigur {

	private String name;
	private String teamname;

	public Spielfigur(String name, String teamname) {
		this.name = name;
		this.teamname = teamname;
	}

	public String getName(){
		return name;
	}
	public String getTeamName(){
		return teamname;
	}

	@Override
	public String toString() {
		return "Spielfigur [name=" + name + ", teamname=" + teamname + "]";
	}
	
	
}
