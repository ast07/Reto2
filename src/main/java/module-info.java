module com.example.retoajedrez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.retoajedrez to javafx.fxml;
    exports com.example.retoajedrez;
}