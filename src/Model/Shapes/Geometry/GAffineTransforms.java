package Model.Shapes.Geometry;

import Model.Shapes.Shape;

import java.awt.*;

public class GAffineTransforms  {
    public static void moveShape(Shape shape, int tx, int ty) {
        for (Point point: shape.points) {
            point.x += tx;
            point.y += ty;
        }
    }

    public static void rotateShape(Shape shape, double theta, Point center) {
            double sin = Math.sin(theta);
            double cos = Math.cos(theta);

        for (Point point: shape.points) {
            point.x = (int)(center.x + (point.x - center.x) * cos - (point.y - center.y) * sin);
            point.y = (int)(center.y + (point.y - center.y) * cos + (point.x - center.x) * sin);
        }
    }

    public static Point getShapeCenter(Shape shape) {
        int X = 0, Y = 0;
        for (Point point : shape.points) {
            X += point.x;
            Y += point.y;
        }
        return new Point(X/2, Y/2);
    }

}
