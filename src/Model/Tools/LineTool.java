package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class LineTool extends ShapeTool {

    private Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Line();
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
        ((Line2D.Double)shape).setLine(startPoint, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) { }
}
