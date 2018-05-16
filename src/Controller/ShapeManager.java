package Controller;

import Model.Shapes.IEditable;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

public class ShapeManager {

    public ArrayList<Shape> shapes = new ArrayList<>();
    public ArrayList<Class> shapesClasses = new ArrayList<>();
    public ArrayList<Integer> selectedShapes = new ArrayList<>();
    public ArrayList<Shape> tempShapes = new ArrayList<>();

    private static ShapeManager instance;

    public static synchronized ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void paintAll(Graphics g) {
        Integer i = 0;
        for (Shape shape:shapes) {
            if (selectedShapes.contains(i)) {
                Rectangle2D bounds = shape.getBounds2D();
                bounds.setRect(bounds.getX() - 4, bounds.getY() - 4, bounds.getWidth() + 8, bounds.getHeight() + 8);
                ((Graphics2D)g).setStroke(getDashedStroke());
                ((Graphics2D)g).draw(bounds);
                drawCorePoints(shape, g);
            }
            i++;
            ((Graphics2D)g).setStroke(new BasicStroke());
            ((Graphics2D)g).draw(shape);

        }
        for (Shape tmp: tempShapes) {
            ((Graphics2D)g).setStroke(getDashedStroke());
            ((Graphics2D)g).draw(tmp);
        }
    }

    private Stroke getDashedStroke() {
        float dash1[] = {10.0f};
        BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        return dashed;
    }

    private void drawCorePoints(Shape shape, Graphics g) {
        ArrayList<Point.Double> points = getPointsForShape(shape);

        for (Point.Double point:points) {
            Rectangle2D coreRect = new Rectangle2D.Double(point.x - 2, point.y - 2, 4, 4);
            ((Graphics2D)g).draw(coreRect);
            ((Graphics2D)g).fill(coreRect);
        }
    }

    public ArrayList<Point.Double> getPointsForShape(Shape shape) {
        PathIterator itr = shape.getPathIterator(new AffineTransform());
        ArrayList<Point.Double> corePoints = new ArrayList<>();

        double[] coords = new double[2];

        if (shape instanceof Ellipse2D) {
            Rectangle2D bounds = shape.getBounds();
            corePoints.add(new Point2D.Double(bounds.getMinX(), bounds.getMinY()));
            corePoints.add(new Point2D.Double(bounds.getMaxX(), bounds.getMaxY()));
        } else {
            while (!itr.isDone()) {
                itr.currentSegment(coords);
                for (int i = 0; i < coords.length - 1; i = i + 2) {
                    Point.Double corePoint = new Point.Double(coords[i], coords[i + 1]);
                    corePoints.add(corePoint);
                }
                itr.next();
            }
        }

        return corePoints;
    }

    public int checkCorePointForShape(Shape shape, Point.Double point) {
        ArrayList<Point.Double> cp = this.getPointsForShape(shape);
        int i = 0;
        for (Point.Double apoint:cp) {
            Rectangle2D coreRect = new Rectangle2D.Double(apoint.x - 4, apoint.y - 4, 8, 8);
            if (coreRect.contains(point)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
