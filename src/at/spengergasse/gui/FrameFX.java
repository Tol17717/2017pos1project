package at.spengergasse.gui;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FrameFX extends Stage {
	//Buttons
	private final Button startB;
	private final Button highscoreB;
	private final Button creditsB;
	private final Button back;
	private final Button back2;
	private final Button back3;
	private final Button startGame;
	private final Button[] gameField;
	private final Button[] t1s;
	private final Button[] t2s;
	private final Button[] t3s;
	private final Button[] t4s;
	private final Button[] t1w;
	private final Button[] t2w;
	private final Button[] t3w;
	private final Button[] t4w;
	//Panes
	private final BorderPane root;
	private final GridPane gameSelectionPane;
	private final GridPane creditPane;
	private final GridPane highscorePane;
	private final GridPane gamePane;
	//Scenes
	private Scene mainScene;
	private Scene gameSelectionScene;
	private Scene creditScene;
	private Scene highscoreScene;
	private Scene gameScene;
	//Stages
	private Stage mainStage;
	//ActionListener, Parameters;
	private final ActionListenerFX event;
	//TextField
	private final TextField t1TF;
	private final TextField t2TF;
	private final TextField t3TF;
	private final TextField t4TF;
	//Toggle Groups
	private final ToggleGroup groupColorsT1;
	private final ToggleGroup groupColorsT2;
	private final ToggleGroup groupColorsT3;
	private final ToggleGroup groupColorsT4;
	//Text
	private final Text selectionErrTxt;
	private final Text highscore1name;
	private final Text highscore2name;
	private final Text highscore3name;
	private final Text highscore4name;
	private final Text highscore5name;
	private final Text highscore1points;
	private final Text highscore2points;
	private final Text highscore3points;
	private final Text highscore4points;
	private final Text highscore5points;
	
	public FrameFX(){
		startB = new Button(" ");
		highscoreB = new Button(" ");
		creditsB = new Button(" ");
		root = new BorderPane();
		gameSelectionPane = new GridPane();
		creditPane = new GridPane();
		gamePane = new GridPane();
		back = new Button("");
		back2 = new Button("");
		back3 = new Button("");
		mainStage = new Stage();
		event = new ActionListenerFX(this);
		t1TF = new TextField();
		t2TF = new TextField();
		t3TF = new TextField();
		t4TF = new TextField();
		groupColorsT1 = new ToggleGroup(); 
		groupColorsT2 = new ToggleGroup(); 
		groupColorsT3 = new ToggleGroup(); 
		groupColorsT4 = new ToggleGroup(); 
		selectionErrTxt = new Text("ERROR MESSAGE TEST");
		startGame = new Button("Start Game");
		highscorePane = new GridPane();
		highscore1name = new Text("");
		highscore2name = new Text("");
		highscore3name = new Text("");
		highscore4name = new Text("");
		highscore5name = new Text("");
		highscore1points = new Text("");
		highscore2points = new Text("");
		highscore3points = new Text("");
		highscore4points = new Text("");
		highscore5points = new Text("");
		gameField = new Button[40];
		t1s = new Button[4];
		t2s = new Button[4];
		t3s = new Button[4];
		t4s = new Button[4];
		t1w = new Button[4];
		t2w = new Button[4];
		t3w = new Button[4];
		t4w = new Button[4];
		
		mainStage.setTitle("Mensch Aergere Dich Nicht!");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50,50,50,50));
		Text title = new Text(" ");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		mainScene = new Scene(root, 1280, 720);
		gameSelectionScene = new Scene(gameSelectionPane, 1280, 720);
		highscoreScene = new Scene(highscorePane, 1280, 720);
		creditScene = new Scene(creditPane, 1280, 720);
		gameScene = new Scene(gamePane, 1280, 720);
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
		
		back.setMinHeight(50);
		back.setMinWidth(100);
		back.setStyle("-fx-background-image: url('at/spengergasse/img/back.png')");
		Text selectionText = new Text("Please select your teams");
		selectionText.setFill(Color.WHITE);
		selectionText.setStyle("-fx-font: 50px Tahoma");
		Text pickColorText = new Text("Pick your colors");
		pickColorText.setFill(Color.WHITE);
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
	    selectionErrTxt.setStyle("-fx-font: 30px Tahoma;");
	    selectionErrTxt.setFill(Color.RED);
	    gameSelectionPane.add(selectionErrTxt, 1, 5);
	    gameSelectionPane.add(startGame, 5, 5);

	    back2.setMinHeight(50);
		back2.setMinWidth(100);
		back2.setStyle("-fx-background-image: url('at/spengergasse/img/back.png')");
		creditPane.setStyle("-fx-background-color: #47a6c2");
		creditPane.setVgap(50);
		creditPane.setHgap(50);
		creditPane.setPadding(new Insets(50,50,50,50));
		creditPane.add(back2, 0, 0);
		Text creditTitle = new Text("An diesem Projekt beteiligt waren:");
		creditTitle.setFill(Color.WHITE);
		Text creditTolan = new Text("-  TOLAN CHRISTOPHER");
		creditTolan.setFill(Color.WHITE);
		Text creditHradil = new Text("-  HRADIL RAPHAEL");
		creditHradil.setFill(Color.WHITE);
		creditTitle.setStyle("-fx-font: 50px Tahoma; -fx-underline: true");
		creditTolan.setStyle("-fx-font: 30px Tahoma");
		creditHradil.setStyle("-fx-font: 30px Tahoma");
		creditPane.add(creditTitle, 0, 1);
		creditPane.add(creditTolan, 0, 2);
		creditPane.add(creditHradil, 0, 3);
		
		back3.setMinHeight(50);
		back3.setMinWidth(100);
		back3.setStyle("-fx-background-image: url('at/spengergasse/img/back.png')");
		highscorePane.setStyle("-fx-background-color: #47a6c2");
		highscorePane.setVgap(50);
		highscorePane.setHgap(50);
		highscorePane.setPadding(new Insets(50,50,50,50));
		highscorePane.add(back3, 0, 0);
		Text highscoreTitle = new Text("Highscores");
		highscoreTitle.setStyle("-fx-font: 45px Tahoma; -fx-underline: true");
		highscoreTitle.setFill(Color.WHITE);
		highscorePane.add(highscoreTitle, 2, 0, 3, 1);
		Text highscorePlace = new Text("Place");
		Text highscoreName = new Text("Name            				    ");
		Text highscoreScore = new Text("Points");
		highscorePlace.setStyle("-fx-font: 30px Tahoma; -fx-underline: true");
		highscoreName.setStyle("-fx-font: 30px Tahoma; -fx-underline: true");
		highscoreScore.setStyle("-fx-font: 30px Tahoma; -fx-underline: true");
		highscorePlace.setFill(Color.WHITE);
		highscoreName.setFill(Color.WHITE);
		highscoreScore.setFill(Color.WHITE);
		highscorePane.add(highscorePlace, 2, 1);
		highscorePane.add(highscoreName, 3, 1);
		highscorePane.add(highscoreScore, 4, 1);
		Text place1 = new Text("1st:");
		place1.setStyle("-fx-font: 35px Tahoma");
		place1.setFill(Color.GOLD);
		Text place2 = new Text("2nd:");
		place2.setStyle("-fx-font: 30px Tahoma");
		place2.setFill(Color.SILVER);
		Text place3 = new Text("3rd:");
		place3.setStyle("-fx-font: 25px Tahoma");
		place3.setFill(Color.valueOf("a57164"));
		Text place4 = new Text("4th:");
		place4.setStyle("-fx-font: 20px Tahoma");
		place4.setFill(Color.WHITE);
		Text place5 = new Text("5th:");
		place5.setStyle("-fx-font: 20px Tahoma");
		place5.setFill(Color.WHITE);
		highscorePane.add(place1, 2, 2);
		highscorePane.add(place2, 2, 3);
		highscorePane.add(place3, 2, 4);
		highscorePane.add(place4, 2, 5);
		highscorePane.add(place5, 2, 6);
		highscore1name.setStyle("-fx-font: 35px Tahoma");
		highscore1name.setFill(Color.GOLD);
		highscore1points.setStyle("-fx-font: 35px Tahoma");
		highscore1points.setFill(Color.GOLD);
		highscore2name.setStyle("-fx-font: 30px Tahoma");
		highscore2name.setFill(Color.SILVER);
		highscore2points.setStyle("-fx-font: 30px Tahoma");
		highscore2points.setFill(Color.SILVER);
		highscore3name.setStyle("-fx-font: 25px Tahoma");
		highscore3name.setFill(Color.valueOf("a57164"));
		highscore3points.setStyle("-fx-font: 25px Tahoma");
		highscore3points.setFill(Color.valueOf("a57164"));
		highscore4name.setStyle("-fx-font: 20px Tahoma");
		highscore4name.setFill(Color.WHITE);
		highscore4points.setStyle("-fx-font: 20px Tahoma");
		highscore4points.setFill(Color.WHITE);
		highscore5name.setStyle("-fx-font: 20px Tahoma");
		highscore5name.setFill(Color.WHITE);
		highscore5points.setStyle("-fx-font: 20px Tahoma");
		highscore5points.setFill(Color.WHITE);
		highscorePane.add(highscore1name, 3, 2);
		highscorePane.add(highscore2name, 3, 3);
		highscorePane.add(highscore3name, 3, 4);
		highscorePane.add(highscore4name, 3, 5);
		highscorePane.add(highscore5name, 3, 6);
		highscorePane.add(highscore1points, 4, 2);
		highscorePane.add(highscore2points, 4, 3);
		highscorePane.add(highscore3points, 4, 4);
		highscorePane.add(highscore4points, 4, 5);
		highscorePane.add(highscore5points, 4, 6);
		
		gamePane.setStyle("-fx-background-color: #47a6c2");
		gamePane.setVgap(25);
		gamePane.setHgap(25);
		gamePane.setPadding(new Insets(50,50,50,50));
		for(int i = 0; i < 40; i++){
			gameField[i] = new Button("  ");
			gameField[i].setShape(new Circle(1.5));
			gameField[i].setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t1s[i] = new Button("  ");
			t1s[i].setShape(new Circle(1.5));
			t1s[i].setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t2s[i] = new Button("  ");
			t2s[i].setShape(new Circle(1.5));
			t2s[i].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t3s[i] = new Button("  ");
			t3s[i].setShape(new Circle(1.5));
			t3s[i].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t4s[i] = new Button("  ");
			t4s[i].setShape(new Circle(1.5));
			t4s[i].setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t1w[i] = new Button("  ");
			t1w[i].setShape(new Circle(1.5));
			t1w[i].setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t2w[i] = new Button("  ");
			t2w[i].setShape(new Circle(1.5));
			t2w[i].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t3w[i] = new Button("  ");
			t3w[i].setShape(new Circle(1.5));
			t3w[i].setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		}
		for(int i = 0; i < 4; i++){
			t4w[i] = new Button("  ");
			t4w[i].setShape(new Circle(1.5));
			t4w[i].setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		}
		gamePane.add(t1s[0], 0, 0);
		gamePane.add(t1s[1], 1, 0);
		gamePane.add(t1s[2], 0, 1);
		gamePane.add(t1s[3], 1, 1);
		
		gamePane.add(t2s[0], 9, 0);
		gamePane.add(t2s[1], 10, 0);
		gamePane.add(t2s[2], 9, 1);
		gamePane.add(t2s[3], 10, 1);
		
		gamePane.add(t3s[0], 0, 9);
		gamePane.add(t3s[1], 1, 9);
		gamePane.add(t3s[2], 0, 10);
		gamePane.add(t3s[3], 1, 10);
		
		gamePane.add(t4s[0], 9, 9);
		gamePane.add(t4s[1], 10, 9);
		gamePane.add(t4s[2], 9, 10);
		gamePane.add(t4s[3], 10, 10);
		
		gamePane.add(t1w[0], 1, 5);
		gamePane.add(t1w[1], 2, 5);
		gamePane.add(t1w[2], 3, 5);
		gamePane.add(t1w[3], 4, 5);
		
		gamePane.add(t2w[0], 5, 1);
		gamePane.add(t2w[1], 5, 2);
		gamePane.add(t2w[2], 5, 3);
		gamePane.add(t2w[3], 5, 4);
		
		gamePane.add(t3w[0], 5, 6);
		gamePane.add(t3w[1], 5, 7);
		gamePane.add(t3w[2], 5, 8);
		gamePane.add(t3w[3], 5, 9);
		
		gamePane.add(t4w[0], 6, 5);
		gamePane.add(t4w[1], 7, 5);
		gamePane.add(t4w[2], 8, 5);
		gamePane.add(t4w[3], 9, 5);
		
		int x = -1;
		int y = 4;
		for(int i = 0; i < 40; i++){
			if(i < 5){
				x++;
			} else if(i < 9){
				y--;
			} else if(i < 11){
				x++;
			} else if(i < 15){
				y++;
			} else if(i < 19){
				x++;
			} else if(i < 21){
				y++;
			} else if(i < 25){
				x--;
			} else if(i < 29){
				y++;
			} else if(i < 31){
				x--;
			} else if(i < 35){
				y--;
			} else if(i < 39){
				x--;
			} else if(i == 39){
				y--;
			}
			gamePane.add(gameField[i], x, y);	
		}
		
		for(int i = 0; i < 40; i++){
			gameField[i].addEventHandler(ActionEvent.ACTION, event);
		}
	    startGame.addEventHandler(ActionEvent.ACTION, event);
		startB.addEventHandler(ActionEvent.ACTION, event);
		back.addEventHandler(ActionEvent.ACTION, event);
		back2.addEventHandler(ActionEvent.ACTION, event);
		back3.addEventHandler(ActionEvent.ACTION, event);
		creditsB.addEventHandler(ActionEvent.ACTION, event);
		highscoreB.addEventHandler(ActionEvent.ACTION, event);
	}
	
	
	
	public Button[] getGameField() {
		return gameField;
	}



	public GridPane getGamePane() {
		return gamePane;
	}



	public Scene getGameScene() {
		return gameScene;
	}



	public Button[] getT1s() {
		return t1s;
	}



	public Button[] getT2s() {
		return t2s;
	}



	public Button[] getT3s() {
		return t3s;
	}



	public Button[] getT4s() {
		return t4s;
	}



	public Button[] getT1w() {
		return t1w;
	}



	public Button[] getT2w() {
		return t2w;
	}



	public Button[] getT3w() {
		return t3w;
	}



	public Button[] getT4w() {
		return t4w;
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


	public Scene getGameSelectionScene() {
		return gameSelectionScene;
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
		mainStage.setScene(gameSelectionScene);
	}


	public ActionListenerFX getEvent() {
		return event;
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


	public Text getSelectionErrTxt() {
		return selectionErrTxt;
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


	public Button getBack3() {
		return back3;
	}


	public GridPane getHighscorePane() {
		return highscorePane;
	}


	public Scene getHighscoreScene() {
		return highscoreScene;
	}


	public Text getHighscore1name() {
		return highscore1name;
	}


	public Text getHighscore2name() {
		return highscore2name;
	}


	public Text getHighscore3name() {
		return highscore3name;
	}


	public Text getHighscore4name() {
		return highscore4name;
	}


	public Text getHighscore5name() {
		return highscore5name;
	}


	public Text getHighscore1points() {
		return highscore1points;
	}


	public Text getHighscore2points() {
		return highscore2points;
	}


	public Text getHighscore3points() {
		return highscore3points;
	}


	public Text getHighscore4points() {
		return highscore4points;
	}


	public Text getHighscore5points() {
		return highscore5points;
	}
	

	
}
