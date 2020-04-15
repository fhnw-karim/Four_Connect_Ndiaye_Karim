package main;

import javafx.stage.Stage;
import model.PlayerStatus;
import view.LoginView;
import view.MainGameView;

public class Controller {

    //Board

    //stages bzw. scenes
    private LoginView loginView;
    private MainGameView maingame_view;
    private Stage primaryStage;

    //players and playernames
    private PlayerStatus player1;
    private PlayerStatus player2;
    private LoginView name1;
    private LoginView name2;

    //array for
    public Controller(LoginView loginView, MainGameView maingame_view, Stage primaryStage, PlayerStatus player1, PlayerStatus player2){
        this.loginView = loginView;
        this.maingame_view = maingame_view;

        this.player1 = player1;
        this.player2 = player2;

        this.name1 = name1;
        this.name2 = name2;



        this.primaryStage = primaryStage;

        //functionality for button to start fc_view aka main game screen
        //when button is pressed, the whole game should be initialized with playernames and everything.
        this.loginView.getstartGameButton().setOnAction(event -> {
            this.maingame_view.setLeft(player1);
            this.maingame_view.setRight(player2);
            this.player1.getPlayerName().setText(loginView.getName1().getText());
            this.player2.getPlayerName().setText(loginView.getName2().getText());

            //launch game
            maingame_view.startGame();
        });



    }

}
