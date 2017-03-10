package at.spengergasse.utils;

import java.util.*;

public class ComparatorScore implements Comparator<Person>{ //komm
	
	public ComparatorScore() {
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.compareTo(o2);
	}
}
