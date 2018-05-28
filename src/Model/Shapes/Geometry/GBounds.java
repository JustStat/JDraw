package Model.Shapes.Geometry;

import Model.Shapes.Shape;

import java.awt.*;

public class GBounds {
    public static Point[] getBoundsForShape(Shape shape) {
        Point[] points = new Point[4];
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (Point point:shape.points) {
            maxX = maxX < point.x ? point.x : maxX;
            maxX = maxY < point.y ? point.y : maxY;
            minX = minX > point.x ? point.x : minX;
            minY = minY > point.y ? point.y : minY;
        }
        points[0] = new Point(minX, minY);
        points[1] = new Point(maxX, maxY);

        return points;

    }
}
