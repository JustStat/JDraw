package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Polygon extends FilledShape {
    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            GLine.drawLine(points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y, g);
        }
        GLine.drawLine(points.get(points.size() - 1).x, points.get(points.size() - 1).y, points.get(0).x, points.get(0).y, g);
        paintFill(g);
    }

    @Override
    public void paintFill(Graphics g) {
        g.setColor(this.fillColor);
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        int i = 0;
        for (Point point: points) {
            xPoints[i] = point.x;
            yPoints[i] = point.y;
            i++;
        }
        g.fillPolygon(xPoints, yPoints, points.size());
    }

    @Override
    public String getName() {
        return "Полигон";
    }
}
