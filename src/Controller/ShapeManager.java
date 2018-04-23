package Controller;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ShapeManager {

    public ArrayList<Shape> shapes = new ArrayList<>();
    public ArrayList<Shape> selectedShapes = new ArrayList<>();
    public ArrayList<Shape> tempShapes = new ArrayList<>();

    private static ShapeManager instance;

    public static synchronized ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void paintAll(Graphics g) {
        for (Shape shape:shapes) {
            if (selectedShapes.contains(shape)) {
                Rectangle2D bounds = shape.getBounds2D();
                bounds.setRect(bounds.getX() - 4, bounds.getY() - 4, bounds.getWidth() + 8, bounds.getHeight() + 8);
                ((Graphics2D)g).setStroke(getDashedStroke());
                ((Graphics2D)g).draw(bounds);
                drawCorePoints(shape, g);
            }
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
        PathIterator itr = shape.getPathIterator(new AffineTransform());

        double[] coords = new double[2];

        while(!itr.isDone()){
            itr.currentSegment(coords);
            Rectangle2D coreRect = new Rectangle2D.Double(coords[0] - 2, coords[1] - 2, 4, 4);
            ((Graphics2D)g).draw(coreRect);
            ((Graphics2D)g).fill(coreRect);
            itr.next();
        }
    }
}
