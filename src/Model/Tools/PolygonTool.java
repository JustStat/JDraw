package Model.Tools;

import Controller.Actions.ActionManager;
import Controller.Actions.AddAction;
import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Polygon;
import Model.Shapes.Polyline;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class PolygonTool extends PolylineTool {
    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new Polygon();
            shape.points = new ArrayList<>(Collections.nCopies(1, e.getPoint()));
            shape.corePoints = new ArrayList<>(Collections.nCopies(1, e.getPoint()));
            GAffineTransforms.normalizeShape(shape);
            ShapeManager.getInstance().shapes.add(shape);
            ActionManager.getInstance().addActionToList(new AddAction(shape));
        }
    }
}
