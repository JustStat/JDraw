package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Triangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class TriangleTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
//        shape = new Triangle();
//        shape.points = new ArrayList<Point>(Collections.nCopies(2, new Point(0, 0)));
//        shape.points.set(0, e.getPoint());
//        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        shape.points.set(1, e.getPoint());
//        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
//        shape.points.set(1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
