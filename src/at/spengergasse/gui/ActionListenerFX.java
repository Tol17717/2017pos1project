package at.spengergasse.gui;

import at.spengergasse.utils.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ActionListenerFX implements EventHandler<ActionEvent> {

	private final FrameFX gui;
	private Game game;
	private final Highscore highscore;
	private final Wuerfeln wuerfel;
	private int itIsYourTurn;
	private Color t1;
	private Color t2;
	private Color t3;
	private Color t4;
	private boolean t1isBot;
	private boolean t2isBot;
	private boolean t3isBot;
	private boolean t4isBot;
	private BotTime b;

	public ActionListenerFX(FrameFX frameFX) {
		gui = frameFX;
		highscore = new Highscore();
		wuerfel = new Wuerfeln();
		itIsYourTurn = 0;
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
					}
					if (gui.getTbarr()[i].isSelected() && i == 1) {
						t1 = Color.BLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 2) {
						t1 = Color.YELLOW;
					}
					if (gui.getTbarr()[i].isSelected() && i == 3) {
						t1 = Color.GREEN;
					}
				} else if (i < 8) {
					if (gui.getTbarr()[i].isSelected() && i == 4) {
						t2 = Color.RED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 5) {
						t2 = Color.BLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 6) {
						t2 = Color.YELLOW;
					}
					if (gui.getTbarr()[i].isSelected() && i == 7) {
						t2 = Color.GREEN;
					}
				} else if (i < 12) {
					if (gui.getTbarr()[i].isSelected() && i == 8) {
						t3 = Color.RED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 9) {
						t3 = Color.BLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 10) {
						t3 = Color.YELLOW;
					}
					if (gui.getTbarr()[i].isSelected() && i == 11) {
						t3 = Color.GREEN;
					}
				} else if (i < 16) {
					if (gui.getTbarr()[i].isSelected() && i == 12) {
						t4 = Color.RED;
					}
					if (gui.getTbarr()[i].isSelected() && i == 13) {
						t4 = Color.BLUE;
					}
					if (gui.getTbarr()[i].isSelected() && i == 14) {
						t4 = Color.YELLOW;
					}
					if (gui.getTbarr()[i].isSelected() && i == 15) {
						t4 = Color.GREEN;
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				gui.getT1s()[i].setBackground(new Background(new BackgroundFill(t1, null, null)));
				gui.getT1w()[i].setBackground(new Background(new BackgroundFill(t1, null, null)));
				gui.getT2s()[i].setBackground(new Background(new BackgroundFill(t2, null, null)));
				gui.getT2w()[i].setBackground(new Background(new BackgroundFill(t2, null, null)));
				gui.getT3s()[i].setBackground(new Background(new BackgroundFill(t3, null, null)));
				gui.getT3w()[i].setBackground(new Background(new BackgroundFill(t3, null, null)));
				gui.getT4s()[i].setBackground(new Background(new BackgroundFill(t4, null, null)));
				gui.getT4w()[i].setBackground(new Background(new BackgroundFill(t4, null, null)));
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
		}
		
		for (int i = 0; i < 40; i++) {
			if (source == gui.getGameField()[i]) {
				System.out.println("button gedrückt");
			}
		}
		for (int i = 0; i < 4; i++) {
			if (source == gui.getT1s()[i] && itIsYourTurn == 0) {
				System.out.println("Ich wurde gedrückt, lul xD");
				gui.getWhosTurn().setText("Team 2 turn");
				gui.getWhosTurn().setFill(t2);
				itIsYourTurn++;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (source == gui.getT2s()[i] && itIsYourTurn == 1) {
				System.out.println("Ich wurde gedrückt, lul xD");
				gui.getWhosTurn().setText("Team 3 turn");
				gui.getWhosTurn().setFill(t3);
				itIsYourTurn++;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (source == gui.getT3s()[i] && itIsYourTurn == 2) {
				System.out.println("Ich wurde gedrückt, lul xD");
				gui.getWhosTurn().setText("Team 4 turn");
				gui.getWhosTurn().setFill(t4);
				itIsYourTurn++;
			}
		}
		for (int i = 0; i < 4; i++) {
			if (source == gui.getT4s()[i] && itIsYourTurn == 3) {
				System.out.println("Ich wurde gedrückt, lul xD");
				gui.getWhosTurn().setText("Team 1 turn");
				gui.getWhosTurn().setFill(t1);
				itIsYourTurn = 0;
			}
		}
		if (source == gui.getDice()) {
			DiceThread d = new DiceThread(gui.getDice());
			d.start();
		}		
	}
	
	
}
