module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires gson;
    requires java.sql;


    opens com.example.demo to javafx.fxml;
    opens com.example.demo.Entity to gson;
    exports com.example.demo;
    exports com.example.demo.Entity to gson;
}