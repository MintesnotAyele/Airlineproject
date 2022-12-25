module com.example.javaprojectairline {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javaprojectairline to javafx.fxml;
    exports com.example.javaprojectairline;
}