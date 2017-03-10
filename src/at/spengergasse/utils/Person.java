package at.spengergasse.utils;

public class Person {

	private int score;
	private String name;

	public Person(String name, int score) {
		setName(name);
		setScore(0);
		addScore(score);
	}

	public int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = "Default";
		}
	}
	
	public int addScore(int score){
		this.score += score;
		return this.score;
	}

	@Override
	public String toString() {
		return "Person [score=" + score + ", name=" + name + "]";
	}

}
