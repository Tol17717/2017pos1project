package at.spengergasse.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Highscore { 

	private ComparatorScore c = new ComparatorScore();

	private ArrayList<Person> highscore = new ArrayList<Person>();

	public Highscore() {
		// TODO Auto-generated constructor stub
	}

	public void sort() {
		highscore.sort(c);
		System.out.println("Highscore array sorted");
	}

	public void add(String name, int score) {
		for (Person p : highscore) {
			if (p.getName().equals(name)) {
				p.addScore(score);
				System.out.println(p.toString());
				return;
			}
		}
		Person e = new Person(name);
		e.addScore(score);
		highscore.add(e);
		System.out.println(e.toString());
	}

	public void read() {
		highscore.clear();
		try {
			FileInputStream fileIn = new FileInputStream("C:\\POSProjectTOL_HRA_2017\\highscore.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			while (true) {
				try {
					Person per = (Person) in.readObject();
					if(highscore.contains(per)){
						
					} else {
					highscore.add(per); }
				} catch (EOFException e) {
					break;
				}

			}
			in.close();
			fileIn.close();
		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("All highscores have been imported");
		} catch (ClassNotFoundException cnf) {
			System.out.println("Person class not found");
			cnf.printStackTrace();
			return;
		}
	}

	public void write() throws IOException {
		if (new File("\\POSProjectTOL_HRA_2017\\highscore.ser").exists() != true) {
			createFile();
		}
		try {
			
			FileOutputStream fileOut = new FileOutputStream("\\POSProjectTOL_HRA_2017\\highscore.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			for (Person p : highscore) {
				out.writeObject(p); 
			}
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.printf("Serialized data is saved in C:\\POSProjectTOL_HRA_2017\\highscore.ser");
	}

	public void print() {
		sort();
		for (Person x : highscore) {
			x.setPlace(highscore.indexOf(x) + 1);
		}
		for (Person p : highscore) {
			if (p.getPlace() == 1) {
				System.out.println("1st place");
			}
			if (p.getPlace() == 2) {
				System.out.println("2nd place");
			}
			if (p.getPlace() == 3) {
				System.out.println("3rd place");
			}
			if (p.getPlace() > 3) {
				System.out.println(p.getPlace() + "th place");
			}
			System.out.println("Name: " + p.getName());
			System.out.println("Score: " + p.getScore());
		}
	}

	public void createFile() throws IOException { //TODO Path aus dem Hardcode entfernen
		if (new File("\\POSProjectTOL_HRA_2017").exists()) {
			String pfad = "\\POSProjectTOL_HRA_2017\\highscore.ser";
			File f = new File(pfad);
			f.getParentFile().mkdirs();
			f.createNewFile();
			System.out.println("File created");
		} else {
			Files.createDirectories(Paths.get("\\POSProjectTOL_HRA_2017"));
			System.out.println("Directory created at C:\\POSProjectTOL_HRA_2017");
			String pfad = "\\POSProjectTOL_HRA_2017\\highscore.ser";
			File f = new File(pfad);
			f.getParentFile().mkdirs();
			f.createNewFile();
		}
		System.out.println("File created");
	}
}
