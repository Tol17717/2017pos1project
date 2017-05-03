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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {

		/*primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		Button btn = new Button();
		btn.setText("Starte Spiel");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Spiel wird gestartet");
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 1280, 720));
		primaryStage.show();*/
		
		 primaryStage.setTitle("Mensch Aergere Dich Nicht!");
		 GridPane grid = new GridPane();
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(35);
		 grid.setVgap(35);
		 grid.setPadding(new Insets(10, 10, 10, 10));
		 Text scenetitle = new Text("Mensch Aergere Dich Nicht");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
		 grid.add(scenetitle, 0, 0);
		 Button btn = new Button("Play");
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.CENTER);
		 hbBtn.getChildren().add(btn);
		 grid.add(hbBtn, 0, 1);
		 Button btn1 = new Button("Highscore");
		 HBox hbBtn1 = new HBox(10);
		 hbBtn.setAlignment(Pos.CENTER);
		 hbBtn.getChildren().add(btn1);
		 grid.add(hbBtn1, 0, 2);
		 Button btn2 = new Button("Credits");
		 HBox hbBtn2 = new HBox(10);
		 hbBtn.setAlignment(Pos.CENTER);
		 hbBtn.getChildren().add(btn2);
		 grid.add(hbBtn2, 0, 3);
		 Scene scene = new Scene(grid, 1280, 720);
		 primaryStage.setScene(scene);
	     primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
