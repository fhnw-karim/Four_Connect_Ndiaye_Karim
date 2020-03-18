package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class FC_Main extends Application {
    private FC_Model model;
    private FC_View view;
    private FC_Controller controller;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        model = new FC_Model();
        view = new FC_View(stage, model);
        controller = new FC_Controller(model, view);
        view.start();
    }

    @Override
    public void stop() {
        if (view != null) view.stop();
    }


}
