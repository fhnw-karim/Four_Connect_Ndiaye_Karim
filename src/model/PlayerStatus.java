package model;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Player;

public class PlayerStatus extends HBox {

    private Label playerName;
    private Label isWinner;


    public PlayerStatus(){

        this.playerName = new Label("wasd");
        this.isWinner = new Label("insert name 1 or 2");
        this.getChildren().addAll(playerName, isWinner);

    }

    public Label getIsWinner() {
        return isWinner;
    }

    public Label getPlayerName() {
        return playerName;
    }
}
