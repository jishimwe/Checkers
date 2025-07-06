package org.ishim.checkers.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckerPieceController implements Initializable {

    @FXML
    private Circle checkerPiece;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkerPiece.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

        });
    }
}
