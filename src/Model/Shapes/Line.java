package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Line extends Shape {
    @Override
    public void paint(Graphics g) {
        GLine.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y, g);
    }

    @Override
    public Rectangle2D getBounds() {
        float x, y, w, h;
        if (points.get(0).x < points.get(1).x) {
            x = points.get(0).x;
            w = points.get(1).x - points.get(0).x;
        } else {
            x = points.get(1).x;
            w = points.get(0).x - points.get(1).x;
        }
        if (points.get(0).y < points.get(1).y) {
            y = points.get(0).y;
            h = points.get(1).y - points.get(0).y;
        } else {
            y = points.get(1).y;
            h = points.get(0).y - points.get(1).y;
        }

        return new Rectangle2D.Float(x, y, w, h);
    }
}
