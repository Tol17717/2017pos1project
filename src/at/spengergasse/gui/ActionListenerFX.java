package at.spengergasse.gui;

import java.io.IOException;

import at.spengergasse.utils.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ActionListenerFX implements EventHandler<ActionEvent> {

	private final FrameFX gui;
	private Game game;
	private final Highscore highscore;
	private int itIsYourTurn;
	private int dice;
	private Color t1;
	private Color t2;
	private Color t3;
	private Color t4;
	private Color t1b;
	private Color t2b;
	private Color t3b;
	private Color t4b;
	private static boolean t1isBot;
	private static boolean t2isBot;
	private static boolean t3isBot;
	private static boolean t4isBot;
	private boolean t1hasWon;
	private boolean t2hasWon;
	private boolean t3hasWon;
	private boolean t4hasWon;
	private boolean t1hasStarted;
	private boolean t2hasStarted;
	private boolean t3hasStarted;
	private boolean t4hasStarted;
	private int amountBots;
	private int t1winMessage;
	private int t2winMessage;
	private int t3winMessage;
	private int t4winMessage;
	private boolean hasDiced;
	private String t1name;
	private String t2name;
	private String t3name;
	private String t4name;
	private int clickCount;
	private int countWinner;

	public ActionListenerFX(FrameFX frameFX) {
		gui = frameFX;
		highscore = new Highscore();
		t1isBot = false;
		t2isBot = false;
		t3isBot = false;
		t4isBot = false;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		if (source == gui.getStartB()) {
			gui.getMainStage().setScene(gui.getGameSelectionScene());
		}
		if (source == gui.getBack() || source == gui.getBack2() || source == gui.getBack3()) {
			gui.getMainStage().setScene(gui.getMainScene());
		}
		if (source == gui.getCreditsB()) {
			gui.getMainStage().setScene(gui.getCreditScene());
		}
		if (source == gui.getHighscoreB()) {
			gui.getMainStage().setScene(gui.getHighscoreScene());
			highscore.read();
			highscore.sort();
			try {
				if (highscore.getHighscore().get(0) != null) {
					gui.getHighscore1name().setText(highscore.getHighscore().get(0).getName());
					gui.getHighscore1points().setText("" + highscore.getHighscore().get(0).getScore());
				}
				if (highscore.getHighscore().get(1) != null) {
					gui.getHighscore2name().setText(highscore.getHighscore().get(1).getName());
					gui.getHighscore2points().setText("" + highscore.getHighscore().get(1).getScore());
				}
				if (highscore.getHighscore().get(2) != null) {
					gui.getHighscore3name().setText(highscore.getHighscore().get(2).getName());
					gui.getHighscore3points().setText("" + highscore.getHighscore().get(2).getScore());
				}
				if (highscore.getHighscore().get(3) != null) {
					gui.getHighscore4name().setText(highscore.getHighscore().get(3).getName());
					gui.getHighscore4points().setText("" + highscore.getHighscore().get(3).getScore());
				}
				if (highscore.getHighscore().get(4) != null) {
					gui.getHighscore5name().setText(highscore.getHighscore().get(4).getName());
					gui.getHighscore5points().setText("" + highscore.getHighscore().get(4).getScore());
				}
			} catch (IndexOutOfBoundsException e) {

			}
		}
		if (source == gui.getStartGame()) {
			if (gui.getT1TF().getText().equals("") && gui.getT2TF().getText().equals("")
					&& gui.getT3TF().getText().equals("") && gui.getT4TF().getText().equals("")) {
				gui.getSelectionErrTxt().setText("You need at least one human player");
				return;
			}
			boolean isSelected = false;
			for (int i = 1; i < 17; i++) {
				if (gui.getTbarr()[i - 1].isSelected()) {
					isSelected = true;
				}
				if (i % 4 == 0) {
					if (isSelected == false) {
						gui.getSelectionErrTxt().setText("Someone forgot to choose the color");
						return;
					}
					isSelected = false;
				}
			}
			for (int i = 0; i < 4; i++) {
				if (gui.getTbarr()[i].isSelected()) {
					if (gui.getTbarr()[i + 4].isSelected() || gui.getTbarr()[i + 8].isSelected()
							|| gui.getTbarr()[i + 12].isSelected()) {
						gui.getSelectionErrTxt().setText("Please select different colors");
						return;
					}
				}
				if (gui.getTbarr()[i + 4].isSelected()) {
					if (gui.getTbarr()[i].isSelected() || gui.getTbarr()[i + 8].isSelected()
							|| gui.getTbarr()[i + 12].isSelected()) {
						gui.getSelectionErrTxt().setText("Please select different colors");
						return;
					}
				}
				if (gui.getTbarr()[i + 8].isSelected()) {
					if (gui.getTbarr()[i + 4].isSelected() || gui.getTbarr()[i].isSelected()
							|| gui.getTbarr()[i + 12].isSelected()) {
						gui.getSelectionErrTxt().setText("Please select different colors");
						return;
					}
				}
				if (gui.getTbarr()[i + 12].isSelected()) {
					if (gui.getTbarr()[i + 4].isSelected() || gui.getTbarr()[i + 8].isSelected()
							|| gui.getTbarr()[i].isSelected()) {
						gui.getSelectionErrTxt().setText("Please select different colors");
						return;
					}
				}
			}
			for (int i = 0; i < 16; i++) {
				if (i < 4) {
					if (gui.getTbarr()[i].isSelected() && i == 0) {
						t1 = Color.RED;
						t1b = Color.INDIANRED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 1) {
						t1 = Color.BLUE;
						t1b = Color.STEELBLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 2) {
						t1 = Color.YELLOW;
						t1b = Color.web("#f7ff9b");
					}
					if (gui.getTbarr()[i].isSelected() && i == 3) {
						t1 = Color.GREEN;
						t1b = Color.LIGHTGREEN;
					}
				} else if (i < 8) {
					if (gui.getTbarr()[i].isSelected() && i == 4) {
						t2 = Color.RED;
						t2b = Color.INDIANRED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 5) {
						t2 = Color.BLUE;
						t2b = Color.STEELBLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 6) {
						t2 = Color.YELLOW;
						t2b = Color.web("#f7ff9b");
					}
					if (gui.getTbarr()[i].isSelected() && i == 7) {
						t2 = Color.GREEN;
						t2b = Color.LIGHTGREEN;
					}
				} else if (i < 12) {
					if (gui.getTbarr()[i].isSelected() && i == 8) {
						t3 = Color.RED;
						t3b = Color.INDIANRED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 9) {
						t3 = Color.BLUE;
						t3b = Color.STEELBLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 10) {
						t3 = Color.YELLOW;
						t3b = Color.web("#f7ff9b");
					}
					if (gui.getTbarr()[i].isSelected() && i == 11) {
						t3 = Color.GREEN;
						t3b = Color.LIGHTGREEN;
					}
				} else if (i < 16) {
					if (gui.getTbarr()[i].isSelected() && i == 12) {
						t4 = Color.RED;
						t4b = Color.INDIANRED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 13) {
						t4 = Color.BLUE;
						t4b = Color.STEELBLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 14) {
						t4 = Color.YELLOW;
						t4b = Color.web("#f7ff9b");
					}
					if (gui.getTbarr()[i].isSelected() && i == 15) {
						t4 = Color.GREEN;
						t4b = Color.LIGHTGREEN;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				gui.getT1s()[i].setBackground(new Background(new BackgroundFill(t1, null, null)));
				if (t1.equals(Color.BLUE)) {
					gui.getT1s()[i].setTextFill(Color.WHITE);
				}
				gui.getT1w()[i].setBackground(new Background(new BackgroundFill(t1b, null, null)));
				gui.getT2s()[i].setBackground(new Background(new BackgroundFill(t2, null, null)));
				if (t2.equals(Color.BLUE)) {
					gui.getT2s()[i].setTextFill(Color.WHITE);
				}
				gui.getT2w()[i].setBackground(new Background(new BackgroundFill(t2b, null, null)));
				gui.getT3s()[i].setBackground(new Background(new BackgroundFill(t3, null, null)));
				if (t3.equals(Color.BLUE)) {
					gui.getT3s()[i].setTextFill(Color.WHITE);
				}
				gui.getT3w()[i].setBackground(new Background(new BackgroundFill(t3b, null, null)));
				gui.getT4s()[i].setBackground(new Background(new BackgroundFill(t4, null, null)));
				if (t4.equals(Color.BLUE)) {
					gui.getT4s()[i].setTextFill(Color.WHITE);
				}
				gui.getT4w()[i].setBackground(new Background(new BackgroundFill(t4b, null, null)));
			}
			if (gui.getT1TF().getText().equals("")) {
				gui.getShowT1name().setText("Bot");
				t1isBot = true;
			} else {
				gui.getShowT1name().setText(gui.getT1TF().getText());
				gui.getShowT1name().setFill(t1);
			}
			gui.getShowT1name().setStyle("-fx-font: 20px Tahoma");
			gui.getT1who().setStyle("-fx-font: 20px Tahoma");
			gui.getT1who().setFill(t1);
			if (gui.getT2TF().getText().equals("")) {
				gui.getShowT2name().setText("Bot");
				t2isBot = true;
			} else {
				gui.getShowT2name().setText(gui.getT2TF().getText());
				gui.getShowT2name().setFill(t2);
			}
			gui.getShowT2name().setStyle("-fx-font: 20px Tahoma");
			gui.getT2who().setStyle("-fx-font: 20px Tahoma");
			gui.getT2who().setFill(t2);
			if (gui.getT3TF().getText().equals("")) {
				gui.getShowT3name().setText("Bot");
				t3isBot = true;
			} else {
				gui.getShowT3name().setText(gui.getT3TF().getText());
				gui.getShowT3name().setFill(t3);
			}
			gui.getShowT3name().setStyle("-fx-font: 20px Tahoma");
			gui.getT3who().setStyle("-fx-font: 20px Tahoma");
			gui.getT3who().setFill(t3);
			if (gui.getT4TF().getText().equals("")) {
				gui.getShowT4name().setText("Bot");
				t4isBot = true;
			} else {
				gui.getShowT4name().setText(gui.getT4TF().getText());
				gui.getShowT4name().setFill(t4);
			}
			gui.getShowT4name().setStyle("-fx-font: 20px Tahoma");
			gui.getT4who().setStyle("-fx-font: 20px Tahoma");
			gui.getT4who().setFill(t4);

			gui.getWhosTurn().setFill(t1);

			gui.getMainStage().setScene(gui.getGameScene());
			t1name = gui.getShowT1name().getText();
			t2name = gui.getShowT2name().getText();
			t3name = gui.getShowT3name().getText();
			t4name = gui.getShowT4name().getText();
			itIsYourTurn = 0;
			t1hasWon = false;
			t2hasWon = false;
			t3hasWon = false;
			t4hasWon = false;
			hasDiced = false;
			t1winMessage = 0;
			t2winMessage = 0;
			t3winMessage = 0;
			t4winMessage = 0;
			t1hasStarted = false;
			t2hasStarted = false;
			t3hasStarted = false;
			t4hasStarted = false;
			amountBots = 0;
			countWinner = 1;
			game = new Game(t1isBot, t2isBot, t3isBot, t4isBot);
			if (t1isBot) {
				amountBots++;
			}
			if (t2isBot) {
				amountBots++;
			}
			if (t3isBot) {
				amountBots++;
			}
			if (t4isBot) {
				amountBots++;
			}
			refresh(game);
			bot();
		}
		if (t1isBot == false && itIsYourTurn == 0 && hasDiced && t1hasWon == false) {
			for (int i = 0; i < 40; i++) {
				if (source == gui.getGameField()[i]) {
					System.out.println("ok");
					if (game.moveFromField(1, i, dice)) {
						gui.getWhosTurn().setText("Team 2 turn");
						gui.getWhosTurn().setFill(t2);
						itIsYourTurn++;
						hasDiced = false;
						refresh(game);
						try {
							checkifWon(game);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (t2hasStarted) {
							gui.getWhatToDo().setText("1 roll available");
						} else {
							gui.getWhatToDo().setText("3 rolls available");
						}
						bot();
					}
				}
				if (i < 4) {
					if (source == gui.getT1s()[i]) {
						System.out.println(dice);
						if (game.moveOutOfStart(1, i, dice)) {
							gui.getWhosTurn().setText("Team 2 turn");
							gui.getWhosTurn().setFill(t2);
							System.out.println(game.toString());
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t2hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
					if (source == gui.getT1w()[i]) {
						System.out.println("Test");

						if (game.moveFromWinField(1, i, dice)) {
							gui.getWhosTurn().setText("Team 2 turn");
							gui.getWhosTurn().setFill(t2);
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t2hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}

				}
			}
		} else if (t2isBot == false && itIsYourTurn == 1 && hasDiced && t2hasWon == false) {
			for (int i = 0; i < 40; i++) {
				if (i < 4) {
					if (source == gui.getT2s()[i]) {
						System.out.println(dice);
						if (game.moveOutOfStart(2, i, dice)) {
							gui.getWhosTurn().setText("Team 3 turn");
							gui.getWhosTurn().setFill(t3);
							System.out.println(game.toString());
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t3hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
					if (source == gui.getT2w()[i]) {
						if (game.moveFromWinField(2, i, dice)) {
							gui.getWhosTurn().setText("Team 3 turn");
							gui.getWhosTurn().setFill(t3);
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t3hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
				}
				if (source == gui.getGameField()[i]) {
					if (game.moveFromField(2, i, dice)) {
						gui.getWhosTurn().setText("Team 3 turn");
						gui.getWhosTurn().setFill(t3);
						itIsYourTurn++;
						hasDiced = false;
						refresh(game);
						try {
							checkifWon(game);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (t3hasStarted) {
							gui.getWhatToDo().setText("1 roll available");
						} else {
							gui.getWhatToDo().setText("3 rolls available");
						}
						bot();
					}
				}
			}
		} else if (t3isBot == false && itIsYourTurn == 2 && hasDiced && t3hasWon == false) {
			for (int i = 0; i < 40; i++) {
				if (i < 4) {
					if (source == gui.getT3s()[i]) {
						System.out.println(dice);
						if (game.moveOutOfStart(3, i, dice)) {
							gui.getWhosTurn().setText("Team 4 turn");
							gui.getWhosTurn().setFill(t4);
							System.out.println(game.toString());
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t4hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
					if (source == gui.getT3w()[i]) {
						if (game.moveFromWinField(3, i, dice)) {
							gui.getWhosTurn().setText("Team 4 turn");
							gui.getWhosTurn().setFill(t4);
							itIsYourTurn++;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t4hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
				}
				if (source == gui.getGameField()[i]) {
					if (game.moveFromField(3, i, dice)) {
						gui.getWhosTurn().setText("Team 4 turn");
						gui.getWhosTurn().setFill(t4);
						itIsYourTurn++;
						hasDiced = false;
						refresh(game);
						try {
							checkifWon(game);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (t4hasStarted) {
							gui.getWhatToDo().setText("1 roll available");
						} else {
							gui.getWhatToDo().setText("3 rolls available");
						}
						bot();
					}
				}
			}
		} else if (t4isBot == false && itIsYourTurn == 3 && hasDiced && t4hasWon == false) {
			for (int i = 0; i < 40; i++) {
				if (i < 4) {
					if (source == gui.getT4s()[i]) {
						System.out.println(dice);
						if (game.moveOutOfStart(4, i, dice)) {
							gui.getWhosTurn().setText("Team 1 turn");
							gui.getWhosTurn().setFill(t1);
							System.out.println(game.toString());
							itIsYourTurn = 0;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t1hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
					if (source == gui.getT4w()[i]) {
						if (game.moveFromWinField(4, i, dice)) {
							gui.getWhosTurn().setText("Team 1 turn");
							gui.getWhosTurn().setFill(t1);
							itIsYourTurn = 0;
							hasDiced = false;
							refresh(game);
							try {
								checkifWon(game);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (t1hasStarted) {
								gui.getWhatToDo().setText("1 roll available");
							} else {
								gui.getWhatToDo().setText("3 rolls available");
							}
							bot();
						}
					}
				}
				if (source == gui.getGameField()[i]) {
					if (game.moveFromField(4, i, dice)) {
						gui.getWhosTurn().setText("Team 1 turn");
						gui.getWhosTurn().setFill(t1);
						itIsYourTurn = 0;
						hasDiced = false;
						refresh(game);
						try {
							checkifWon(game);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (t1hasStarted) {
							gui.getWhatToDo().setText("1 roll available");
						} else {
							gui.getWhatToDo().setText("3 rolls available");
						}
						bot();
					}
				}
			}
		}
		if (hasDiced == false) {
			if (source == gui.getDice()) {
				dice();
				bot();
			}
		}
		if (source == gui.getSkipRound()) {
			if (itIsYourTurn == 0) {
				gui.getWhosTurn().setText("Team 2 turn");
				gui.getWhosTurn().setFill(t2);
				itIsYourTurn++;
				hasDiced = false;
				refresh(game);
				try {
					checkifWon(game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (t2hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
				bot();
			}
			if (itIsYourTurn == 1) {
				gui.getWhosTurn().setText("Team 3 turn");
				gui.getWhosTurn().setFill(t3);
				itIsYourTurn++;
				hasDiced = false;
				refresh(game);
				try {
					checkifWon(game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (t3hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
				bot();
			}
			if (itIsYourTurn == 2) {
				gui.getWhosTurn().setText("Team 4 turn");
				gui.getWhosTurn().setFill(t4);
				itIsYourTurn++;
				hasDiced = false;
				refresh(game);
				try {
					checkifWon(game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (t4hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
				bot();
			}
			if (itIsYourTurn == 3) {
				gui.getWhosTurn().setText("Team 1 turn");
				gui.getWhosTurn().setFill(t1);
				itIsYourTurn = 0;
				hasDiced = false;
				refresh(game);
				try {
					checkifWon(game);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (t1hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
				bot();
			}
		}

	}

	public void refresh(Game game) {
		for (int i = 0; i < 40; i++) {
			if (i < 4) {

				if (game.getStartT1()[i] == null) {
					gui.changeStartField(i, 1, t1, t1b, true);
				}
				if (game.getStartT2()[i] == null) {
					gui.changeStartField(i, 2, t2, t2b, true);
				}
				if (game.getStartT3()[i] == null) {
					gui.changeStartField(i, 3, t3, t3b, true);
				}
				if (game.getStartT4()[i] == null) {
					gui.changeStartField(i, 4, t4, t4b, true);
				}

				if (game.getStartT1()[i] != null) {
					gui.changeStartField(i, 1, t1, t1b, false);
				}
				if (game.getStartT2()[i] != null) {
					gui.changeStartField(i, 2, t2, t2b, false);
				}
				if (game.getStartT3()[i] != null) {
					gui.changeStartField(i, 3, t3, t3b, false);
				}
				if (game.getStartT4()[i] != null) {
					gui.changeStartField(i, 4, t4, t4b, false);
				}

				if (game.getWinT1()[i] == null) {
					gui.changeWinField(i, 1, t1, t1b, true);
				}
				if (game.getWinT2()[i] == null) {
					gui.changeWinField(i, 2, t2, t2b, true);
				}
				if (game.getWinT3()[i] == null) {
					gui.changeWinField(i, 3, t3, t3b, true);
				}
				if (game.getWinT4()[i] == null) {
					gui.changeWinField(i, 4, t4, t4b, true);
				}

				if (game.getWinT1()[i] != null) {
					gui.changeWinField(i, 1, t1, t1b, false);
				}
				if (game.getWinT2()[i] != null) {
					gui.changeWinField(i, 2, t2, t2b, false);
				}
				if (game.getWinT3()[i] != null) {
					gui.changeWinField(i, 3, t3, t3b, false);
				}
				if (game.getWinT4()[i] != null) {
					gui.changeWinField(i, 4, t4, t4b, false);
				}

			}

			if (game.getGameField()[i] == null) {
				if (i == 0) {
					gui.changeGameField(i, t1b, true);
				} else if (i == 10) {
					gui.changeGameField(i, t2b, true);
				} else if (i == 20) {
					gui.changeGameField(i, t3b, true);
				} else if (i == 30) {
					gui.changeGameField(i, t4b, true);
				} else {
					gui.changeGameField(i, Color.BEIGE, true);
				}
			}
			if (game.getGameField()[i] != null && game.getGameField()[i].getTeam() == 1) {
				gui.changeGameField(i, t1, false);
			}
			if (game.getGameField()[i] != null && game.getGameField()[i].getTeam() == 2) {
				gui.changeGameField(i, t2, false);
			}
			if (game.getGameField()[i] != null && game.getGameField()[i].getTeam() == 3) {
				gui.changeGameField(i, t3, false);
			}
			if (game.getGameField()[i] != null && game.getGameField()[i].getTeam() == 4) {
				gui.changeGameField(i, t4, false);
			}

		}
	}

	public void dice() {
		Wuerfeln w = new Wuerfeln();
		dice = w.wuerfeln() + 1;
		if (itIsYourTurn == 0 && t1isBot || itIsYourTurn == 1 && t2isBot || itIsYourTurn == 2 && t3isBot
				|| itIsYourTurn == 3 && t4isBot) {

		} else if (itIsYourTurn == 0 && t1isBot == false || itIsYourTurn == 1 && t2isBot == false
				|| itIsYourTurn == 2 && t3isBot == false || itIsYourTurn == 3 && t4isBot == false) {
			DiceThread d = new DiceThread(gui.getDice(), dice);
			d.start();
		} else {
			if (itIsYourTurn == 0 || itIsYourTurn == 1 || itIsYourTurn == 2) {
				itIsYourTurn++;
			}
			if (itIsYourTurn >= 4) {
				itIsYourTurn = 0;
			}
		}
		System.out.println(dice);
		if (itIsYourTurn == 0 && t1hasStarted == false) {
			clickCount++;
			if (clickCount == 1) {
				gui.getWhatToDo().setText("2 rolls available");
			}
			if (clickCount == 2) {
				gui.getWhatToDo().setText("1 roll available");
			}
			if (clickCount == 3 && dice != 6) {
				clickCount = 0;
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 2 turn");
				gui.getWhosTurn().setFill(t2);
				hasDiced = false;
				if (t2hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			}
			if (dice == 6) {
				clickCount = 0;
				hasDiced = true;
				t1hasStarted = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 1 && t2hasStarted == false) {
			clickCount++;
			if (clickCount == 1) {
				gui.getWhatToDo().setText("2 rolls available");
			}
			if (clickCount == 2) {
				gui.getWhatToDo().setText("1 roll available");
			}
			if (clickCount == 3 && dice != 6) {
				clickCount = 0;
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 3 turn");
				gui.getWhosTurn().setFill(t3);
				hasDiced = false;
				if (t3hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			}
			if (dice == 6) {
				clickCount = 0;
				hasDiced = true;
				t2hasStarted = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 2 && t3hasStarted == false) {
			clickCount++;
			if (clickCount == 1) {
				gui.getWhatToDo().setText("2 rolls available");
			}
			if (clickCount == 2) {
				gui.getWhatToDo().setText("1 roll available");
			}
			if (clickCount == 3 && dice != 6) {
				clickCount = 0;
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 4 turn");
				gui.getWhosTurn().setFill(t4);
				hasDiced = false;
				if (t4hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			}
			if (dice == 6) {
				clickCount = 0;
				hasDiced = true;
				t3hasStarted = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 3 && t4hasStarted == false) {
			clickCount++;
			if (clickCount == 1) {
				gui.getWhatToDo().setText("2 rolls available");
			}
			if (clickCount == 2) {
				gui.getWhatToDo().setText("1 roll available");
			}
			if (clickCount == 3 && dice != 6) {
				clickCount = 0;
				itIsYourTurn = 0;
				gui.getWhosTurn().setText("Team 1 turn");
				gui.getWhosTurn().setFill(t1);
				hasDiced = false;
				if (t1hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			}
			if (dice == 6) {
				clickCount = 0;
				hasDiced = true;
				t4hasStarted = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 0 && t1hasStarted) {
			int c = 0;
			for (int i = 0; i < 4; i++) {
				if (game.getStartT1()[i] != null) {
					c++;
				}
			}
			if (c == 4 && dice != 6) {
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 2 turn");
				gui.getWhosTurn().setFill(t2);
				hasDiced = false;
				if (t2hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			} else {
				hasDiced = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 1 && t2hasStarted) {
			int c = 0;
			for (int i = 0; i < 4; i++) {
				if (game.getStartT2()[i] != null) {
					c++;
				}
			}
			if (c == 4 && dice != 6) {
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 3 turn");
				gui.getWhosTurn().setFill(t3);
				hasDiced = false;
				if (t3hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			} else {
				hasDiced = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 2 && t3hasStarted) {
			int c = 0;
			for (int i = 0; i < 4; i++) {
				if (game.getStartT3()[i] != null) {
					c++;
				}
			}
			if (c == 4 && dice != 6) {
				itIsYourTurn++;
				gui.getWhosTurn().setText("Team 4 turn");
				gui.getWhosTurn().setFill(t4);
				hasDiced = false;
				if (t4hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			} else {
				hasDiced = true;
				gui.getWhatToDo().setText("Move now");
			}
		} else if (itIsYourTurn == 3 && t4hasStarted) {
			int c = 0;
			for (int i = 0; i < 4; i++) {
				if (game.getStartT4()[i] != null) {
					c++;
				}
			}
			if (c == 4 && dice != 6) {
				itIsYourTurn = 0;
				gui.getWhosTurn().setText("Team 1 turn");
				gui.getWhosTurn().setFill(t1);
				hasDiced = false;
				if (t1hasStarted) {
					gui.getWhatToDo().setText("1 roll available");
				} else {
					gui.getWhatToDo().setText("3 rolls available");
				}
			} else {
				hasDiced = true;
				gui.getWhatToDo().setText("Move now");
			}
		}
	}

	public void checkifWon(Game game) throws IOException {

		if (game.wint1()) {
			t1winMessage++;
		}
		if (game.wint2()) {
			t2winMessage++;
		}
		if (game.wint3()) {
			t2winMessage++;
		}
		if (game.wint4()) {
			t2winMessage++;
		}

		if (t1winMessage == 1) {
			t1hasWon = true;
			game.highscoreEntry(t1name);
			Alert a = new Alert(AlertType.INFORMATION);
			if (countWinner == 1) {
				a.setTitle("We have a winner");
				a.setContentText(t1name + "just won the game");
			} else {
				a.setTitle("The " + countWinner + ". place goes to:");
				a.setContentText(t1name);
			}
			a.setHeaderText("");
			a.show();
			countWinner++;
		}
		if (t2winMessage == 1) {
			t1hasWon = true;
			game.highscoreEntry(t2name);
			Alert a = new Alert(AlertType.INFORMATION);
			if (countWinner == 1) {
				a.setTitle("We have a winner");
				a.setContentText(t2name + "just won the game");
			} else {
				a.setTitle("The " + countWinner + ". place goes to:");
				a.setContentText(t2name);
			}
			a.setHeaderText("");
			a.show();
			countWinner++;
		}
		if (t3winMessage == 1) {
			t1hasWon = true;
			game.highscoreEntry(t3name);
			Alert a = new Alert(AlertType.INFORMATION);
			if (countWinner == 1) {
				a.setTitle("We have a winner");
				a.setContentText(t3name + " just won the game");
			} else {
				a.setTitle("The " + countWinner + ". place goes to:");
				a.setContentText(t3name);
			}
			a.setHeaderText("");
			a.show();
			countWinner++;
		}
		if (t4winMessage == 1) {
			t1hasWon = true;
			game.highscoreEntry(t4name);
			Alert a = new Alert(AlertType.INFORMATION);
			if (countWinner == 1) {
				a.setTitle("We have a winner");
				a.setContentText(t4name + "just won the game");
			} else {
				a.setTitle("The " + countWinner + ". place goes to:");
				a.setContentText(t4name);
			}
			a.setHeaderText("");
			a.show();
		}
		if (amountBots > 1) {
			int c = 0;
			if (t1isBot == false && t1hasWon) {
				c++;
			}
			if (t2isBot == false && t2hasWon) {
				c++;
			}
			if (t3isBot == false && t3hasWon) {
				c++;
			}
			if (t4isBot == false && t4hasWon) {
				c++;
			}
			if ((c + amountBots) == 4) {
				gui.getMainStage().setScene(gui.getMainScene());
			}
		}
		if (countWinner == 4) {
			gui.getMainStage().setScene(gui.getMainScene());
			if (t1winMessage == 0) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Last, but not least");
				a.setContentText(t1name);
				a.setHeaderText("");
				a.show();
			}
			if (t2winMessage == 0) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Last, but not least");
				a.setContentText(t2name);
				a.setHeaderText("");
				a.show();
			}
			if (t3winMessage == 0) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Last, but not least");
				a.setContentText(t3name);
				a.setHeaderText("");
				a.show();
			}
			if (t4winMessage == 0) {
				Alert a = new Alert(AlertType.INFORMATION);
				a.setTitle("Last, but not least");
				a.setContentText(t4name);
				a.setHeaderText("");
				a.show();
			}
		}

	}

	public void bot() {
		for (int x = 0; x < 5; x++) {
			if (itIsYourTurn == 0 && t1hasWon) {
				itIsYourTurn++;
			}
			if (itIsYourTurn == 1 && t2hasWon) {
				itIsYourTurn++;
			}
			if (itIsYourTurn == 2 && t3hasWon) {
				itIsYourTurn++;
			}
			if (itIsYourTurn == 3 && t4hasWon) {
				itIsYourTurn = 0;
			}
			if (t1isBot && itIsYourTurn == 0) {
				if (t1hasStarted == false) {
					for (int i = 0; i < 3; i++) {
						dice();
						if (dice == 6) {
							game.botmove(1, 6);
							break;
						}
					}
					System.out.println("Bot 1 hat gedrückt");
					gui.getWhosTurn().setText("Team 2 turn");
					gui.getWhosTurn().setFill(t2);
					if (dice == 6)
						itIsYourTurn++;
					if (t2hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					hasDiced = false;
					refresh(game);
				} else {
					dice();
					game.botmove(1, dice);
					System.out.println("Bot 1 hat gedrückt");
					gui.getWhosTurn().setText("Team 2 turn");
					gui.getWhosTurn().setFill(t2);
					itIsYourTurn++;
					hasDiced = false;
					if (t2hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					refresh(game);
				}
			} else if (t2isBot && itIsYourTurn == 1) {
				if (t2hasStarted == false) {
					for (int i = 0; i < 3; i++) {
						dice();
						if (dice == 6) {
							game.botmove(2, 6);
							break;
						}
					}
					System.out.println("Bot 2 hat gedrückt");
					gui.getWhosTurn().setText("Team 3 turn");
					gui.getWhosTurn().setFill(t3);
					if (dice == 6)
						itIsYourTurn++;
					if (t2hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					hasDiced = false;
					refresh(game);
				} else {
					dice();
					game.botmove(2, dice);
					System.out.println("Bot 2 hat gedrückt");
					gui.getWhosTurn().setText("Team 3 turn");
					gui.getWhosTurn().setFill(t3);
					itIsYourTurn++;
					hasDiced = false;
					if (t3hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					refresh(game);
				}
			} else if (t3isBot && itIsYourTurn == 2) {
				if (t3hasStarted == false) {
					for (int i = 0; i < 3; i++) {
						dice();
						if (dice == 6) {
							game.botmove(3, 6);
							break;
						}
					}
					System.out.println("Bot 3 hat gedrückt");
					gui.getWhosTurn().setText("Team 4 turn");
					gui.getWhosTurn().setFill(t4);
					if (dice == 6)
						itIsYourTurn++;
					if (t4hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					hasDiced = false;
					refresh(game);
				} else {
					dice();
					game.botmove(3, dice);
					System.out.println("Bot 3 hat gedrückt");
					gui.getWhosTurn().setText("Team 4 turn");
					gui.getWhosTurn().setFill(t4);
					itIsYourTurn++;
					hasDiced = false;
					if (t4hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					refresh(game);
				}
			} else if (t4isBot && itIsYourTurn == 3) {
				if (t4hasStarted == false) {
					for (int i = 0; i < 3; i++) {
						dice();
						if (dice == 6) {
							game.botmove(4, 6);
							break;
						}
					}
					System.out.println("Bot 4 hat gedrückt");
					gui.getWhosTurn().setText("Team 1 turn");
					gui.getWhosTurn().setFill(t1);
					if (dice == 6)
						itIsYourTurn = 0;
					refresh(game);
					if (t1hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					hasDiced = false;
				} else {
					dice();
					game.botmove(4, dice);
					System.out.println("Bot 4 hat gedrückt");
					gui.getWhosTurn().setText("Team 1 turn");
					gui.getWhosTurn().setFill(t1);
					itIsYourTurn = 0;
					hasDiced = false;
					if (t1hasStarted) {
						gui.getWhatToDo().setText("1 roll available");
					} else {
						gui.getWhatToDo().setText("3 rolls available");
					}
					refresh(game);
				}
				itIsYourTurn = 0;
			}
			try {
				checkifWon(game);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
