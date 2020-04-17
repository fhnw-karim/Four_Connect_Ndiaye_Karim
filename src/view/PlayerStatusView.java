package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//Login Class. Should show a simple login screen where player1 & p2 enter their names.
public class PlayerStatusView extends GridPane {


    private Label player1, player2;
    private Label player1_status, player2_status;


    private Stage stage;

    public PlayerStatusView(Stage primaryStage, String player_1_name, String player_2_name, String player_1_status, String player_2_status) {

        this.stage = primaryStage;
        this.player1 = new Label(player_1_name);
        this.player2 = new Label(player_2_name);
        this.player1_status = new Label(player_1_status);
        this.player2_status = new Label(player_2_status);


        this.add(player1, 0, 0);
        this.add(player2, 0, 1);
        this.add(player1_status, 1, 0);
        this.add(player2_status, 1, 1);


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
