package Model.Tools;

import Controller.Actions.ActionManager;
import Controller.Actions.AddAction;
import Controller.ShapeManager;
import Model.Shapes.Ellipse;
import Model.Shapes.Geometry.GAffineTransforms;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class EllipseTool extends ShapeTool {

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Ellipse();
        shape.points = new ArrayList<>(Collections.nCopies(2, e.getPoint()));
        shape.corePoints = new ArrayList<>(Collections.nCopies(2, e.getPoint()));
        GAffineTransforms.normalizeShape(shape);
        ShapeManager.getInstance().shapes.add(shape);
        ActionManager.getInstance().addActionToList(new AddAction(shape));
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
        shape.corePoints.set(1, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
