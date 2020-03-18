package main;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class FC_View {
    final private FC_Model model;
    final private Stage stage;


    protected FC_View(Stage stage, FC_Model model) {
        this.stage = stage;
        this.model = model;
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();


       /** for (int i = 0; i < 7 ; i++) {
        Button b = new Button("x");
        b.setPrefSize(50, 50);
        grid.add(b, 0, i);
        }*/

       //gererate my circles, later they should be white and then turn yellow/red when clicked
        int colum = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Circle c = new Circle(40);
                grid.add(c, colum, j);
                c.setId("circleID");
            }
            colum++;
        }



        root.setCenter(grid);
        Scene scene = new Scene(root, 500, 600);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setTitle("Four_Connect by Karim");

    }


    public void start() {
        stage.show();
    }

    public void stop() {
        stage.hide();
    }
}
