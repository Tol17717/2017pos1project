package at.spengergasse.utils;

import java.io.IOException;
import java.util.Arrays;

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

	private int place;

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
		place = 1;
		teamsSetup();
	}
	/**
	 * Was die Methode macht
	 * @param wuerfel, was parameter macht
	 * @return was wird zurückgegeben
	 */
	public boolean getOutOfStart(int wuerfel) {
		if (wuerfel == 6) {
			return true;
		} else {
			return false;
		}
	}

	public void teamsSetup() {
		startT1[0] = t1.getSf1();
		startT1[1] = t1.getSf2();
		startT1[2] = t1.getSf3();
		startT1[3] = t1.getSf4();

		startT2[0] = t2.getSf1();
		startT2[1] = t2.getSf2();
		startT2[2] = t2.getSf3();
		startT2[3] = t2.getSf4();

		startT3[0] = t3.getSf1();
		startT3[1] = t3.getSf2();
		startT3[2] = t3.getSf3();
		startT3[3] = t3.getSf4();

		startT4[0] = t4.getSf1();
		startT4[1] = t4.getSf2();
		startT4[2] = t4.getSf3();
		startT4[3] = t4.getSf4();
	}

	public boolean moveOutOfStart(int team, int position, int wuerfelwert) {
		if (wuerfelwert == 6) {
			if (team == 1) {
				if (startT1[position] != null) {
					if (gameField[0] == null) {
						gameField[0] = startT1[position];
						startT1[position] = null;
						return true;
					}
					if(kick(1, 0)){
						gameField[0] = startT1[position];
						startT1[position] = null;
						return true;
					}
				}
				return false;
			}
			if (team == 2) {
				if (startT2[position] != null) {
					if (gameField[10] == null) {
						gameField[10] = startT2[position];
						startT2[position] = null;
						return true;
					}
					if (kick(2, 10)){
						gameField[10] = startT2[position];
						startT2[position] = null;
						return true;
					}
				}
				return false;
			}
			if (team == 3) {
				if (startT3[position] != null) {
					if (gameField[20] == null) {
						gameField[20] = startT3[position];
						startT3[position] = null;
						return true;
					}
					if (kick(3, 20)){
						gameField[20] = startT3[position];
						startT3[position] = null;
						return true;
					}
				}
				return false;
			}
			if (team == 4) {
				if (startT4[position] != null) {
					if (gameField[30] == null) {
						gameField[30] = startT4[position];
						startT4[position] = null;
						return true;
					}
					if (kick(4, 30)){
						gameField[30] = startT4[position];
						startT4[position] = null;
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

	public boolean kick(int team, int feld) {
		if (gameField[feld] == null) {
			return true;
		}
		if (gameField[feld].getTeam() == 1 && team != 1) {
			if (startT1[0] == null) {
				startT1[0] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT1[1] == null) {
				startT1[1] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT1[2] == null) {
				startT1[2] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT1[3] == null) {
				startT1[3] = gameField[feld];
				gameField[feld] = null;
				return true;
			}
		}
		if (gameField[feld].getTeam() == 2 && team != 2) {
			if (startT2[0] == null) {
				startT2[0] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT2[1] == null) {
				startT2[1] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT2[2] == null) {
				startT2[2] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT2[3] == null) {
				startT2[3] = gameField[feld];
				gameField[feld] = null;
				return true;
			}
		}
		if (gameField[feld].getTeam() == 3 && team != 3) {
			if (startT3[0] == null) {
				startT3[0] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT3[1] == null) {
				startT3[1] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT3[2] == null) {
				startT3[2] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT3[3] == null) {
				startT3[3] = gameField[feld];
				gameField[feld] = null;
				return true;
			}
		}
		if (gameField[feld].getTeam() == 4 && team != 4) {
			if (startT4[0] == null) {
				startT4[0] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT4[1] == null) {
				startT4[1] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT4[2] == null) {
				startT4[2] = gameField[feld];
				gameField[feld] = null;
				return true;
			} else if (startT4[3] == null) {
				startT4[3] = gameField[feld];
				gameField[feld] = null;
				return true;
			}
		}
		return false;
	}

	public boolean moveFromField(int team, int position, int steps) {
		int k;
		int b;
		if (gameField[position] != null) {
			if (team == gameField[position].getTeam() && team == 1) {
				b = position + steps;
				if (b < 40) {
					if (kick(1, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 40;
					if (k < 4) {
						return canMoveInWinField(1, position, k);
					} else {
						if (k == 4) {
							return canMoveInWinField(1, position, 2);
						}
						if (k == 5) {
							return canMoveInWinField(1, position, 1);
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 2) {
				b = position + steps;
				if (b > 39) {
					b -= 40;
				}
				if (position < 10 && b < 10 || position >= 10) {
					if (kick(2, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 10;
					if (k < 4) {
						return canMoveInWinField(2, position, k);
					} else {
						if (k == 4) {
							return canMoveInWinField(2, position, 2);
						}
						if (k == 5) {
							return canMoveInWinField(2, position, 1);
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 3) {
				b = position + steps;
				if (b > 39) {
					b -= 40;
				}
				if (position < 20 && b < 20 || position >= 20) {
					if (kick(3, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 20;
					if (k < 4) {
						return canMoveInWinField(3, position, k);
					} else {
						if (k == 4) {
							return canMoveInWinField(3, position, 2);
						}
						if (k == 5) {
							return canMoveInWinField(3, position, 1);
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 4) {
				b = position + steps;
				if (b > 39) {
					b -= 40;
				}
				if (position < 30 && b < 30 || position >= 30) {
					if (kick(4, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 30;
					if (k < 4) {
						return canMoveInWinField(4, position, k);
					} else {
						if (k == 4) {
							return canMoveInWinField(4, position, 2);
						}
						if (k == 5) {
							return canMoveInWinField(4, position, 1);
						}
						return false;
					}
				}
			}
			return false;
		} else {
			return false;
		}

	}

	public boolean moveFromWinField(int team, int position, int steps) {
		int k;
		if (team == 1) {
			k = steps + position;
			if (k > 3) {
				if (k == 4) {
					return canMoveWithinWinField(1, position, 2);
				}
				if (k == 5) {
					return canMoveWithinWinField(1, position, 1);
				}
				if (k == 6) {
					return canMoveWithinWinField(1, position, 0);
				}
				if (k > 6) {
					int y = 40 - (k - 6);
					if (kick(1, y)) {
						gameField[y] = winT1[position];
						winT1[position] = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				return canMoveWithinWinField(1, position, k);
			}
		}
		if (team == 2) {
			k = steps + position;
			if (k > 3) {
				if (k == 4) {
					return canMoveWithinWinField(2, position, 2);
				}
				if (k == 5) {
					return canMoveWithinWinField(2, position, 1);
				}
				if (k == 6) {
					return canMoveWithinWinField(2, position, 0);
				}
				if (k > 6) {
					int y = 10 - (k - 6);
					if (kick(2, y)) {
						gameField[y] = winT2[position];
						winT2[position] = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				return canMoveWithinWinField(2, position, k);
			}
		}
		if (team == 3) {
			k = steps + position;
			if (k > 3) {
				if (k == 4) {
					return canMoveWithinWinField(3, position, 2);
				}
				if (k == 5) {
					return canMoveWithinWinField(3, position, 1);
				}
				if (k == 6) {
					return canMoveWithinWinField(3, position, 0);
				}
				if (k > 6) {
					int y = 20 - (k - 6);
					if (kick(3, y)) {
						gameField[y] = winT3[position];
						winT3[position] = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				return canMoveWithinWinField(3, position, k);
			}
		}
		if (team == 4) {
			k = steps + position;
			if (k > 3) {
				if (k == 4) {
					return canMoveWithinWinField(4, position, 2);
				}
				if (k == 5) {
					return canMoveWithinWinField(4, position, 1);
				}
				if (k == 6) {
					return canMoveWithinWinField(4, position, 0);
				}
				if (k > 6) {
					int y = 30 - (k - 6);
					if (kick(4, y)) {
						gameField[y] = winT4[position];
						winT4[position] = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				return canMoveWithinWinField(4, position, k);
			}
		}
		return false;
	}

	public boolean wint1() {
		for (int i = 0; i < 4; i++) {
			if (winT1[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean wint2() {
		for (int i = 0; i < 4; i++) {
			if (winT2[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean wint3() {
		for (int i = 0; i < 4; i++) {
			if (winT2[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean wint4() {
		for (int i = 0; i < 4; i++) {
			if (winT2[i] == null) {
				return false;
			}
		}
		return true;
	}

	public boolean highscoreEntry(String teamname) throws IOException {
		Highscore h = new Highscore();
		if (place == 1) {
			if (t1.isBot()) {
				place++;
				return true;
			}
			h.read();
			h.add(teamname, 10);
			h.write();
			place++;
			return true;
		}
		if (place == 2) {
			if (t2.isBot()) {
				place++;
				return true;
			}
			h.read();
			h.add(teamname, 5);
			h.write();
			place++;
			return true;
		}
		if (place == 3) {
			if (t3.isBot()) {
				place++;
				return true;
			}
			h.read();
			h.add(teamname, 3);
			h.write();
			place++;
			return true;
		}
		if (place == 4) {
			if (t4.isBot()) {
				place++;
				return true;
			}
			h.read();
			h.add(teamname, 1);
			h.write();
			return true;
		}
		return false;
	}

	public boolean canMoveInWinField(int team, int from, int to) {
		if (team == 1) {
			if (winT1[to] == null) {
				winT1[to] = gameField[from];
				gameField[from] = null;
				return true;
			}
			return false;
		}
		if (team == 2) {
			if (winT2[to] == null) {
				winT2[to] = gameField[from];
				gameField[from] = null;
				return true;
			}
			return false;
		}
		if (team == 3) {
			if (winT3[to] == null) {
				winT3[to] = gameField[from];
				gameField[from] = null;
				return true;
			}
			return false;
		}
		if (team == 4) {
			if (winT4[to] == null) {
				winT4[to] = gameField[from];
				gameField[from] = null;
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean canMoveWithinWinField(int team, int from, int to) {
		if (team == 1) {
			if (winT1[to] == null) {
				winT1[to] = winT1[from];
				winT1[from] = null;
				return true;
			}
			return false;
		}
		if (team == 2) {
			if (winT2[to] == null) {
				winT2[to] = winT2[from];
				winT2[from] = null;
				return true;
			}
			return false;
		}
		if (team == 3) {
			if (winT3[to] == null) {
				winT3[to] = winT3[from];
				winT3[from] = null;
				return true;
			}
			return false;
		}
		if (team == 4) {
			if (winT4[to] == null) {
				winT4[to] = winT4[from];
				winT4[from] = null;
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean botmove(int team, int steps) {
		if (team == 1) {
			if (t1.isBot()) {
				for (int i = 0; i < 40; i++) {
					if (i < 4) {
						if (startT1[i] != null) {
							if (moveOutOfStart(1, i, steps)) {
								return true;
							}
						}
					}
					if (gameField[i] != null && gameField[i].getTeam() == 1) {
						if (moveFromField(1, i, steps)) {
							return true;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					if (winT1[i] != null) {
						if (moveFromWinField(1, i, steps)) {
							return true;
						}
					}
				}
			}
			return false;
		} else if (team == 2) {
			if (t2.isBot()) {
				for (int i = 0; i < 40; i++) {
					if (i < 4) {
						if (startT2[i] != null) {
							if (moveOutOfStart(2, i, steps)) {
								return true;
							}
						}
					}
					if (gameField[i] != null && gameField[i].getTeam() == 2) {
						if (moveFromField(2, i, steps)) {
							return true;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					if (winT2[i] != null) {
						if (moveFromWinField(2, i, steps)) {
							return true;
						}
					}
				}
			}
			return false;
		} else if (team == 3) {
			if (t3.isBot()) {
				for (int i = 0; i < 40; i++) {
					if (i < 4) {
						if (startT3[i] != null) {
							if (moveOutOfStart(3, i, steps)) {
								return true;
							}
						}
					}
					if (gameField[i] != null && gameField[i].getTeam() == 3) {
						if (moveFromField(3, i, steps)) {
							return true;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					if (winT3[i] != null) {
						if (moveFromWinField(3, i, steps)) {
							return true;
						}
					}
				}
			}
			return false;
		} else if (team == 4) {
			if (t4.isBot()) {
				for (int i = 0; i < 40; i++) {
					if (i < 4) {
						if (startT4[i] != null) {
							if (moveOutOfStart(4, i, steps)) {
								return true;
							}
						}
					}
					if (gameField[i] != null && gameField[i].getTeam() == 4) {
						if (moveFromField(4, i, steps)) {
							return true;
						}
					}
				}
				for (int i = 0; i < 4; i++) {
					if (winT4[i] != null) {
						if (moveFromWinField(4, i, steps)) {
							return true;
						}
					}
				}
			}
			return false;
		}
		return false;
	}

	public Spielfigur[] getStartT1() {
		return startT1;
	}

	public Spielfigur[] getStartT2() {
		return startT2;
	}

	public Spielfigur[] getStartT3() {
		return startT3;
	}

	public Spielfigur[] getStartT4() {
		return startT4;
	}

	public Spielfigur[] getGameField() {
		return gameField;
	}

	public Spielfigur[] getWinT1() {
		return winT1;
	}

	public Spielfigur[] getWinT2() {
		return winT2;
	}

	public Spielfigur[] getWinT3() {
		return winT3;
	}

	public Spielfigur[] getWinT4() {
		return winT4;
	}

	public int getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Game [t1=" + t1 + ", t2=" + t2 + ", t3=" + t3 + ", t4=" + t4 + ", startT1=" + Arrays.toString(startT1)
				+ ", startT2=" + Arrays.toString(startT2) + ", startT3=" + Arrays.toString(startT3) + ", startT4="
				+ Arrays.toString(startT4) + ", gameField=" + Arrays.toString(gameField) + ", winT1="
				+ Arrays.toString(winT1) + ", winT2=" + Arrays.toString(winT2) + ", winT3=" + Arrays.toString(winT3)
				+ ", winT4=" + Arrays.toString(winT4) + ", place=" + place + "]";
	}

}