package at.spengergasse.gui;

import java.io.IOException;
import java.util.List;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

public class FrameFX extends Stage {
	private final Button startB;
	private final Button highscoreB;
	private final Button creditsB;
	private final BorderPane root;
	private final GridPane gameSelectionPane;
	private final GridPane creditPane;
	private Scene mainScene;
	private Scene gameScene;
	private Scene creditScene;
	private final Button back;
	private final Button back2;
	private Stage mainStage;
	private final ActionListenerFX event;
	private final List<String> args;
	private final TextField t1TF;
	private final TextField t2TF;
	private final TextField t3TF;
	private final TextField t4TF;
	private final ToggleGroup groupColorsT1;
	private final ToggleGroup groupColorsT2;
	private final ToggleGroup groupColorsT3;
	private final ToggleGroup groupColorsT4;
	private final Text selectionTxt;
	private final Button startGame;
	
	public FrameFX(List<String> parameters){
		startB = new Button(" ");
		highscoreB = new Button(" ");
		creditsB = new Button(" ");
		root = new BorderPane();
		gameSelectionPane = new GridPane();
		creditPane = new GridPane();
		back = new Button("Back");
		back2 = new Button("Back");
		mainStage = new Stage();
		args = parameters;
		event = new ActionListenerFX(this);
		t1TF = new TextField();
		t2TF = new TextField();
		t3TF = new TextField();
		t4TF = new TextField();
		groupColorsT1 = new ToggleGroup(); 
		groupColorsT2 = new ToggleGroup(); 
		groupColorsT3 = new ToggleGroup(); 
		groupColorsT4 = new ToggleGroup(); 
		selectionTxt = new Text("ERROR MESSAGE TEST");
		startGame = new Button("Start Game");
		
		mainStage.setTitle("Mensch Aergere Dich Nicht!");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,50,50,50));
		Text title = new Text(" ");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		mainScene = new Scene(root, 1280, 720);
		gameScene = new Scene(gameSelectionPane, 1280, 720);
		creditScene = new Scene(creditPane, 1280, 720);
		root.setStyle("-fx-background-image: url('at/spengergasse/img/title.jpg');-fx-background-size: auto;-fx-background-repeat: no-repeat;");
		mainStage.setScene(mainScene);
		mainStage.show();
		GridPane gridP = new GridPane();
		gridP.setVgap(50);
		gridP.setHgap(50);
		gridP.setPadding(new Insets(50,50,50,50));
		HBox start = new HBox();
		startB.setMinHeight(92);
		startB.setMinWidth(300);
		startB.setStyle("-fx-background-image: url('at/spengergasse/img/playbutton.png')");
		highscoreB.setMinHeight(92);
		highscoreB.setMinWidth(300);
		highscoreB.setStyle("-fx-background-image: url('at/spengergasse/img/highscorebutton.png')");
		creditsB.setMinHeight(92);
		creditsB.setMinWidth(300);
		creditsB.setStyle("-fx-background-image: url('at/spengergasse/img/creditsbutton.png')");
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
		
		Text selectionText = new Text("Please select your teams");
		selectionText.setStyle("-fx-font: 50px Tahoma");
		Text pickColorText = new Text("Pick your colors");
		pickColorText.setStyle("-fx-font: 50px Tahoma");
		gameSelectionPane.setHgap(50);
		gameSelectionPane.setVgap(50);
		gameSelectionPane.setPadding(new Insets(50,50,50,50));
		gameSelectionPane.setStyle("-fx-background-color: #47a6c2");
		gameSelectionPane.add(selectionText, 1, 0);
		gameSelectionPane.add(pickColorText, 2, 0, 4, 1);
		gameSelectionPane.add(back, 0, 0);
		Text nameT1txt = new Text("Team 1:");
		Text nameT2txt = new Text("Team 2:");
		Text nameT3txt = new Text("Team 3:");
		Text nameT4txt = new Text("Team 4:");
		gameSelectionPane.add(nameT1txt, 0, 1);
		gameSelectionPane.add(nameT2txt, 0, 2);
		gameSelectionPane.add(nameT3txt, 0, 3);
		gameSelectionPane.add(nameT4txt, 0, 4);
		t1TF.setPromptText("Enter the team name, leave it blank for a bot player");
		t2TF.setPromptText("Enter the team name, leave it blank for a bot player");
		t3TF.setPromptText("Enter the team name, leave it blank for a bot player");
		t4TF.setPromptText("Enter the team name, leave it blank for a bot player");		
		gameSelectionPane.add(t1TF, 1, 1);
		gameSelectionPane.add(t2TF, 1, 2);
		gameSelectionPane.add(t3TF, 1, 3);
		gameSelectionPane.add(t4TF, 1, 4);
		RadioButton redT1 = new RadioButton("Red");
		RadioButton blueT1 = new RadioButton("Blue");
		RadioButton yellowT1 = new RadioButton("Yellow");
		RadioButton greenT1 = new RadioButton("Green");
		RadioButton redT2 = new RadioButton("Red");
		RadioButton blueT2 = new RadioButton("Blue");
		RadioButton yellowT2 = new RadioButton("Yellow");
		RadioButton greenT2 = new RadioButton("Green");
		RadioButton redT3 = new RadioButton("Red");
		RadioButton blueT3 = new RadioButton("Blue");
		RadioButton yellowT3 = new RadioButton("Yellow");
		RadioButton greenT3 = new RadioButton("Green");
		RadioButton redT4 = new RadioButton("Red");
		RadioButton blueT4 = new RadioButton("Blue");
		RadioButton yellowT4 = new RadioButton("Yellow");
		RadioButton greenT4 = new RadioButton("Green");
	    redT1.setToggleGroup(groupColorsT1);
	    yellowT1.setToggleGroup(groupColorsT1);
	    blueT1.setToggleGroup(groupColorsT1);
	    greenT1.setToggleGroup(groupColorsT1);
	    redT2.setToggleGroup(groupColorsT2);
	    yellowT2.setToggleGroup(groupColorsT2);
	    blueT2.setToggleGroup(groupColorsT2);
	    greenT2.setToggleGroup(groupColorsT2);
	    redT3.setToggleGroup(groupColorsT3);
	    yellowT3.setToggleGroup(groupColorsT3);
	    blueT3.setToggleGroup(groupColorsT3);
	    greenT3.setToggleGroup(groupColorsT3);
	    redT4.setToggleGroup(groupColorsT4);
	    yellowT4.setToggleGroup(groupColorsT4);
	    blueT4.setToggleGroup(groupColorsT4);
	    greenT4.setToggleGroup(groupColorsT4);
	    gameSelectionPane.add(redT1, 2, 1);
	    gameSelectionPane.add(blueT1, 3, 1);
	    gameSelectionPane.add(greenT1, 4, 1);
	    gameSelectionPane.add(yellowT1, 5, 1);
	    gameSelectionPane.add(redT2, 2, 2);
	    gameSelectionPane.add(blueT2, 3, 2);
	    gameSelectionPane.add(greenT2, 4, 2);
	    gameSelectionPane.add(yellowT2, 5, 2);
	    gameSelectionPane.add(redT3, 2, 3);
	    gameSelectionPane.add(blueT3, 3, 3);
	    gameSelectionPane.add(greenT3, 4, 3);
	    gameSelectionPane.add(yellowT3, 5, 3);
	    gameSelectionPane.add(redT4, 2, 4);
	    gameSelectionPane.add(blueT4, 3, 4);
	    gameSelectionPane.add(greenT4, 4, 4);
	    gameSelectionPane.add(yellowT4, 5, 4);
	    selectionTxt.setStyle("-fx-font: 38px Tahoma;");
	    selectionTxt.setFill(Color.RED);
	    gameSelectionPane.add(selectionTxt, 1, 5);
	    gameSelectionPane.add(startGame, 5, 5);

		creditPane.setStyle("-fx-background-color: #47a6c2");
		creditPane.setVgap(50);
		creditPane.setVgap(50);
		creditPane.setPadding(new Insets(50,50,50,50));
		creditPane.add(back2, 0, 0);
		Text creditTitle = new Text("An diesem Projekt beteiligt waren:");
		Text creditTolan = new Text("-  TOLAN CHRISTOPHER");
		Text creditHradil = new Text("-  HRADIL RAPHAEL");
		creditTitle.setStyle("-fx-font: 50px Tahoma; -fx-underline: true");
		creditTolan.setStyle("-fx-font: 30px Tahoma");
		creditHradil.setStyle("-fx-font: 30px Tahoma");
		creditPane.add(creditTitle, 0, 1);
		creditPane.add(creditTolan, 0, 2);
		creditPane.add(creditHradil, 0, 3);
		
	    
		startB.addEventHandler(ActionEvent.ACTION, event);
		back.addEventHandler(ActionEvent.ACTION, event);
		back2.addEventHandler(ActionEvent.ACTION, event);
		creditsB.addEventHandler(ActionEvent.ACTION, event);
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
	
	public Button getBack2() {
		return back2;
	}
	
	public Stage getMainStage() {
		return mainStage;
	}


	public BorderPane getRoot() {
		return root;
	}


	public GridPane getGameSelectionPane() {
		return gameSelectionPane;
	}


	public Scene getMainScene() {
		return mainScene;
	}


	public Scene getGameScene() {
		return gameScene;
	}

	public void setMainStage(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	public void setCreditsScene(){
		
	}
	
	public void setMainScene(){
		mainStage.setScene(mainScene);
	}
	
	public void setGameScene(){
		mainStage.setScene(gameScene);
	}


	public ActionListenerFX getEvent() {
		return event;
	}


	public List<String> getArgs() {
		return args;
	}


	public TextField getT1TF() {
		return t1TF;
	}


	public TextField getT2TF() {
		return t2TF;
	}


	public TextField getT3TF() {
		return t3TF;
	}


	public TextField getT4TF() {
		return t4TF;
	}


	public ToggleGroup getGroupColorsT1() {
		return groupColorsT1;
	}


	public ToggleGroup getGroupColorsT2() {
		return groupColorsT2;
	}


	public ToggleGroup getGroupColorsT3() {
		return groupColorsT3;
	}


	public ToggleGroup getGroupColorsT4() {
		return groupColorsT4;
	}


	public Text getSelectionTxt() {
		return selectionTxt;
	}


	public Button getStartGame() {
		return startGame;
	}


	public GridPane getCreditPane() {
		return creditPane;
	}


	public Scene getCreditScene() {
		return creditScene;
	}
	

	
}
