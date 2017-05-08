package at.spengergasse.gui;

import java.io.IOException;

import javax.print.attribute.standard.PrinterMakeAndModel;
import javax.swing.text.html.CSS;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
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
	private final Button startB;
	private final Button highscoreB;
	private final Button creditsB;
	
	public GUI(){
		startB = new Button(" ");
		highscoreB = new Button("Highscore");
		creditsB = new Button("Credits");
	}
	
	
	public Button getStartB() {
		return startB;
	}
	

	public Button getHighscoreB() {
		return highscoreB;
	}


	public Button getCreditsB() {
		return creditsB;
	}


	@Override
	
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		BorderPane root = new BorderPane();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,50,50,50));
		Text title = new Text(" ");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		Scene scene = new Scene(root, 1280, 720);
		root.setStyle("-fx-background-image: url('title.jpg');-fx-background-size: auto;-fx-background-repeat: no-repeat;");
		primaryStage.setScene(scene);
		primaryStage.show();
		GridPane gridP = new GridPane();
		gridP.setVgap(50);
		gridP.setHgap(50);
		gridP.setPadding(new Insets(50,50,50,50));
		HBox start = new HBox();
		startB.setMinHeight(190);
		startB.setMinWidth(619);
		startB.setStyle(" -fx-background-image: url('at/spengergasse/img/testicon.png')");
		start.getChildren().add(startB);
		HBox highscore = new HBox();
		highscore.getChildren().add(highscoreB);
		HBox credits = new HBox();
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
				back.setOnAction(new EventHandler<ActionEvent>(){

					@Override
					public void handle(ActionEvent event) {
						
					}
					
				});
			}
		});
	}
	
	public void setStartScreen(){
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
