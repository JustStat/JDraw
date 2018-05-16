package Model.Tools;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.CubicCurve2D;

public class BezierTool extends ShapeTool {

    Point startPoint;
    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new CubicCurve2D.Double();
            ShapeManager.getInstance().shapes.add(shape);
            ShapeManager.getInstance().shapesClasses.add(shape.getClass());
            startPoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ((CubicCurve2D)shape).setCurve(startPoint, startPoint, e.getPoint(), e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {
        if (shape == null) { return;}

    }
}
