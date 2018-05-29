package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Polyline extends Shape {
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            GLine.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y, g);
        }

    }
}
