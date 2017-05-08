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

public class FrameFX extends Application {
	private final Button startB;
	private final Button highscoreB;
	private final Button creditsB;
	private final BorderPane root;
	private final BorderPane gamePane;
	private Scene mainScene;
	private Scene gameScene;
	private final Button back;
	private Stage mainStage;
	private final ActionListenerFX event;
	
	public FrameFX(){
		startB = new Button(" ");
		highscoreB = new Button("Highscore");
		creditsB = new Button("Credits");
		root = new BorderPane();
		gamePane = new BorderPane();
		back = new Button("Back");
		mainStage = new Stage();
		event = new ActionListenerFX();
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
	
	
	public Button getBack() {
		return back;
	}
	
	public Stage getMainStage() {
		return mainStage;
	}


	public BorderPane getRoot() {
		return root;
	}


	public BorderPane getGamePane() {
		return gamePane;
	}


	public Scene getMainScene() {
		return mainScene;
	}


	public Scene getGameScene() {
		return gameScene;
	}


	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}


	public void setGameScene(Scene gameScene) {
		this.gameScene = gameScene;
	}


	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}


	@Override
	
	public void start(Stage primaryStage) throws IOException {
		mainStage.setTitle("Mensch Aergere Dich Nicht!");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,50,50,50));
		Text title = new Text(" ");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		mainScene = new Scene(root, 1280, 720);
		gameScene = new Scene(gamePane, 1280, 720);
		root.setStyle("-fx-background-image: url('title.jpg');-fx-background-size: auto;-fx-background-repeat: no-repeat;");
		mainStage.setScene(mainScene);
		mainStage.show();
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
		mainStage.setMaxHeight(720);
		mainStage.setMaxWidth(1280);
		mainStage.setMinHeight(720);
		mainStage.setMinWidth(1280);
		
		Text txt = new Text("Game started");
		HBox x = new HBox();
		x.getChildren().add(txt);
		gamePane.getChildren().add(x);
		HBox x2 = new HBox();
		x2.getChildren().add(back);
		gamePane.getChildren().add(x2);
	
		startB.addEventHandler(ActionEvent.ACTION, event);
		back.addEventHandler(ActionEvent.ACTION, event);
		
	}
	
	public void setMainScene(){
		mainStage.setScene(mainScene);
	}
	
	public void setGameScene(){
		mainStage.setScene(gameScene);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
