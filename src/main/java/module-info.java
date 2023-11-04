module com.example.nutritioncalculator3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.nutritioncalculator3 to javafx.fxml;
    exports com.example.nutritioncalculator3;
}