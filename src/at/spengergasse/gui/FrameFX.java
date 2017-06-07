package at.spengergasse.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FrameFX extends Stage {
	// Buttons
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
	private final Button dice;
	private final Button skipRound;
	// Panes
	private final BorderPane root;
	private final GridPane gameSelectionPane;
	private final GridPane creditPane;
	private final GridPane highscorePane;
	private final GridPane gamePane;
	// Scenes
	private Scene mainScene;
	private Scene gameSelectionScene;
	private Scene creditScene;
	private Scene highscoreScene;
	private Scene gameScene;
	// Stages
	private Stage mainStage;
	// ActionListener, Parameters;
	private final ActionListenerFX event;
	// TextField
	private final TextField t1TF;
	private final TextField t2TF;
	private final TextField t3TF;
	private final TextField t4TF;
	// Toggle Groups
	private final ToggleGroup groupColorsT1;
	private final ToggleGroup groupColorsT2;
	private final ToggleGroup groupColorsT3;
	private final ToggleGroup groupColorsT4;
	// Text
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
	private final Text showT1name;
	private final Text showT2name;
	private final Text showT3name;
	private final Text showT4name;
	private final Text t1who;
	private final Text t2who;
	private final Text t3who;
	private final Text t4who;
	private final Text whosTurn;
	private final Text whatToDo;

	// ToggleButtons
	private final RadioButton[] tbarr;

	public FrameFX() {
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
		selectionErrTxt = new Text("");
		startGame = new Button("");
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
		mainStage.getIcons().add(new Image("at/spengergasse/img/titleicon.jpg"));
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(50, 50, 50, 50));
		Text title = new Text(" ");
		hbox.getChildren().add(title);
		root.setTop(hbox);
		mainScene = new Scene(root, 1280, 720);
		gameSelectionScene = new Scene(gameSelectionPane, 1280, 720);
		highscoreScene = new Scene(highscorePane, 1280, 720);
		creditScene = new Scene(creditPane, 1280, 720);
		gameScene = new Scene(gamePane, 1280, 720);
		root.setStyle(
				"-fx-background-image: url('at/spengergasse/img/title.jpg');-fx-background-size: auto;-fx-background-repeat: no-repeat;");
		mainStage.setScene(mainScene);
		mainStage.show();
		GridPane gridP = new GridPane();
		gridP.setVgap(50);
		gridP.setHgap(50);
		gridP.setPadding(new Insets(50, 50, 50, 50));
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
		gridP.add(start, 0, 0);
		gridP.add(highscore, 0, 1);
		gridP.add(credits, 0, 2);
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
		gameSelectionPane.setPadding(new Insets(50, 50, 50, 50));
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
		tbarr = new RadioButton[16];
		for (int i = 0; i < 16; i++) {
			tbarr[i] = new RadioButton("Red");
			i++;
			tbarr[i] = new RadioButton("Blue");
			i++;
			tbarr[i] = new RadioButton("Yellow");
			i++;
			tbarr[i] = new RadioButton("Green");
		}
		for (int i = 0; i < 16; i++) {
			if (i < 4) {
				tbarr[i].setToggleGroup(groupColorsT1);
			} else if (i < 8) {
				tbarr[i].setToggleGroup(groupColorsT2);
			} else if (i < 12) {
				tbarr[i].setToggleGroup(groupColorsT3);
			} else if (i < 16) {
				tbarr[i].setToggleGroup(groupColorsT4);
			}
		}
		int a = 2;
		int b = 1;
		for (int i = 0; i < 16; i++) {
			gameSelectionPane.add(tbarr[i], a, b);
			if (a == 5) {
				a = 2;
			} else {
				a++;
			}
			if (i == 3 || i == 7 || i == 11 || i == 15) {
				b++;
			}
		}
		startGame.setMinSize(100, 50);
		startGame.setStyle("-fx-background-image: url('at/spengergasse/img/start.png')");
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
		creditPane.setPadding(new Insets(50, 50, 50, 50));
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
		highscorePane.setPadding(new Insets(50, 50, 50, 50));
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
		gamePane.setPadding(new Insets(50, 50, 50, 50));
		BackgroundImage backgroundImageButtonUp = new BackgroundImage( new Image( getClass().getResource("/at/spengergasse/img/uparr.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundUp = new Background(backgroundImageButtonUp);
        BackgroundImage backgroundImageButtonDown = new BackgroundImage( new Image( getClass().getResource("/at/spengergasse/img/downarr.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundDown = new Background(backgroundImageButtonDown);
        BackgroundImage backgroundImageButtonLeft = new BackgroundImage( new Image( getClass().getResource("/at/spengergasse/img/leftarr.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundLeft = new Background(backgroundImageButtonLeft);
        BackgroundImage backgroundImageButtonRight = new BackgroundImage( new Image( getClass().getResource("/at/spengergasse/img/rightarr.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background backgroundRight = new Background(backgroundImageButtonRight);
		
		Button up = new Button();
		up.setBackground(backgroundUp);
		up.setMinSize(64, 150);
		Button down = new Button();
		down.setBackground(backgroundDown);
		down.setMinSize(64, 150);
		Button left = new Button();
		left.setBackground(backgroundLeft);
		left.setMinSize(150, 64);
		Button right = new Button();
		right.setBackground(backgroundRight);
		right.setMinSize(150, 64);
		gamePane.add(right, 0, 3, 3, 2);
		gamePane.add(left, 8, 7, 3, 2);
		gamePane.add(down, 7, 0, 2, 3);
		gamePane.add(up, 3, 8, 2, 3);
		for (int i = 0; i < 40; i++) {
			gameField[i] = new Button("O");
			gameField[i].setShape(new Circle(1.5));
			gameField[i].setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));

		}
		for (int i = 0; i < 4; i++) {
			t1s[i] = new Button("O");
			t1s[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t2s[i] = new Button("O");
			t2s[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t3s[i] = new Button("O");
			t3s[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t4s[i] = new Button("O");
			t4s[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t1w[i] = new Button("O");
			t1w[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t2w[i] = new Button("O");
			t2w[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t3w[i] = new Button("O");
			t3w[i].setShape(new Circle(1.5));

		}
		for (int i = 0; i < 4; i++) {
			t4w[i] = new Button("O");
			t4w[i].setShape(new Circle(1.5));

		}
		gamePane.add(t1s[0], 0, 0);
		gamePane.add(t1s[1], 1, 0);
		gamePane.add(t1s[2], 0, 1);
		gamePane.add(t1s[3], 1, 1);

		gamePane.add(t2s[0], 9, 0);
		gamePane.add(t2s[1], 10, 0);
		gamePane.add(t2s[2], 9, 1);
		gamePane.add(t2s[3], 10, 1);

		gamePane.add(t4s[0], 0, 9);
		gamePane.add(t4s[1], 1, 9);
		gamePane.add(t4s[2], 0, 10);
		gamePane.add(t4s[3], 1, 10);

		gamePane.add(t3s[0], 9, 9);
		gamePane.add(t3s[1], 10, 9);
		gamePane.add(t3s[2], 9, 10);
		gamePane.add(t3s[3], 10, 10);

		gamePane.add(t1w[0], 1, 5);
		gamePane.add(t1w[1], 2, 5);
		gamePane.add(t1w[2], 3, 5);
		gamePane.add(t1w[3], 4, 5);

		gamePane.add(t2w[0], 5, 1);
		gamePane.add(t2w[1], 5, 2);
		gamePane.add(t2w[2], 5, 3);
		gamePane.add(t2w[3], 5, 4);

		gamePane.add(t4w[0], 5, 9);
		gamePane.add(t4w[1], 5, 8);
		gamePane.add(t4w[2], 5, 7);
		gamePane.add(t4w[3], 5, 6);

		gamePane.add(t3w[0], 9, 5);
		gamePane.add(t3w[1], 8, 5);
		gamePane.add(t3w[2], 7, 5);
		gamePane.add(t3w[3], 6, 5);

		int x = -1;
		int y = 4;
		for (int i = 0; i < 40; i++) {
			if (i < 5) {
				x++;
			} else if (i < 9) {
				y--;
			} else if (i < 11) {
				x++;
			} else if (i < 15) {
				y++;
			} else if (i < 19) {
				x++;
			} else if (i < 21) {
				y++;
			} else if (i < 25) {
				x--;
			} else if (i < 29) {
				y++;
			} else if (i < 31) {
				x--;
			} else if (i < 35) {
				y--;
			} else if (i < 39) {
				x--;
			} else if (i == 39) {
				y--;
			}
			gamePane.add(gameField[i], x, y);
		}
		
		showT1name = new Text("");
		showT2name = new Text("");
		showT3name = new Text("");
		showT4name = new Text("");
		t1who = new Text("Team 1:");
		t2who = new Text("Team 2:");
		t3who = new Text("Team 3:");
		t4who = new Text("Team 4:");
		gamePane.add(t1who, 11, 0);
		gamePane.add(t2who, 11, 1);
		gamePane.add(t3who, 11, 2);
		gamePane.add(t4who, 11, 3);
		gamePane.add(showT1name, 12, 0, 2, 1);
		gamePane.add(showT2name, 12, 1, 2, 1);
		gamePane.add(showT3name, 12, 2, 2, 1);
		gamePane.add(showT4name, 12, 3, 2, 1);
		whosTurn = new Text("Team 1 turn");
		whosTurn.setStyle("-fx-font: 20px Tahoma");
		gamePane.add(whosTurn, 14, 4);
		whatToDo = new Text("3 rolls available");
		whatToDo.setStyle("-fx-font: 20px Tahoma");
		gamePane.add(whatToDo, 14, 5);
		dice = new Button("");
		dice.setMinWidth(170);
		dice.setMinHeight(170);
		dice.setStyle("-fx-background-image: url('at/spengergasse/img/wuerfel6.jpg')");
		gamePane.add(dice, 13, 4, 1, 3);
		skipRound = new Button("Skip Turn");
		skipRound.setStyle("-fx-font: 20px Tahoma");
		skipRound.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		gamePane.add(skipRound, 14, 6);
		

		for (int i = 0; i < 40; i++) {
			gameField[i].addEventHandler(ActionEvent.ACTION, event);
		}
		for (int i = 0; i < 4; i++) {
			t1s[i].addEventHandler(ActionEvent.ACTION, event);
			t2s[i].addEventHandler(ActionEvent.ACTION, event);
			t3s[i].addEventHandler(ActionEvent.ACTION, event);
			t4s[i].addEventHandler(ActionEvent.ACTION, event);
			t1w[i].addEventHandler(ActionEvent.ACTION, event);
			t2w[i].addEventHandler(ActionEvent.ACTION, event);
			t3w[i].addEventHandler(ActionEvent.ACTION, event);
			t4w[i].addEventHandler(ActionEvent.ACTION, event);
		}
		startGame.addEventHandler(ActionEvent.ACTION, event);
		startB.addEventHandler(ActionEvent.ACTION, event);
		back.addEventHandler(ActionEvent.ACTION, event);
		back2.addEventHandler(ActionEvent.ACTION, event);
		back3.addEventHandler(ActionEvent.ACTION, event);
		creditsB.addEventHandler(ActionEvent.ACTION, event);
		highscoreB.addEventHandler(ActionEvent.ACTION, event);
		dice.addEventHandler(ActionEvent.ACTION, event);
		skipRound.addEventHandler(ActionEvent.ACTION, event);
	}

	public void changeGameField(int id, Color teamColor, boolean makeNull) {
		if (makeNull) {
			if (id == 0 || id == 10 || id == 20 || id == 30) {
				gameField[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				gameField[id].setTextFill(teamColor);
			} else {
				gameField[id].setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
				gameField[id].setTextFill(Color.BEIGE);
			}
		} else {
			gameField[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
			if (teamColor.equals(Color.BLUE)) {
				gameField[id].setTextFill(Color.WHITE);
			} else {
				gameField[id].setTextFill(Color.BLACK);
			}
		}
	}

	public void changeStartField(int id, int team, Color teamColor, Color teamBgColor, boolean makeNull) {
		if (makeNull) {
			if (team == 1) {
				t1s[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t1s[id].setTextFill(teamBgColor);
			} else if (team == 2) {
				t2s[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t2s[id].setTextFill(teamBgColor);
			} else if (team == 3) {
				t3s[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t3s[id].setTextFill(teamBgColor);
			} else if (team == 4) {
				t4s[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t4s[id].setTextFill(teamBgColor);
			}
		} else {
			if (team == 1) {
				t1s[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t1s[id].setTextFill(Color.WHITE);
				} else {
					t1s[id].setTextFill(Color.BLACK);
				}
			} else if (team == 2) {
				t2s[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t2s[id].setTextFill(Color.WHITE);
				} else {
					t2s[id].setTextFill(Color.BLACK);
				}
			} else if (team == 3) {
				t3s[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t3s[id].setTextFill(Color.WHITE);
				} else {
					t3s[id].setTextFill(Color.BLACK);
				}
			} else if (team == 4) {
				t4s[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t4s[id].setTextFill(Color.WHITE);
				} else {
					t4s[id].setTextFill(Color.BLACK);
				}
			}
		}
	}

	public void changeWinField(int id, int team, Color teamColor, Color teamBgColor, boolean makeNull) {
		if (makeNull) {
			if (team == 1) {
				t1w[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t1w[id].setTextFill(teamBgColor);
			} else if (team == 2) {
				t2w[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t2w[id].setTextFill(teamBgColor);
			} else if (team == 3) {
				t3w[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t3w[id].setTextFill(teamBgColor);
			} else if (team == 4) {
				t4w[id].setBackground(new Background(new BackgroundFill(teamBgColor, null, null)));
				t4w[id].setTextFill(teamBgColor);
			}
		} else {
			if (team == 1) {
				t1w[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t1w[id].setTextFill(Color.WHITE);
				} else {
					t1w[id].setTextFill(Color.BLACK);
				}
			} else if (team == 2) {
				t2w[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t2w[id].setTextFill(Color.WHITE);
				} else {
					t2w[id].setTextFill(Color.BLACK);
				}
			} else if (team == 3) {
				t3w[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t3w[id].setTextFill(Color.WHITE);
				} else {
					t3w[id].setTextFill(Color.BLACK);
				}
			} else if (team == 4) {
				t4w[id].setBackground(new Background(new BackgroundFill(teamColor, null, null)));
				if (teamColor.equals(Color.BLUE)) {
					t4w[id].setTextFill(Color.WHITE);
				} else {
					t4w[id].setTextFill(Color.BLACK);
				}
			}
		}
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

	public void setCreditsScene() {

	}

	public void setMainScene() {
		mainStage.setScene(mainScene);
	}

	public void setGameScene() {
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

	public RadioButton[] getTbarr() {
		return tbarr;
	}

	public Text getShowT1name() {
		return showT1name;
	}

	public Text getShowT2name() {
		return showT2name;
	}

	public Text getShowT3name() {
		return showT3name;
	}

	public Text getShowT4name() {
		return showT4name;
	}

	public Text getT1who() {
		return t1who;
	}

	public Text getT2who() {
		return t2who;
	}

	public Text getT3who() {
		return t3who;
	}

	public Text getT4who() {
		return t4who;
	}

	public Button getDice() {
		return dice;
	}

	public Text getWhosTurn() {
		return whosTurn;
	}

	public Text getWhatToDo() {
		return whatToDo;
	}

	public Button getSkipRound() {
		return skipRound;
	}

}
