package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collections;

public class LineTool extends ShapeTool {

    private Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Line2D.Double();
        ShapeManager.getInstance().shapes.add(shape);
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ((Line2D.Double)shape).setLine(startPoint, e.getPoint());
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) { }
}
