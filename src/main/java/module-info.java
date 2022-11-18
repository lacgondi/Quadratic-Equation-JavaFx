module com.example.quadraticequation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quadraticequation to javafx.fxml;
    exports com.example.quadraticequation;
}