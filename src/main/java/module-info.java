module com.example.viewcontrollerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.viewcontrollerapp to javafx.fxml;
    exports com.example.viewcontrollerapp;
}