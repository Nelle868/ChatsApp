module com.example.chatsapp_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatsapp_client to javafx.fxml;
    exports com.example.chatsapp_client;
}