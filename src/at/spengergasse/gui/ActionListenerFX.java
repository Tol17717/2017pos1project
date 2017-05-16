package at.spengergasse.gui;

import at.spengergasse.utils.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionListenerFX implements EventHandler<ActionEvent> {

	private final FrameFX gui;
	private Game game;
	private final Highscore highscore;
	private final FarbeCompare fc;

	public ActionListenerFX(FrameFX frameFX) {
		gui = frameFX;
		highscore = new Highscore();
		fc = new FarbeCompare();
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
			
		}
		for (int i = 0; i < 40; i++) {
			if (source == gui.getGameField()[i]) {
				System.out.println("button gedrückt");
			}
		}
	}

}
