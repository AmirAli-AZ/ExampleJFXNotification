package com.amirali.examplejfxnotification;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;

        primaryStage.setTitle("ExampleJFXNotification");
        primaryStage.setScene(new Scene(createContent(), 600, 400));
        primaryStage.show();
    }

    private Parent createContent() {
        var showButton = new Button("Show");
        showButton.setPrefSize(75, 25);
        showButton.setOnAction(event -> {
            try {
                var notification = new Notification(
                        "Example custom notification",
                        "This example shows you how to create custom notification in javafx without using any library"
                );
                notification.show(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return new StackPane(showButton);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
