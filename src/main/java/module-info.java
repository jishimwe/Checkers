module org.ishim.checkers {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;


    opens org.ishim.checkers to javafx.fxml;
    exports org.ishim.checkers;
    exports org.ishim.checkers.Controller;
    opens org.ishim.checkers.Controller to javafx.fxml;
}