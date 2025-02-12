package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public LoginView(Stage primaryStage) {

        this.stage = primaryStage;

        this.player1 = new Label("Player one ");
        this.player2 = new Label("Player two ");

        this.name1 = new TextField("");
        this.name1.setId("nameField1");
        this.name2 = new TextField("");
        this.name1.setId("nameField2");

        this.startGameButton = new Button("Play");
        startGameButton.setId("Button");

        this.add(player1, 0, 0);
        this.add(player2, 0, 1);

        this.add(name1, 1, 0);
        this.add(name2, 1, 1);

        this.add(startGameButton, 0, 5);


    }


    public Button getstartGameButton() {
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

    public void startLogin() {
        this.setId("LoginView");
        Scene scene = new Scene(this, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Connect Four by Karim N'diaye");
        stage.show();
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

    }


}
