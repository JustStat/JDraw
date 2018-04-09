package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.BezierLine;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class BezierTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new BezierLine();
            shape.points = new ArrayList<Point>(Collections.nCopies(1, new Point(0, 0)));
            shape.points.set(0, e.getPoint());
            ShapeManager.getInstance().shapes.add(shape);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            shape.points.add(e.getPoint());
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            shape.points.set(shape.points.size() - 1, e.getPoint());
            shape = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.points.set(shape.points.size() - 1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (shape == null) { return;}
        shape.points.set(shape.points.size() - 1, e.getPoint());
    }
}
