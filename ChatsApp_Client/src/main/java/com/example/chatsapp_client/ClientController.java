package com.example.chatsapp_client;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
@FXML
private Button enterButton = new Button();
@FXML
private TextField txtInput;
@FXML
private AnchorPane anchorPane;
@FXML
private ScrollBar scrollBar;
@FXML
private VBox chatHistory;
private Client client;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            client = new Client (new Socket("localhost", 8080));
            System.out.println("Connected!");
        } catch (IOException e ){
            e.printStackTrace();
            System.out.println("Client cannot connect to server..");
        }

        chatHistory.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scrollBar.setValue((Double) t1);
            }
        });

        client.startReadingFromServer(chatHistory);
        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String sendMessage = txtInput.getText();
                if (!sendMessage.isEmpty()){
                    HBox textBubble = new HBox();
                    textBubble.setAlignment(Pos.CENTER_RIGHT);
                    textBubble.setPadding(new Insets(5,5,5, 10));
                    Text text = new Text(sendMessage);
                    TextFlow textViz = new TextFlow(text);

                    textViz.setStyle("-fx-color: rgb(239, 242, 255);" + "-fx-background-color: rgb(55,162,11);" +
                            "-fx-background-radius: 20px");
                    textViz.setPadding(new Insets(5,10,5,10));
                    text.setFill(Color.color(0.934, 0.945,0.996 ));

                    textBubble.getChildren().add(textViz);
                    chatHistory.getChildren().add(textBubble);

                    client.sendToServer(sendMessage);
                    txtInput.clear();
                }
            }
        });
    }

    protected static void clientLabel(String serverMessage, VBox chatHistory){
        HBox box = new HBox();
        box.setAlignment(Pos.CENTER_LEFT);
        box.setPadding(new Insets(5,5,5,10));
        Text txt = new Text(serverMessage);
        TextFlow textViz = new TextFlow(txt);
        textViz.setStyle("-fx-color: rgb(239, 242, 255);" + "-fx-background-color: rgb(142,154,155);" +
                "-fx-background-radius: 20px");
        textViz.setPadding(new Insets(5,10,5,10));
        txt.setFill(Color.color(0.934, 0.945,0.996 ));
        box.getChildren().add(textViz);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                chatHistory.getChildren().add(box);
            }
        });
    }
}