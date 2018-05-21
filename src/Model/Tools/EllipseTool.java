package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Ellipse;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class EllipseTool extends ShapeTool {

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Ellipse();
        shape.points = new ArrayList<>(Collections.nCopies(1, new Point(0, 0)));
        shape.points.set(0, e.getPoint());
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        Point center = shape.points.get(0);
        ((Ellipse)shape).xRadius = (int)Math.sqrt(Math.pow(e.getX() - center.x, 2) + Math.pow(e.getY() - center.y, 2));
        ((Ellipse)shape).yRadius = ((Ellipse)shape).xRadius*2;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
