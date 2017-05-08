package at.spengergasse.gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ActionListenerFX implements EventHandler<ActionEvent>{
	
	private final FrameFX gui = new FrameFX();
	
	public ActionListenerFX(){
		
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
