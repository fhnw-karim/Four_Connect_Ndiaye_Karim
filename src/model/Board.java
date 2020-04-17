package model;


import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.PlayerStatusView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board extends GridPane {


    public static final int columns = 7;
    public static final int rows = 6;
    //makes circles bigger
    public static final int size = 100;
    public String player1, player2;
    public Pane root = new Pane();
    public boolean redWin = true;
    //2d array
    public Disc[][] grid = new Disc[columns][rows];




    /*useless
    private ArrayList<Integer> vertical;
    private ArrayList<Integer> horizontal;
    */

    public Stage primary_stage;

    //GridPane board = new GridPane();


    public Board() {

    }

    public Shape generateBoard() {

        Shape shape = new Rectangle((columns + 1) * size, (rows + 1) * size);
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                Circle circle = new Circle(size / 2);
                circle.setCenterX(size / 2);
                circle.setCenterY(size / 2);
                circle.setTranslateX(x * (size + 5) + size / 4);
                circle.setTranslateY(y * (size + 5) + size / 4);

                shape = Shape.subtract(shape, circle);
                shape.setFill(Color.rgb(20, 20, 200));
                shape.setSmooth(true);
            }
        }

        return shape;
    }

    public List<Rectangle> makeColumns() {

        List<Rectangle> list = new ArrayList<>();

        for (int x = 0; x < columns; x++) {
            //vertical lines basically
            Rectangle rect = new Rectangle(size, (rows + 1) * size);
            rect.setTranslateX(x * (size + 5) + size / 4);
            //transparent by default for the circles
            rect.setFill(Color.TRANSPARENT);


            final int column = x;
            rect.setOnMouseClicked(e -> validateMove(new Disc(redWin), column));

            list.add(rect);
        }

        return list;
    }

    public void validateMove(Disc disc, int column) {
        int row = rows - 1;
        do {
            if (!getDisc(column, row).isPresent())
                break;

            row--;
        } while (row >= 0);

        if (row < 0)
            return;

        grid[column][row] = disc;
        root.getChildren().add(disc);
        disc.setTranslateX(column * (size + 5) + size / 4);

        final int currentRow = row;

        //if animation is too fast, there will be multiple discs of same color....
        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.01), disc);
        animation.setToY(row * (size + 5) + size / 4);
        animation.setOnFinished(e -> {
            if (gameEnded(column, currentRow)) {
                gameOver();
            }

            redWin = !redWin;
        });
        animation.play();
    }

    public boolean gameEnded(int column, int row) {

        List<Point2D> vertical = IntStream.rangeClosed(row - 3, row + 3)
                .mapToObj(r -> new Point2D(column, r))
                .collect(Collectors.toList());

        List<Point2D> horizontal = IntStream.rangeClosed(column - 3, column + 3)
                .mapToObj(c -> new Point2D(c, row))
                .collect(Collectors.toList());

        Point2D topLeft = new Point2D(column - 3, row - 3);
        List<Point2D> diagonal1 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> topLeft.add(i, i))
                .collect(Collectors.toList());

        Point2D botLeft = new Point2D(column - 3, row + 3);
        List<Point2D> diagonal2 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> botLeft.add(i, -i))
                .collect(Collectors.toList());

        return checkRange(vertical) || checkRange(horizontal)
                || checkRange(diagonal1) || checkRange(diagonal2);
    }

    public boolean checkRange(List<Point2D> points) {
        int chain = 0;

        for (Point2D p : points) {
            int column = (int) p.getX();
            int row = (int) p.getY();

            Disc disc = getDisc(column, row).orElse(new Disc(!redWin));
            if (disc.win == redWin) {
                chain++;
                if (chain == 4) {
                    return true;
                }
            } else {
                chain = 0;
            }
        }

        return false;
    }

    public void gameOver() {


        if (redWin) {
            PlayerStatusView playerStatusView = new PlayerStatusView(this.primary_stage, this.player1, this.player2, "Is the Winner", "is the Loser");
            playerStatusView.startStausView();
        } else {
            PlayerStatusView playerStatusView = new PlayerStatusView(this.primary_stage, this.player1, this.player2, "Is the Loser", "is the Winner");
            playerStatusView.startStausView();
        }

    }

    public Optional<Disc> getDisc(int column, int row) {
        if (column < 0 || column >= columns
                || row < 0 || row >= rows)
            return Optional.empty();

        return Optional.ofNullable(grid[column][row]);
    }

    //circle for discs which will be placed
    public static class Disc extends Circle {
        private final boolean win;

        public Disc(boolean red) {
            super(size / 2, red ? Color.RED : Color.YELLOW);
            this.win = red;

            setCenterX(size / 2);
            setCenterY(size / 2);
        }
    }
}


//Not really good idea.. better use other method to generate
//    public void generateBoard(){
//        this.rows = 7;
//        this.columns = 6;
//        this.vertical = vertical;
//        this.horizontal = horizontal;
//        Board board = new Board();
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                Circle c = new Circle(40);
//                board.add(c, columns, j);
//                c.setId("circleID");
//            }
//            columns++;
//        }
//    }
//
//    public void validateMove(){
//
//    }





