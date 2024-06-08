package com.example.chatsapp;

import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket seversocket;
    private Socket socket;
    private BufferedReader bReader;
    private BufferedWriter bWriter;

    protected Server(ServerSocket seversocket){
       try {
           this.seversocket = seversocket;
           this.socket = seversocket.accept();
           this.bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           this.bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
       }catch (IOException e){
           System.out.println("Server error");
           e.printStackTrace();
       }

    }

    protected void sendToClient(String message){
       try {
           bWriter.write(message);
           bWriter.newLine();
           bWriter.flush();
       }catch(IOException e){
           System.out.println("Can't send the message to the client..");
           e.printStackTrace();
        }

    }

    protected void startReadingFromClient(VBox chatHistory){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        String clientMSG = bReader.readLine();
                        ServerChatController.serverLabel(clientMSG,chatHistory);
                    } catch(IOException e){
                        e.printStackTrace();
                        System.out.println("Can't get message from client..");
                    }
                }
            }
        }).start();


    }
}
