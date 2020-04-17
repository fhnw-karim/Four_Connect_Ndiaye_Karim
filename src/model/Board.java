package model;


import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.PlayerStatusView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board extends GridPane {


    private int rows;
    private int columns;
    public String player1,player2;

    public static final int TILE_SIZE = 80;
    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    public Pane discRoot = new Pane();
    public boolean redMove = true;
    public Disc[][] grid = new Disc[COLUMNS][ROWS];

    private ArrayList<Integer> vertical;
    private ArrayList<Integer> horizontal;
    public Stage primary_stage;

    GridPane board = new GridPane();

    public Board() {
        this.setId("board");

    }

    public javafx.scene.shape.Shape generateBoard() {
        javafx.scene.shape.Shape shape = new javafx.scene.shape.Rectangle((COLUMNS + 1) * TILE_SIZE, (ROWS + 1) * TILE_SIZE);

        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                Circle circle = new Circle(TILE_SIZE / 2);
                circle.setCenterX(TILE_SIZE / 2);
                circle.setCenterY(TILE_SIZE / 2);
                circle.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
                circle.setTranslateY(y * (TILE_SIZE + 5) + TILE_SIZE / 4);

                shape = javafx.scene.shape.Shape.subtract(shape, circle);
            }
        }

        Light.Distant light = new Light.Distant();
        light.setAzimuth(45.0);
        light.setElevation(30.0);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        shape.setFill(Color.WHITESMOKE);
        shape.setEffect(lighting);

        return shape;
    }

    public java.util.List<javafx.scene.shape.Rectangle> makeColumns() {
        List<Rectangle> list = new ArrayList<>();

        for (int x = 0; x < COLUMNS; x++) {
            javafx.scene.shape.Rectangle rect = new Rectangle(TILE_SIZE, (ROWS + 1) * TILE_SIZE);
            rect.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
            rect.setFill(Color.TRANSPARENT);

            rect.setOnMouseEntered(e -> rect.setFill(Color.rgb(200, 200, 50, 0.3)));
            rect.setOnMouseExited(e -> rect.setFill(Color.TRANSPARENT));

            final int column = x;
            rect.setOnMouseClicked(e -> validateMove(new Disc(redMove), column));

            list.add(rect);
        }

        return list;
    }
    public void validateMove(Disc disc, int column) {
        int row = ROWS - 1;
        do {
            if (!getDisc(column, row).isPresent())
                break;

            row--;
        } while (row >= 0);

        if (row < 0)
            return;

        grid[column][row] = disc;
        discRoot.getChildren().add(disc);
        disc.setTranslateX(column * (TILE_SIZE + 5) + TILE_SIZE / 4);

        final int currentRow = row;

        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.001), disc);
        animation.setToY(row * (TILE_SIZE + 5) + TILE_SIZE / 4);
        animation.setOnFinished(e -> {
            if (gameEnded(column, currentRow)) {
                gameOver();
            }

            redMove = !redMove;
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

            Disc disc = getDisc(column, row).orElse(new Disc(!redMove));
            if (disc.red == redMove) {
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

        if(redMove){
            PlayerStatusView playerStatusView= new PlayerStatusView(this.primary_stage,this.player1,this.player2,"Winner","Loser");
            playerStatusView.startStausView();
        }else{
            PlayerStatusView playerStatusView= new PlayerStatusView(this.primary_stage,this.player1,this.player2,"Loser","Winner");
            playerStatusView.startStausView();
        }

    }

    public Optional<Disc> getDisc(int column, int row) {
        if (column < 0 || column >= COLUMNS
                || row < 0 || row >= ROWS)
            return Optional.empty();

        return Optional.ofNullable(grid[column][row]);
    }


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


}


