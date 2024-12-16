package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraserRadioButton;

    private ToggleGroup toolToggleGroup; 

    public PainterController() {
        toolToggleGroup = new ToggleGroup();
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Kiểm tra xem Pen hay Eraser được chọn
        Color color = penRadioButton.isSelected() ? Color.BLACK : Color.WHITE;
        
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    public void initialize() {
        // Gán ToggleGroup cho các RadioButton
        penRadioButton.setToggleGroup(toolToggleGroup);
        eraserRadioButton.setToggleGroup(toolToggleGroup);

        // default Pen
        penRadioButton.setSelected(true);
    }
}
