package at.spengergasse.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Play extends Application{
	
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1280,720);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setMaxHeight(720);
		primaryStage.setMaxWidth(1280);
		primaryStage.setMinHeight(720);
		primaryStage.setMinWidth(1280);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
