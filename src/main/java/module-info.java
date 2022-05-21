module com.amirali.examplejfxnotification {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.amirali.examplejfxnotification;
    opens com.amirali.examplejfxnotification to javafx.fxml;
}