package Model.Tools;

import Controller.Actions.ActionManager;
import Controller.Actions.AddAction;
import Controller.ShapeManager;
import Model.Shapes.BezierLine;
import Model.Shapes.Geometry.GAffineTransforms;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class BezierTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new BezierLine();
            shape.points = new ArrayList<Point>(Collections.nCopies(1, e.getPoint()));
            shape.corePoints = new ArrayList<Point>(Collections.nCopies(1, e.getPoint()));
            GAffineTransforms.normalizeShape(shape);
            ShapeManager.getInstance().shapes.add(shape);
            ActionManager.getInstance().addActionToList(new AddAction(shape));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            shape.corePoints.add(e.getPoint());
            shape.points.add(e.getPoint());

        } else if (e.getButton() == MouseEvent.BUTTON3) {
            shape.points.set(shape.points.size() - 1, e.getPoint());
            shape.corePoints.set(shape.corePoints.size() - 1, e.getPoint());
            shape = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        shape.corePoints.set(shape.corePoints.size() - 1, e.getPoint());
        shape.points.set(shape.points.size() - 1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (shape == null) { return;}
        shape.corePoints.set(shape.corePoints.size() - 1, e.getPoint());
        shape.points.set(shape.points.size() - 1, e.getPoint());
    }
}
