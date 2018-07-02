package Model.Shapes;

import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Geometry.GBounds;
import Model.Shapes.Geometry.GEllipse;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Ellipse extends FilledShape {

    @Override
    public void paint(Graphics g) {
        GEllipse.drawEllipse(this, GBounds.getShapeCenter(this), Math.abs(corePoints.get(1).x - corePoints.get(0).x) / 2, Math.abs(corePoints.get(1).y - corePoints.get(0).y) / 2, g);
        paintFill(g);
    }

    @Override
    public void paintFill(Graphics g) {
        g.setColor(this.fillColor);
        Point drawPoint1 = new Point(min(points.get(0).x, points.get(1).x), min(points.get(0).y, points.get(1).y));
        Point drawPoint2 = new Point(max(points.get(0).x, points.get(1).x), max(points.get(0).y, points.get(1).y));
        g.fillOval(drawPoint1.x + 1, drawPoint1.y + 1, abs(drawPoint2.x - drawPoint1.x) - 1, abs(drawPoint2.y - drawPoint1.y) - 1);
    }

    @Override
    public String getName() {
        return "Эллипс";
    }
}
