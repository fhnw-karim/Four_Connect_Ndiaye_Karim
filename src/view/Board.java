package view;


import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Board extends GridPane {

    private int rows;
    private int columns;
    private ArrayList<Integer> vertical;
    private ArrayList<Integer> horizontal;
    GridPane board = new GridPane();


    public Board() {
        this.rows = 7;
        this.columns = 6;
        this.vertical = new ArrayList<>();
        this.horizontal = new ArrayList<>();
    }

    public void generateBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; columns < 6; j++) {
                Circle c = new Circle(40);
                board.add(c, columns, j);
                c.setId("circleID");
            }
            columns++;
        }
    }
}


