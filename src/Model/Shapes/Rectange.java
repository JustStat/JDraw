package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;

public class Rectange extends FilledShape {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GLine.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y, g);
        GLine.drawLine(points.get(1).x, points.get(1).y, points.get(3).x, points.get(3).y, g);
        GLine.drawLine(points.get(3).x, points.get(3).y, points.get(2).x, points.get(2).y, g);
        GLine.drawLine(points.get(2).x, points.get(2).y, points.get(0).x, points.get(0).y, g);
        paintFill(g);
    }

    @Override
    public void paintFill(Graphics g) {
        g.setColor(this.fillColor);
        g.fillRect(points.get(0).x - 1, points.get(0).y - 1, abs(points.get(3).x - points.get(0).x), abs(points.get(3).y - points.get(0).y));
    }

    @Override
    public String getName() {
        return "Квадрат";
    }
}
