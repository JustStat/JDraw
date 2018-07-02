package Model.Shapes;

import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

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
        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        xPoints[0] = points.get(0).x + 1;
        yPoints[0] = points.get(0).y + 1;
        xPoints[1] = points.get(1).x;
        yPoints[1] = points.get(1).y + 1;
        xPoints[2] = points.get(2).x + 1;
        yPoints[2] = points.get(2).y;
        xPoints[3] = points.get(3).x;
        yPoints[3] = points.get(3).y;

        int tempX, tempY;
        tempX = xPoints[points.size() - 1];
        tempY = yPoints[points.size() - 1];
        xPoints[points.size() - 1] = xPoints[points.size() - 2];
        yPoints[points.size() - 1] = yPoints[points.size() - 2];
        xPoints[points.size() - 2] = tempX;
        yPoints[points.size() - 2] = tempY;
        g.fillPolygon(xPoints, yPoints, points.size());
    }

    @Override
    public String getName() {
        return "Квадрат";
    }
}
