package Model.Tools;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;

public class PolylineTool extends ShapeTool {

    Line2D.Double tempSegment = new Line2D.Double();
    Point currPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new Path2D.Double();
            ShapeManager.getInstance().shapes.add(shape);
            ShapeManager.getInstance().shapesClasses.add(shape.getClass());
            ShapeManager.getInstance().shapes.add(tempSegment);
            ((Path2D.Double)shape).moveTo(e.getX(), e.getY());
            currPoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ((Path2D.Double)shape).lineTo(e.getX(), e.getY());
        if (e.getButton() == MouseEvent.BUTTON1) {
            currPoint = e.getPoint();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            ((Path2D.Double)shape).closePath();
            ShapeManager.getInstance().shapes.remove(tempSegment);
            shape = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        tempSegment.setLine(currPoint, e.getPoint());
        ((Graphics2D)g).draw(tempSegment);
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {
        if (shape == null) { return;}
        tempSegment.setLine(currPoint, e.getPoint());
        ((Graphics2D)g).draw(tempSegment);
    }
}
