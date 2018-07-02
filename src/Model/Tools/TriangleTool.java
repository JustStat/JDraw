package Model.Tools;

import Controller.Actions.ActionManager;
import Controller.Actions.AddAction;
import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Triangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class TriangleTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Triangle();
        shape.points = new ArrayList<Point>(Collections.nCopies(3,  e.getPoint()));
        shape.corePoints = new ArrayList<Point>(Collections.nCopies(3,  e.getPoint()));
        GAffineTransforms.normalizeShape(shape);
        ShapeManager.getInstance().shapes.add(shape);
        ActionManager.getInstance().addActionToList(new AddAction(shape));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape.corePoints.set(1, e.getPoint());
        shape.points.set(1, e.getPoint());
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.corePoints.set(1, e.getPoint());
        shape.points.set(1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
