package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainGameView;
import view.LoginView;
import model.PlayerStatus;


public class Main extends Application {




    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginView start = new LoginView(primaryStage);
        MainGameView game = new MainGameView(primaryStage);

        PlayerStatus player1 = new PlayerStatus();
        PlayerStatus player2 = new PlayerStatus();


        Controller controller = new Controller(start, game, primaryStage, player1, player2);

        //start login screen then if button pressed start mainGame (fc_view)
        start.startLogin();
    }
}
