package at.spengergasse.utils;

public class Spielfigur {

	private String name;
	private String teamname;
	private int position;

	public Spielfigur(String name, String teamname) {
		this.name = name;
		this.teamname = teamname;
		setPosition(-1);
	}

	public String getName(){
		return name;
	}
	public String getTeamName(){
		return teamname;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Spielfigur [name=" + name + ", teamname=" + teamname + ", position=" + position + "]";
	}

	
	
	
}
