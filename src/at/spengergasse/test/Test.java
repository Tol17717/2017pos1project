package at.spengergasse.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import at.spengergasse.gui.ActionListenerFX;
import at.spengergasse.gui.FrameFX;
import at.spengergasse.utils.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Test {

	public static void main(String[] args) {
	
		Game g = new Game(false, false, false, false);
		System.out.println(g.toString());
		g.moveOutOfStart(1, 0, 6);
		System.out.println(g.toString());
		System.out.println(g.moveFromWinField(1, 0, 1));
			
		
	}
	
	

}
