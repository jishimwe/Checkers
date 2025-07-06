package org.ishim.checkers.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.ishim.checkers.CheckersApp;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DamController implements Initializable {

    @FXML
    private GridPane damPanel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GridPane.setFillHeight(damPanel,  true);
        GridPane.setFillWidth(damPanel,  true);
        damPanel.setPadding(new Insets(4));

        char[] c = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  'K', 'L', 'M'};
        for (int i = 1; i < damPanel.getColumnCount(); i++) {
            Label lbl = new Label();
            lbl.setText(String.valueOf(c[i]));
            damPanel.add(lbl, 0, i);
            lbl = new Label();
            lbl.setText(String.valueOf(i));
            damPanel.add(lbl, i, 0);
            for (int j = 1; j < damPanel.getRowCount(); j++) {
                if ((i + j)%2 == 0) {
                    double w = damPanel.getColumnConstraints().get(i).getMaxWidth();
                    double h = damPanel.getRowConstraints().get(i).getMaxHeight();
                    Rectangle sq = new Rectangle(800.0/12, 800.0/12);
                    Paint fill = Color.LIGHTGREY;
                    sq.fillProperty().setValue(fill);
                    damPanel.add(sq, i, j);
                } else {
                    if (i < 5 || i > 6) {
                        FXMLLoader piece = new FXMLLoader(CheckersApp.class.getResource("fxml/CheckerPiece.fxml"));
                        Scene sc;
/*                        try {
                            sc = new Scene(piece.load(), 800.0/12, 800.0/12);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }*/
                        try {
                            Circle circle = piece.load();
                            circle.setRadius(28);
                            circle.setStrokeWidth(4);
//                            circle.setFill(i > 5 ? Color.BISQUE : Color.GREEN);
                            RadialGradient effect1 = new RadialGradient(
                                    0.0, 0.0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
                                    new Stop(0.0, new Color(0.64, 0.2496, 0.4206, 0.82)),
                                    new Stop(0.0067, new Color(0.64, 0.2496, 0.4206, 0.82)),
                                    new Stop(0.7819, new Color(0.4605, 0.1194, 0.199, 0.92)),
                                    new Stop(1.0, new Color(0.46, 0.2024, 0.2024, 0.729)));
                            RadialGradient effect2 = new RadialGradient(
                                    0.0, 0.0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
                                    new Stop(0.0, new Color(0.64, 0.2496, 0.4206, 0.82)),
                                    new Stop(0.0067, new Color(0.12, 0.462, 0.5, 1.0)),
                                    new Stop(0.6275, new Color(0.12, 0.3712, 0.5, 0.92)),
                                    new Stop(1.0, new Color(0.0903, 0.2414, 0.3421, 0.73)));

//                            circle.setFill(effect1);
                            circle.setFill(i > 5 ? effect1 : effect2);
                            damPanel.add(circle, j, i);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
