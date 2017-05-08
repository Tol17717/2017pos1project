package at.spengergasse.gui;

import java.util.List;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class ApplicationFX extends Application{

	public ApplicationFX() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start(Stage stage) throws Exception {	
		
	    
	    new FrameFX();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
