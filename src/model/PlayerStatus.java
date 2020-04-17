package model;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerStatus extends VBox {

    private Label playerName;
    private Label isWinner;


    public PlayerStatus() {

        this.playerName = new Label("");
        this.isWinner = new Label("");
        this.getChildren().addAll(playerName, isWinner);

    }

    public Label getIsWinner() {
        return isWinner;
    }

    public Label getPlayerName() {
        return playerName;
    }
}
