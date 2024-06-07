package com.example.chatsapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class ServerApplication extends Application {
    @Override
    public void start(Stage mainStage) throws IOException {
        SceneController sceneController = new SceneController(mainStage);

        FXMLLoader fxmlLoader = new FXMLLoader(ServerApplication.class.getResource("chatsApp_s2.fxml"));
        fxmlLoader.setController(new ServerChatController());

        ServerChatController controller2 = fxmlLoader.getController();
        controller2.setSceneController(sceneController);

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        mainStage.setTitle("Chats App");
        mainStage.setScene(scene);
        mainStage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}