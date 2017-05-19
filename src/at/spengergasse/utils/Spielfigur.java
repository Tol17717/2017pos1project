package at.spengergasse.utils;

public class Spielfigur {

	private String name;
	private int team;
	private int position;

	public Spielfigur(String name, int team) {
		this.name = name;
		this.team = team;
		setPosition(-1);
	}

	public String getName(){
		return name;
	}
	public int getTeam(){
		return team;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Spielfigur [name=" + name + ", team=" + team + ", position=" + position + "]";
	}

	

	
	
	
}
