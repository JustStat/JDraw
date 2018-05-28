package Controller;

import Model.Shapes.Geometry.GBounds;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ShapeManager {

    public ArrayList<Shape> shapes = new ArrayList<>();
    public ArrayList<Shape> selectedShapes = new ArrayList<>();

    private static ShapeManager instance;

    public static synchronized ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void paintAll(Graphics g) {
        for (Shape shape:shapes) {
                shape.paint(g);
            Rectangle2D bounds = shape.getBounds();
            if (selectedShapes.contains(shape)) {
                g.drawRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(),(int)bounds.getHeight());
            }


        }
    }
}
