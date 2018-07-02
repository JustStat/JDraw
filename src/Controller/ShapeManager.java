package Controller;

import Model.Shapes.Geometry.GBounds;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ShapeManager {

    public ArrayList<Shape> shapes = new ArrayList<>();
    public ArrayList<Shape> selectedShapes = new ArrayList<>();
    public ArrayList<java.awt.Shape> tempShapes = new ArrayList<>();
    public int currentStrokeType = 0;
    public Color currentStrokeColor = Color.BLACK;
    public int currentStrokeSize = 1;
    public Color currentFillColor = Color.WHITE;

    private static ShapeManager instance;

    public static synchronized ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void paintAll(Graphics g) {
        for (Shape shape:shapes) {
            ((Graphics2D)g).setStroke(StyleGenerator.getStrokeWithType(currentStrokeType, currentStrokeSize));
            g.setColor(currentStrokeColor);
            shape.paint(g);
            if (selectedShapes.contains(shape)) {
                GBounds.drawBounds(shape, g);
                GBounds.drawCorePoints(shape, g);
            }
        }
        for (java.awt.Shape shape:tempShapes) {
            ((Graphics2D)g).setStroke(StyleGenerator.getDashedStroke());
            g.setColor(Color.BLACK);
            ((Graphics2D)g).draw(shape);
        }
    }
}
