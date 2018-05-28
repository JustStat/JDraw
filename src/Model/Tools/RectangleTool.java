package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Rectange;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleTool extends ShapeTool {

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Rectange();
        shape.points = new ArrayList<Point>(Collections.nCopies(4, e.getPoint()));
        shape.corePoints = new ArrayList<Point>(Collections.nCopies(4,  e.getPoint()));
        GAffineTransforms.normalizeShape(shape);
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape.points.set(3, e.getPoint());
        shape.points.set(1, new Point(shape.points.get(3).x, shape.points.get(0).y));
        shape.points.set(2, new Point(shape.points.get(0).x, shape.points.get(3).y));
        shape.corePoints.set(3, e.getPoint());
        shape.corePoints.set(1, new Point(shape.corePoints.get(3).x, shape.corePoints.get(0).y));
        shape.corePoints.set(2, new Point(shape.corePoints.get(0).x, shape.corePoints.get(3).y));
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.points.set(3, e.getPoint());
        shape.points.set(1, new Point(shape.points.get(3).x, shape.points.get(0).y));
        shape.points.set(2, new Point(shape.points.get(0).x, shape.points.get(3).y));
        shape.corePoints.set(3, e.getPoint());
        shape.corePoints.set(1, new Point(shape.corePoints.get(3).x, shape.corePoints.get(0).y));
        shape.corePoints.set(2, new Point(shape.corePoints.get(0).x, shape.corePoints.get(3).y));
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
