package Model.Tools;

import Controller.ShapeManager;
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
            shape.points = new ArrayList<Point>(Collections.nCopies(1, new Point(0, 0)));
            shape.points.set(0, e.getPoint());
            ShapeManager.getInstance().shapes.add(shape);
        }
    }
}
