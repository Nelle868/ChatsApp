module com.example.chatsapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatsapp to javafx.fxml;
    exports com.example.chatsapp;
}