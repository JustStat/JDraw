package Model.Shapes.Geometry;

import Controller.StyleGenerator;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GBounds {

    public static void drawBounds(Shape shape, Graphics g) {
        ((Graphics2D)g).setStroke(StyleGenerator.getDashedStroke());
        Rectangle2D bounds = shape.getBounds();
        g.drawRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(),(int)bounds.getHeight());
        ((Graphics2D)g).setStroke(new BasicStroke());
    }

    public static void drawCorePoints(Shape shape, Graphics g) {
        ArrayList<Point> points = shape.points;

        for (Point point:points) {

            Rectangle2D coreRect = new Rectangle2D.Double(point.x - 2, point.y - 2, 4, 4);
            ((Graphics2D)g).draw(coreRect);
            g.setColor(new Color(255, 255, 255));
            ((Graphics2D)g).fill(coreRect);
            g.setColor(new Color(0, 0, 0));
        }
    }

    public static Rectangle2D[] getCorePoints(Shape shape) {

        Rectangle2D[] coreRects = new Rectangle2D[shape.points.size()];

        int i = 0;
        for (Point point:shape.points) {
            coreRects[i] = new Rectangle2D.Double(point.x - 4, point.y - 4, 8, 8);
            i++;
        }

        return coreRects;
    }

    public static int checkCorePoints(Shape shape, Point point) {
        Rectangle2D[] coreRects = getCorePoints(shape);
        for (int i = 0; i < coreRects.length; i++) {
            if (coreRects[i].contains(point)) {
                return i;
            }
        }

        return -1;
    }

    public static Point getShapeCenter(Shape shape) {
        int X = 0, Y = 0, i = 0;
        for (Point point : shape.corePoints) {
            X += point.x;
            Y += point.y;
            i++;
        }
        return new Point(X/i, Y/i);
    }
}
