package View;

import Controller.ShapeManager;
import Model.Shapes.IFillable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PropertyPanel extends JPanel {
    public void setupWithShapes(ArrayList<Shape> shapes) {
        for (Shape shape: shapes) {
            Class sc = ShapeManager.getInstance().shapesClasses.get(ShapeManager.getInstance().shapes.indexOf(shape));
            if (shape instanceof IFillable) {

            }
        }
    }
}
