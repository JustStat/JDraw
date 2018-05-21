package Model.Tools;

import Controller.ShapeManager;
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
        shape.points = new ArrayList<Point>(Collections.nCopies(2, new Point(0, 0)));
        shape.points.set(0, e.getPoint());
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape.points.set(1, e.getPoint());
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.points.set(1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
