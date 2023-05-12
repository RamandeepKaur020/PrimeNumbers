module com.example.primenumbers {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.primenumbers to javafx.fxml;
    exports com.example.primenumbers;
}