package model;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        this.setId("board");

    }
    public void generateBoard(){
        this.rows = 7;
        this.columns = 6;
        this.vertical = vertical;
        this.horizontal = horizontal;
        Board board = new Board();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Circle c = new Circle(40);
                board.add(c, columns, j);
                c.setId("circleID");
            }
            columns++;
        }
    }

    public void validateMove(){

    }


}


