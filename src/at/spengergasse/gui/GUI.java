package at.spengergasse.gui;

import java.io.IOException;

import javax.swing.text.html.CSS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,50,50,50));
		Text title = new Text("Mensch Aergere Dich Nicht");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		Scene scene = new Scene(root, 1280, 720);
		root.setStyle("-fx-background-image: url('test.jpg');-fx-background-size: auto;-fx-background-repeat: no-repeat;");
		primaryStage.setScene(scene);
		primaryStage.show();
		GridPane gridP = new GridPane();
		gridP.setVgap(50);
		gridP.setHgap(50);
		gridP.setPadding(new Insets(50,50,50,50));
		HBox start = new HBox();
		Button startB = new Button("Start game");
		start.getChildren().add(startB);
		HBox highscore = new HBox();
		Button highscoreB = new Button("Highscore");
		highscore.getChildren().add(highscoreB);
		HBox credits = new HBox();
		Button creditsB = new Button("Credits");
		credits.getChildren().add(creditsB);
		gridP.add(start,0,0);
		gridP.add(highscore,0,1);
		gridP.add(credits,0,2);
		root.setLeft(gridP);
		primaryStage.setMaxHeight(720);
		primaryStage.setMaxWidth(1280);
		primaryStage.setMinHeight(720);
		primaryStage.setMinWidth(1280);
		startB.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				Play test = new Play();
				
			}
		});
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
