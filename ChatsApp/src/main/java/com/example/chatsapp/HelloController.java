package com.example.chatsapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onOpenButtonClick() {
        welcomeText.setText("Opening the chat..");
    }
}