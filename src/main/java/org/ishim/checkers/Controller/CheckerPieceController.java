package org.ishim.checkers.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.Effect;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class CheckerPieceController implements Initializable{

    private double mouseX, mouseY;
    private Effect prevEffect;
    private Paint prevFill;

    @FXML
    private Circle checkerPiece;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        checkerPiece.setOnMouseDragged(e -> {
            System.out.println("setOnMouseDragged > dragged x:" + e.getX() + " y:" + e.getY());
            e.setDragDetect(true);
            double dx = e.getX() - mouseX;
            double dy = e.getY() - mouseY;
            checkerPiece.relocate(dx, dy);

//            checkerPiece.translateXProperty().set(dx);
//            checkerPiece.translateYProperty().set(dy);
            mouseX = e.getX();
            mouseY = e.getY();
        });

        checkerPiece.setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
            Circle c = (Circle) e.getSource();
            c.setStrokeWidth(8);
            prevEffect = c.getEffect();
            prevFill = c.getFill();
            c.setFill(Color.LIGHTGREY);
        });

        checkerPiece.setOnDragDetected(e -> {
            System.out.println("dragged x:" + e.getX() + " y:" + e.getY());
            Dragboard db = checkerPiece.startDragAndDrop(TransferMode.ANY);
            SnapshotParameters sp = new SnapshotParameters();
            sp.setFill(Color.DARKORANGE);
            WritableImage wi = new WritableImage((int) checkerPiece.getRadius(), (int) checkerPiece.getRadius());
            db.setDragView(checkerPiece.snapshot(sp, wi));


//            checkerPiece.snapshot(sp, null);

//            Dragboard db = checkerPiece.startDragAndDrop(TransferMode.ANY);
//            ClipboardContent content = new ClipboardContent();
//            content.put(DataFormat., checkerPiece);
            e.consume();
        });

        checkerPiece.setOnMouseReleased(e -> {
            System.out.println("released x:" + e.getX() + " y:" + e.getY());
            Circle c = (Circle) e.getSource();
            c.setStrokeWidth(4);
            c.setEffect(prevEffect);
            c.setFill(prevFill);
        });

        checkerPiece.setOnDragDropped(e -> {
            System.out.println("setOnDragDropped >> dropped x:" + e.getX() + " y:" + e.getY());
        });

//        checkerPiece.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
//            System.out.println("addEventHandler > dragged x:" + event.getX() + " y:" + event.getY());
//        });
    }
}
