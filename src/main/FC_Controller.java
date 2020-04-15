package main;

import javafx.stage.Stage;
import model.Board;
import view.FC_View;
import view.LoginView;
import model.PlayerStatus;

public class FC_Controller {

    //Board
    private Board board;

    //stages bzw. scenes
    private LoginView loginView;
    private FC_View fc_view;
    private Stage primaryStage;

    //players and playernames
    private PlayerStatus player1;
    private PlayerStatus player2;
    private LoginView name1;
    private LoginView name2;

    //array for
    public FC_Controller(LoginView loginView, FC_View fc_view, Stage primaryStage, PlayerStatus player1, PlayerStatus player2, Board board){
        this.loginView = loginView;
        this.fc_view = fc_view;

        this.player1 = player1;
        this.player2 = player2;

        this.name1 = name1;
        this.name2 = name2;

        this.board = board;

        this.primaryStage = primaryStage;

        //functionality for button to start fc_view aka main game screen
        //when button is pressed, the whole game should be initialized with playernames and everything.
        this.loginView.getstartGameButton().setOnAction(event -> {
            this.fc_view.setLeft(player1);
            this.fc_view.setRight(player2);
            this.player1.getPlayerName().setText(loginView.getName1().getText());
            this.player2.getPlayerName().setText(loginView.getName2().getText());

            //launch game
            fc_view.startGame();
        });

    }

}
