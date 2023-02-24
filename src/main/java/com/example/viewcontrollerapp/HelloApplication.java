package com.example.viewcontrollerapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    HelloController viewController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 441);
        viewController = fxmlLoader.getController();
        stage.setTitle("List Viewer");
        stage.setScene(scene);
        stage.show();
    }
    public void stop() throws Exception {
        viewController.saveData();
    }
    public static void main(String[] args) {
        launch();
    }
}