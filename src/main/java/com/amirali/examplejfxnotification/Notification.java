package com.amirali.examplejfxnotification;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Notification extends Popup {

    @FXML
    private AnchorPane root;

    @FXML
    private Label title;

    @FXML
    private Label message;

    private int screenPadding = 0;

    public Notification(String title, String message) throws IOException {
        var loader = new FXMLLoader(getClass().getResource("notification-view.fxml"));
        loader.setController(this);
        loader.load();

        this.title.setText(title);
        this.message.setText(message);

        getContent().add(root);
        setAutoHide(true);
        addEventHandler(WindowEvent.WINDOW_SHOWN, windowEvent -> setPosition());
    }

    public Notification() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("notification-view.fxml"));
        loader.setController(this);
        loader.load();

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
