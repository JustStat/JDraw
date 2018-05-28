package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class LineTool extends ShapeTool {

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Line();
        shape.points = new ArrayList<Point>(Collections.nCopies(2,  e.getPoint()));
        shape.corePoints = new ArrayList<Point>(Collections.nCopies(2,  e.getPoint()));
        GAffineTransforms.normalizeShape(shape);
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape.points.set(1, e.getPoint());
        shape.corePoints.set(1, e.getPoint());
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.points.set(1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) { }
}
