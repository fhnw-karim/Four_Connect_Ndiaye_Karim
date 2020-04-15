package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//Login Class. Should show a simple login screen where player1 & p2 enter their names.
public class LoginView extends GridPane {


    private Label player1, player2;
    private TextField name1, name2;

    private Button startGameButton;
    private Stage stage;

    public LoginView(Stage primaryStage){

        this.stage = primaryStage;
        this.player1 = new Label("Spieler 1: ");
        this.player2 = new Label("Spieler 2: ");
        this.name1 = new TextField("xy");
        this.name2 = new TextField("yz");

        this.startGameButton = new Button("Start the game allready!");

        this.add(player1, 0 ,1);
        this.add(player2, 0, 2);

        this.add(name1, 1, 0);
        this.add(name2, 1, 1);

        this.add(startGameButton, 3, 3);


    }



    //TODO ADD CSS, ADD BUTTON CONFIRM SETONACTION TO START FC_VIEw
    //getter for button which will launch FC view via controller class
    public Button getstartGameButton(){
        return startGameButton;
    }

    public Label getPlayer1() {
        return player1;
    }

    public Label getPlayer2() {
        return player2;
    }

    public TextField getName1() {
        return name1;
    }

    public TextField getName2() {
        return name2;
    }

    public void startLogin(){


        Scene scene = new Scene(this, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Four Connect");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

}



}
