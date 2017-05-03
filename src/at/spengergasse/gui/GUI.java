package at.spengergasse.gui;

import java.awt.Button;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		try{
			BorderPane root= new BorderPane();
			Scene scene= new Scene(root,1280,720);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch(Exception e){e.printStackTrace();}
		
		}
		/*primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		GridPane gpane = new GridPane();
		gpane.setAlignment(Pos.CENTER);
		gpane.setHgap(50);
		gpane.setVgap(50);
		gpane.setPadding(new Insets(25, 25, 25, 25));
		Button btn = new Button("Play");
		HBox hbtn = new HBox(10);
		hbtn.setAlignment(Pos.CENTER);
		hbtn.getChildren().add(btn);
		gpane.add(hbtn, 2, 5);
	}*/

	public static void main(String[] args) {
		launch(args);
	}
}
