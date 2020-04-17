package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.Board;


public class PlayerStatusView extends GridPane {


    private Label player1, player2;
    private Label player1_status, player2_status;

    private Button replay;


    private Stage stage;

    public PlayerStatusView(Stage primaryStage, String player_1_name, String player_2_name, String player_1_status, String player_2_status) {


        this.stage = primaryStage;
        this.player1 = new Label(player_1_name);
        this.player2 = new Label(player_2_name);
        this.player1_status = new Label(player_1_status);
        this.player2_status = new Label(player_2_status);

        this.replay = new Button("replay");

        this.add(player1, 0, 0);
        this.add(player2, 0, 1);
        this.add(player1_status, 1, 0);
        this.add(player2_status, 1, 1);

        this.add(replay, 1, 2);
        //play again
        this.replay.setOnAction(event -> {
            Board gameBoard = new Board();
            gameBoard.setId("board");

            gameBoard.primary_stage = stage;
            gameBoard.player1 = player_1_name;
            gameBoard.player2 = player_2_name;
            BorderPane rootPane = new BorderPane();

            Pane root = new Pane();
            root.getChildren().add(gameBoard.root);

            Shape gridShape = gameBoard.generateBoard();

            root.getChildren().add(gridShape);

            root.getChildren().addAll(gameBoard.makeColumns());

            rootPane.getChildren().addAll(root);

            Scene scene = new Scene(rootPane, (gameBoard.columns + 1) * gameBoard.size, (gameBoard.rows + 1) * gameBoard.size);
            stage.setScene(scene);
            stage.setTitle("Main Game");
            stage.show();
            stage.setResizable(true);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        });
    }

    public Label getPlayer1() {
        return player1;
    }

    public Label getPlayer2() {
        return player2;
    }


    public void startStausView() {
        this.setId("LoginView");
        Scene scene = new Scene(this, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Four Connect");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }


}
