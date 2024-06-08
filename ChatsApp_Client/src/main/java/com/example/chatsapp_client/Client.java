package com.example.chatsapp_client;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedWriter bWriter;
    private BufferedReader bReader;

    protected Client (Socket socket){
        try {
            this.socket = socket;
            this.bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e){
            System.out.println("Client error");
            e.printStackTrace();
        }

    }

    protected void sendToServer (String message){
        try {
            bWriter.write(message);
            bWriter.newLine();
            bWriter.flush();
        }catch(IOException e){
            System.out.println("Can't send the message to the server..");
            e.printStackTrace();
        }
    }

    protected void startReadingFromServer(VBox chatHistory){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String clientMSG = bReader.readLine();
                        ClientController.clientLabel(clientMSG,chatHistory);
                    } catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Can't get message from server..");
                    }
                }
            }
        }).start();
    }

}
