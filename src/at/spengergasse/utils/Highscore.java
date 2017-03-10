package at.spengergasse.utils;

import java.io.*;
import java.util.*;

public class Highscore {
	
	private ComparatorScore c = new ComparatorScore();

	private ArrayList<Person> highscore = new ArrayList<Person>(); 

	public Highscore() {
		// TODO Auto-generated constructor stub
	}

	public void sort() {
		highscore.sort(c);
	}

	public void add(String name, int score) {
		for (Person p : highscore) {
			if (p.getName().equals(name)) {
				p.addScore(score);
				return;
			}
		}
		Person e = new Person(name);
		highscore.add(e);
	}

	public void read() {
		Person p = null;
		while (true) {
			try {
				FileInputStream fileIn = new FileInputStream("C:\\Users\\POSProjectTOL_HRA_2017\\highscore.ser");
				ObjectInputStream in = new ObjectInputStream(fileIn);
				p = (Person) in.readObject();
				in.close();
				fileIn.close();
			} catch (IOException io) {
				io.printStackTrace();
				return;
			} catch (ClassNotFoundException cnf) {
				System.out.println("Person class note found");
				cnf.printStackTrace();
				return;
			}
			highscore.add(p);
		}
	}

	public void write() throws IOException { 
		if(new File("C:\\Users\\POSProjectTOL_HRA_2017\\highscore.ser").exists() != true){
			createFile();
		}
		for (Person p : highscore) {
			try {
				FileOutputStream fileOut = new FileOutputStream("C:\\Users\\POSProjectTOL_HRA_2017\\highscore.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(p);
				out.close();
				fileOut.close();
				System.out.printf("Serialized data is saved in C:\\Users\\POSProjectTOL_HRA_2017\\highscore.ser");
			} catch (IOException i) {
				i.printStackTrace();
			}
		}
	}

	public void print() {
		sort();
		for (Person p : highscore) {
			if (p.getPlace() == 1) {
				System.out.println("1st place");
			}
			if (p.getPlace() == 2) {
				System.out.println("2nd place");
			}
			if (p.getPlace() == 3) {
				System.out.println("3rd place");
			} else {
				System.out.println(p.getPlace() + "th place");
			}
			System.out.println("Name: " + p.getName());
			System.out.println("Score: " + p.getScore());
		}
	}
	
	public void createFile() throws IOException{
		String pfad ="C:\\Users\\POSProjectTOL_HRA_2017\\highscore.ser";
		File f = new File(pfad);
		f.getParentFile().mkdirs(); 
		f.createNewFile();
	}	
}
