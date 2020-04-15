package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Board;


public class MainGameView extends BorderPane {


    private Stage stage;
    private BorderPane root;


    public MainGameView(Stage stage) {

        this.root = new BorderPane();
        this.stage = stage;

    }
    public void startGame() {
        this.setId("FC_View");
        Scene scene = new Scene(this, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Main Game");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
    }

}



/**

 GridPane grid = new GridPane();
 grid.setHgap(10);
 grid.setVgap(10);





 //gererate my circles, later they should be white and then turn yellow/red when clicked
 //Put into Board or field class.. whatever fits!
 int column = 0;
 for (int i = 0; i < 7; i++) {
 for (int j = 0; j < 6; j++) {
 Circle c = new Circle(40);
 grid.add(c, column, j);
 c.setId("circleID");
 }
 column++;
 }


 }


 public void stop(){
 stage.hide();
 }


 public void startGame(){
 Scene scene = new Scene(grid, 550, 640);
 stage.setScene(scene);
 stage.setResizable(false);
 stage.setTitle("Four_Connect by Karim");
 stage.show();

 */