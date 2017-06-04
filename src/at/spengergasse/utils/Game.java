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
	}

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

		startT2[0] = t3.getSf1();
		startT2[1] = t3.getSf2();
		startT2[2] = t3.getSf3();
		startT2[3] = t3.getSf4();

		startT2[0] = t4.getSf1();
		startT2[1] = t4.getSf2();
		startT2[2] = t4.getSf3();
		startT2[3] = t4.getSf4();
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
					return false;
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
					return false;
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
					return false;
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
					return false;
				}
				return false;
			}
		}
		return false;
	}

	public boolean kick(int team, int feld) {
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
				if ((b) < 40) {
					if (kick(1, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 40;
					if (k < 4) {
						if (winT1[k] != null) {
							return false;
						} else {
							winT1[k] = gameField[position];
							gameField[position] = null;
							return true;
						}
					} else {
						if (k == 4) {
							if (winT1[2] != null) {
								return false;
							}
							winT1[2] = gameField[position];
							gameField[position] = null;
							return true;
						}
						if (k == 5) {
							if (winT1[1] != null) {
								return false;
							}
							winT1[1] = gameField[position];
							gameField[position] = null;
							return true;
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 2) {
				b = position + steps;
				if (b < 39) {
					b -= 40;
				}
				if (position < 9 && b < 9 || position >= 10) {
					if (kick(2, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 10;
					if (k < 4) {
						if (winT2[k] != null) {
							return false;
						} else {
							winT2[k] = gameField[position];
							gameField[position] = null;
							return true;
						}
					} else {
						if (k == 4) {
							if (winT2[2] != null) {
								return false;
							}
							winT2[2] = gameField[position];
							gameField[position] = null;
							return true;
						}
						if (k == 5) {
							if (winT2[1] != null) {
								return false;
							}
							winT2[1] = gameField[position];
							gameField[position] = null;
							return true;
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 3) {
				b = position + steps;
				if (b < 39) {
					b -= 40;
				}
				if (position < 19 && b < 19 || position >= 20) {
					if (kick(3, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 20;
					if (k < 4) {
						if (winT3[k] != null) {
							return false;
						} else {
							winT3[k] = gameField[position];
							gameField[position] = null;
							return true;
						}
					} else {
						if (k == 4) {
							if (winT3[2] != null) {
								return false;
							}
							winT3[2] = gameField[position];
							gameField[position] = null;
							return true;
						}
						if (k == 5) {
							if (winT3[1] != null) {
								return false;
							}
							winT3[1] = gameField[position];
							gameField[position] = null;
							return true;
						}
						return false;
					}
				}
			}
			if (team == gameField[position].getTeam() && team == 4) {
				b = position + steps;
				if (b < 39) {
					b -= 40;
				}
				if (position < 29 && b < 29 || position >= 30) {
					if (kick(4, b) == false) {
						return false;
					}
					gameField[b] = gameField[position];
					gameField[position] = null;
					return true;
				} else {
					k = b - 30;
					if (k < 4) {
						if (winT4[k] != null) {
							return false;
						} else {
							winT4[k] = gameField[position];
							gameField[position] = null;
							return true;
						}
					} else {
						if (k == 4) {
							if (winT4[2] != null) {
								return false;
							}
							winT4[2] = gameField[position];
							gameField[position] = null;
							return true;
						}
						if (k == 5) {
							if (winT4[1] != null) {
								return false;
							}
							winT4[1] = gameField[position];
							gameField[position] = null;
							return true;
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

	public void moveFromWinField(int team, int position, int steps) {

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
}