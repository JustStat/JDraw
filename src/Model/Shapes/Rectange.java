package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;

import static java.lang.Math.abs;

public class Rectange extends Shape {

    @Override
    public void paint(Graphics g) {
        GLine.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(0).y, g);
        GLine.drawLine(points.get(1).x, points.get(0).y, points.get(1).x, points.get(1).y, g);
        GLine.drawLine(points.get(1).x, points.get(1).y, points.get(0).x, points.get(1).y, g);
        GLine.drawLine(points.get(0).x, points.get(1).y, points.get(0).x, points.get(0).y, g);
    }
}
