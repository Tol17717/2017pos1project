package at.spengergasse.utils;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Game {

	private Team t1;
	private Team t2;
	private Team t3;
	private Team t4;
	
	private Spielfigur[] startT1;
	private Spielfigur[] startT2;
	private Spielfigur[] startT3;
	private Spielfigur[] startT4;
	
	private Spielfigur[] gameField;
	
	private Spielfigur[] winT1;
	private Spielfigur[] winT2;
	private Spielfigur[] winT3;
	private Spielfigur[] winT4;
	
	private Integer t1startpos;
	private Integer t2startpos;
	private Integer t3startpos;
	private Integer t4startpos;
	
		public Game(boolean t1bot, boolean t2bot, boolean t3bot, boolean t4bot) {
		t1 = new Team(1, t1bot);
		t2 = new Team(2, t2bot);
		t3 = new Team(3, t3bot);
		t4 = new Team(4, t4bot);
		startT1 = new Spielfigur[4];
		startT2 = new Spielfigur[4];
		startT3 = new Spielfigur[4];
		startT4 = new Spielfigur[4];	
		gameField = new Spielfigur[40];
		winT1 = new Spielfigur[4];
		winT2 = new Spielfigur[4];
		winT3 = new Spielfigur[4];
		winT4 = new Spielfigur[4];
		t1startpos = 1;
		t2startpos = 11;
		t3startpos = 21;
		t4startpos  = 31;
	}
		
	public boolean getOutOfStart(int wuerfel){
		if(wuerfel == 6){
			return true;
		} else {
			return false;
		}
	}
	
	public void teamsSetup(){
		startT1[0]=t1.getSf1();
		startT1[1]=t1.getSf2();
		startT1[2]=t1.getSf3();
		startT1[3]=t1.getSf4();
		
		startT2[0]=t2.getSf1();
		startT2[1]=t2.getSf2();
		startT2[2]=t2.getSf3();
		startT2[3]=t2.getSf4();
		
		startT2[0]=t3.getSf1();
		startT2[1]=t3.getSf2();
		startT2[2]=t3.getSf3();
		startT2[3]=t3.getSf4();
		
		startT2[0]=t4.getSf1();
		startT2[1]=t4.getSf2();
		startT2[2]=t4.getSf3();
		startT2[3]=t4.getSf4();
	}
	
	//Bei einer gew�rfelten Sechs wird diese Methode aufgerufen.
	public boolean moveOutOfStart(int team, int position, int wuerfelwert){
		if((team >= 1 && team <= 4) && wuerfelwert == 6) {
			if(team == 1){
				if(startT1[position] == null){
					return false;
				} else {
					return true;
				}
			} 
			if(team == 2) {
				if(startT2[position] == null) {
					return false;
				} else {
					return true;
				}
			}
			if(team == 3) {
				if(startT3[position] == null) {
					return false;
				} else {
					return true;
				}
			}
			if(team == 4) {
				if(startT4[position] == null) {
					return false;
				} else {
					return true;
				}
			}
		} 
		return false;
		
	}
	
	
	public boolean canKick( int feld){
		if(gameField[feld] != null){
			return true;
		} else {
			return true;
		}

	}
	
	public boolean putBackInStart(int team, int position){
		for(int i = 0; i < 4; i++){
			if(team == i){
				
			}
		}
	}
	
	public boolean kick(int feld){
		if(gameField[feld].getTeam() == 1){
			
		}
	}
	
	public void move(Spielfigur k, int steps){
		
	}
	
	public boolean wint1(){
		for(int i = 0; i < 4; i++){
			if(winT1[i] == null){
				return false;
			}
		}
		return true;
	}
	public boolean wint2(){
		for(int i = 0; i < 4; i++){
			if(winT2[i] == null){
				return false;
			}
		}
		return true;
	}
	public boolean wint3(){
		for(int i = 0; i < 4; i++){
			if(winT2[i] == null){
				return false;
			}
		}
		return true;
	}
	public boolean wint4(){
		for(int i = 0; i < 4; i++){
			if(winT2[i] == null){
				return false;
			}
		}
		return true;
	}
}