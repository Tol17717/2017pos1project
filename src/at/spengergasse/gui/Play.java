package at.spengergasse.gui;

import java.awt.Frame;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Play implements EventHandler<ActionEvent>{
	
	private final GUI gui = new GUI();

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Object source = event.getSource();
		if(source == gui.getStartB()){
			BorderPane test = new BorderPane();
			test.autosize();
			Text txt = new Text("Game started");
			HBox x = new HBox();
			x.getChildren().add(txt);
			test.getChildren().add(x);
			HBox x2 = new HBox();
			Button back = new Button("Back");
			x2.getChildren().add(back);
			test.getChildren().add(x2);
			Scene sc = new Scene(test, 1280, 720);
			primaryStage.setScene(sc);
			primaryStage.show();
		}
	}
	
	
}
