package at.spengergasse.gui;

import at.spengergasse.utils.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionListenerFX implements EventHandler<ActionEvent>{
	
	private final FrameFX gui;
	private Game game;
	
	public ActionListenerFX(FrameFX frameFX){
		gui = frameFX;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		if(source == gui.getStartB()){
			gui.getMainStage().setScene(gui.getGameScene());
		}
		if(source == gui.getBack()){
			gui.getMainStage().setScene(gui.getMainScene());
		}
	}
	
	
}
