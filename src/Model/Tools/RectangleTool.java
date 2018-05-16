package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.IEditable;
import Model.Shapes.IFillable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleTool extends ShapeTool {

    private Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Model.Shapes.Rectangle();
        ShapeManager.getInstance().shapes.add(shape);
        ShapeManager.getInstance().shapesClasses.add(shape.getClass());
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        Point point1 = new Point(min(startPoint.x, e.getX()), min(startPoint.y, e.getY()));
        Point point2 = new Point(max(startPoint.x, e.getX()), max(startPoint.y, e.getY()));
        ((Rectangle)shape).setBounds(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
