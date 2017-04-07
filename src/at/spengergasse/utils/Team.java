/**
 * 
 */
package at.spengergasse.utils;

import java.awt.Color;
import java.util.Arrays;

/**
 * @author Raphael
 *
 */
public class Team {
	private Spielfigur[] Figuren;
	private Color farbe;
	private Person person;
	private String leader;
	

	/**
	 * 
	 */
	public Team(Color farbe) {
		Figuren = new Spielfigur[3];
		setFarbe(farbe);
		leader = person.getName();
		
	}


	public Color getFarbe() {
		return farbe;
	}


	public void setFarbe(Color farbe) {
		this.farbe = farbe;
	}


	@Override
	public String toString() {
		return "Team: "+farbe+", geführt von "+ leader;
	}
	
	
	

}
