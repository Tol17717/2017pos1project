package at.spengergasse.utils;

import java.io.*;
import java.util.*;

public class Highscore {
	
	private ArrayList<Person> highscore = new ArrayList<Person>(); // Hier ist nichts lel

	public Highscore() {
		// TODO Auto-generated constructor stub
	}
	
	public void sort(){
		
	}
	
	public void add(String name, int score){
		for(Person p:highscore){
			if(p.getName().equals(name)){
				p.addScore(score);
				return;
			}
		}
		Person e = new Person(name, score);
		highscore.add(e);
	}
	
	public void read(){
		
	}

}
