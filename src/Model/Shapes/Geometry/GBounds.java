package Model.Shapes.Geometry;

import Model.Shapes.Shape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GBounds {

    public static void drawBounds(Shape shape, Graphics g) {
        Rectangle2D bounds = shape.getBounds();
        g.drawRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(),(int)bounds.getHeight());
    }

    public static void drawCorePoints(Shape shape, Graphics g) {
        ArrayList<Point> points = shape.points;

        for (Point point:points) {
            Rectangle2D coreRect = new Rectangle2D.Double(point.x - 2, point.y - 2, 4, 4);
            ((Graphics2D)g).draw(coreRect);
            ((Graphics2D)g).fill(coreRect);
        }
    }
}
