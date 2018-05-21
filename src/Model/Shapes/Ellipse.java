package Model.Shapes;

import Model.Shapes.Geometry.GEllipse;

import java.awt.*;

public class Ellipse extends Shape {
    public int xRadius, yRadius;
    @Override
    public void paint(Graphics g) {
        GEllipse.drawEllipse(points.get(0), xRadius, yRadius, g);
    }
}
