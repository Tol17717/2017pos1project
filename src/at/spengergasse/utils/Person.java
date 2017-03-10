package at.spengergasse.utils;

public class Person implements Comparable<Person>{

	private int score;
	private String name;
	private int place;

	public Person(String name) { //komm
		setName(name);
		setScore(0);
		setPlace(-1);
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

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Person [score=" + score + ", name=" + name + ", place=" + place + "]";
	}

	@Override
	public int compareTo(Person o) {
		return Integer.compare(this.score, o.score);
	}

	

}
