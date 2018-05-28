package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;

public class Rectange extends Shape {

    @Override
    public void paint(Graphics g) {
        GLine.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y, g);
        GLine.drawLine(points.get(1).x, points.get(1).y, points.get(3).x, points.get(3).y, g);
        GLine.drawLine(points.get(3).x, points.get(3).y, points.get(2).x, points.get(2).y, g);
        GLine.drawLine(points.get(2).x, points.get(2).y, points.get(0).x, points.get(0).y, g);
    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(points.get(0).x, points.get(0).y, Math.abs(points.get(3).x - points.get(0).x), Math.abs(points.get(3).y - points.get(0).y));
    }
}
