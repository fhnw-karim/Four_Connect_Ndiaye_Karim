package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import model.Board;


public class MainGameView extends BorderPane {

    private Stage stage;
    private BorderPane root;


    public MainGameView(Stage stage) {

        this.root = new BorderPane();
        this.stage = stage;

    }


    public void startGame(String player1, String player2) {

        Board gameBoard = new Board();
        gameBoard.setId("board");

        gameBoard.primary_stage = stage;
        gameBoard.player1 = player1;
        gameBoard.player2 = player2;
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
    }


}


/**
 * GridPane grid = new GridPane();
 * grid.setHgap(10);
 * grid.setVgap(10);
 * <p>
 * <p>
 * //gererate my circles, later they should be white and then turn yellow/red when clicked
 * //Put into Board or field class.. whatever fits!
 * int column = 0;
 * for (int i = 0; i < 7; i++) {
 * for (int j = 0; j < 6; j++) {
 * Circle c = new Circle(40);
 * grid.add(c, column, j);
 * c.setId("circleID");
 * }
 * column++;
 * }
 * <p>
 * <p>
 * }
 * <p>
 * <p>
 * public void stop(){
 * stage.hide();
 * }
 * <p>
 * <p>
 * public void startGame(){
 * Scene scene = new Scene(grid, 550, 640);
 * stage.setScene(scene);
 * stage.setResizable(false);
 * stage.setTitle("Four_Connect by Karim");
 * stage.show();
 */