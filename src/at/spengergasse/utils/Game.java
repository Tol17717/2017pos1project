package at.spengergasse.utils;

import java.util.ArrayList;

public class Game {

	private Team t1;
	private Team t2;
	private Team t3;
	private Team t4;
	
	private ArrayList<Spielfigur> startT1;
	private ArrayList<Spielfigur> startT2;
	private ArrayList<Spielfigur> startT3;
	private ArrayList<Spielfigur> startT4;
	
	private Spielfigur[] gameField;
	
	private ArrayList<Spielfigur> winT1;
	private ArrayList<Spielfigur> winT2;
	private ArrayList<Spielfigur> winT3;
	private ArrayList<Spielfigur> winT4;
	
		public Game(String t1name, String t2name, String t3name, String t4name) {
		t1 = new Team(t1name);
		t2 = new Team(t2name);
		t3 = new Team(t3name);
		t4 = new Team(t4name);
		startT1 = new ArrayList<Spielfigur>();	
		startT2 = new ArrayList<Spielfigur>();	
		startT3 = new ArrayList<Spielfigur>();
		startT4 = new ArrayList<Spielfigur>();	
		gameField = new Spielfigur[39];
		winT1 = new ArrayList<Spielfigur>();
		winT2 = new ArrayList<Spielfigur>();
		winT3 = new ArrayList<Spielfigur>();
		winT4 = new ArrayList<Spielfigur>();
	}
		
	public boolean getOutOfStart(int wuerfel){
		if(wuerfel == 6){
			return true;
		} else {
			return false;
		}
	}
	
	public void teamsSetup(){
		startT1.add(t1.getSf1());
		startT1.add(t1.getSf2());
		startT1.add(t1.getSf3());
		startT1.add(t1.getSf4());
		
		startT2.add(t2.getSf1());
		startT2.add(t2.getSf2());
		startT2.add(t2.getSf3());
		startT2.add(t2.getSf4());
		
		startT3.add(t3.getSf1());
		startT3.add(t3.getSf2());
		startT3.add(t3.getSf3());
		startT3.add(t3.getSf4());
		
		startT4.add(t4.getSf1());
		startT4.add(t4.getSf2());
		startT4.add(t4.getSf3());
		startT4.add(t4.getSf4());
	}
	
	public boolean moveOutOfStart(int team){
		if(team == 1){
			if(startT1.isEmpty()){
				return false;
			} else {
				if(canKick(t1.getName(), 0)){
					gameField[0].setPosition(-1);
					System.out.println(kick(0).toString()+" wurde zurück ins Startfeld geworfen");
					gameField[0] = startT1.remove(0);
					gameField[0].setPosition(0);
					System.out.println(gameField[0].toString()+" ist auf Position 0");
					return true;
				}
				gameField[0] = startT1.remove(0);
				gameField[0].setPosition(0);
				System.out.println(gameField[0].toString()+" ist auf Position 0");
				return true;
			}
		}
		if(team == 2){
			if(startT2.isEmpty()){
				return false;
			} else {
				if(canKick(t2.getName(), 10)){
					gameField[10].setPosition(-1);
					System.out.println(kick(10).toString()+" wurde zurück ins Startfeld geworfen");
					gameField[10] = startT1.remove(0);
					gameField[10].setPosition(0);
					System.out.println(gameField[10].toString()+" ist auf Position 10");
					return true;
				}
				gameField[10] = startT1.remove(0);
				gameField[10].setPosition(0);
				System.out.println(gameField[10].toString()+" ist auf Position 10");
				return true;
			}
		}
		if(team == 3){
			if(startT1.isEmpty()){
				return false;
			} else {
				if(canKick(t3.getName(), 20)){
					gameField[20].setPosition(-1);
					System.out.println(kick(20).toString()+" wurde zurück ins Startfeld geworfen");
					gameField[20] = startT1.remove(0);
					gameField[20].setPosition(0);
					System.out.println(gameField[20].toString()+" ist auf Position 20");
					return true;
				}
				gameField[20] = startT1.remove(0);
				gameField[20].setPosition(0);
				System.out.println(gameField[20].toString()+" ist auf Position 20");
				return true;
			}
		}
		if(team == 4){
			if(startT1.isEmpty()){
				return false;
			} else {
				if(canKick(t4.getName(), 30)){
					gameField[30].setPosition(-1);
					System.out.println(kick(30).toString()+" wurde zurück ins Startfeld geworfen");
					gameField[30] = startT1.remove(0);
					gameField[30].setPosition(0);
					System.out.println(gameField[30].toString()+" ist auf Position 30");
					return true;
				}
				gameField[30] = startT1.remove(0);
				gameField[30].setPosition(0);
				System.out.println(gameField[30].toString()+" ist auf Position 30");
				return true;
			}
		}
		return false;
	}
	
	public boolean canKick(String teamname, int feld){
		if(gameField[feld] != null && !teamname.equals(t1.getName())){
			return true;
		} 
		return false;
	}
	
	public Spielfigur kick(int feld){
		Spielfigur k = gameField[feld];
		k.setPosition(-1);
		if(k.getTeamName().equals(t1.getName())){
			gameField[feld] = null;
			startT1.add(k);
			return k;
		}
		if(k.getTeamName().equals(t2.getName())){
			gameField[feld] = null;
			startT2.add(k);
			return k;
		}
		if(k.getTeamName().equals(t3.getName())){
			gameField[feld] = null;
			startT3.add(k);
			return k;
		}
		if(k.getTeamName().equals(t4.getName())){
			gameField[feld] = null;
			startT4.add(k);
			return k;
		}
		return null;
	}
	
	public void move(Spielfigur k, int steps){
		k.setPosition(k.getPosition()+steps);
		if(k.getTeamName().equals(t1.getName())){
			if((k.getPosition())>39){
				winT1.add(k);
				gameField[k.getPosition()] = null;
				return;
			}
			if(canKick(k.getTeamName(), k.getPosition())){
				kick(k.getPosition());
				k.setPosition(k.getPosition());
				gameField[k.getPosition()] = k;
				return;
			}
		}
		
		if(k.getTeamName().equals(t2.getName())){
			
			if((k.getPosition())>39){
				winT2.add(k);
				gameField[k.getPosition()] = null;
				return;
			}
			k.setPosition(k.getPosition()+10);
			if(k.getPosition()<40){
				k.setPosition(k.getPosition()-40);
			}
			if(canKick(k.getTeamName(), k.getPosition())){
				kick(k.getPosition());
				k.setPosition(k.getPosition());
				gameField[k.getPosition()] = k;
				return;
			}
		}
		
		if(k.getTeamName().equals(t3.getName())){
			
			if((k.getPosition())>39){
				winT3.add(k);
				gameField[k.getPosition()] = null;
				return;
			}
			k.setPosition(k.getPosition()+20);
			if(k.getPosition()<40){
				k.setPosition(k.getPosition()-40);
			}
			if(canKick(k.getTeamName(), k.getPosition())){
				kick(k.getPosition());
				k.setPosition(k.getPosition());
				gameField[k.getPosition()] = k;
				return;
			}
		}
		
		if(k.getTeamName().equals(t4.getName())){
			
			if((k.getPosition())>39){
				winT4.add(k);
				gameField[k.getPosition()] = null;
				return;
			}
			k.setPosition(k.getPosition()+30);
			if(k.getPosition()<40){
				k.setPosition(k.getPosition()-40);
			}
			if(canKick(k.getTeamName(), k.getPosition())){
				kick(k.getPosition());
				k.setPosition(k.getPosition());
				gameField[k.getPosition()] = k;
				return;
			}
		}
	}
	
	public boolean win(ArrayList<Spielfigur> k){
		if(k.size() == 4){
			return true;
		}
		return false;
	}
}