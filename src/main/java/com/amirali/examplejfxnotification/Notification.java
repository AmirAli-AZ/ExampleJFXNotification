package com.amirali.examplejfxnotification;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Notification extends Popup {

    @FXML
    private VBox root;

    @FXML
    private Label title;

    @FXML
    private Label message;

    @FXML
    private Button close;

    private int screenPadding = 0;

    public Notification(String title, String message) throws IOException {
        setup(title, message);
    }

    public Notification() throws IOException {
        setup(null, null);
    }

    private void setup(String title, String message) throws IOException {
        var loader = new FXMLLoader(getClass().getResource("notification-view.fxml"));
        loader.setController(this);
        loader.load();

        if (title != null)
            this.title.setText(title);
        if (message != null)
            this.message.setText(message);
        close.setOnAction(event -> {
            if (isShowing())
                hide();
        });

        getContent().add(root);
        setAutoHide(true);
        addEventHandler(WindowEvent.WINDOW_SHOWN, windowEvent -> setPosition());
    }

    private void setPosition() {
        // setting the position to the lower right corner

        var visualBounds = Screen.getPrimary().getVisualBounds();
        setX(visualBounds.getMinX() + (visualBounds.getWidth() - getWidth()) - screenPadding);
        setY(visualBounds.getMinY() + (visualBounds.getHeight() - getHeight()) - screenPadding);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public String getTitle() {
        return title.getText();
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public String getMessage() {
        return message.getText();
    }

    public void setScreenPadding(int screenPadding) {
        this.screenPadding = screenPadding;
    }

    public int getScreenPadding() {
        return screenPadding;
    }
}
