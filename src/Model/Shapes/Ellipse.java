package Model.Shapes;

import Model.Shapes.Geometry.GEllipse;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Ellipse extends Shape {

    @Override
    public void paint(Graphics g) {
        GEllipse.drawEllipse(this, corePoints.get(0), Math.abs(corePoints.get(1).x - corePoints.get(0).x) / 2, Math.abs(corePoints.get(1).y - corePoints.get(0).y) / 2, g);
    }

    @Override
    public Rectangle2D getBounds() {
        return null;
    }
}
