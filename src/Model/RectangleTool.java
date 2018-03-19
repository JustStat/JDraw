package Model;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleTool extends ShapeTool implements IDraggable {

    private ArrayList<Point> keyPoints = new ArrayList<Point>(Collections.nCopies(2, new Point(0, 0)));

    @Override
    public void paintShape(Graphics g) {
        shape.paint(g);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new  Rectange();
        shape.points = new ArrayList<Point>(Collections.nCopies(2, new Point(0, 0)));
        keyPoints.set(0, e.getPoint());
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        keyPoints.set(1, e.getPoint());
        shape.points.set(0, new Point(min(keyPoints.get(0).x, keyPoints.get(1).x), min(keyPoints.get(0).y, keyPoints.get(1).y)));
        shape.points.set(1, new Point(max(keyPoints.get(0).x, keyPoints.get(1).x), max(keyPoints.get(0).y, keyPoints.get(1).y)));
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        keyPoints.set(1, e.getPoint());
        shape.points.set(0, new Point(min(keyPoints.get(0).x, keyPoints.get(1).x), min(keyPoints.get(0).y, keyPoints.get(1).y)));
        shape.points.set(1, new Point(max(keyPoints.get(0).x, keyPoints.get(1).x), max(keyPoints.get(0).y, keyPoints.get(1).y)));

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public Boolean isDragging() {
        return shape == null;
    }
}
