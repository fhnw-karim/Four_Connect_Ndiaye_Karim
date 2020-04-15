package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.Board;
import view.FC_View;
import view.LoginView;
import view.PlayerStatus;


public class FC_Main extends Application {




    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginView start = new LoginView(primaryStage);
        FC_View game = new FC_View(primaryStage);
        PlayerStatus player1 = new PlayerStatus();
        PlayerStatus player2 = new PlayerStatus();

        FC_Controller controller = new FC_Controller(start, game, primaryStage, player1, player2);

        //start login screen then if button pressed start mainGame (fc_view)
        start.startLogin();
    }
}
