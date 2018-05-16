package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Ellipse;
import Model.Shapes.IFillable;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class EllipseTool extends ShapeTool {

    private Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Ellipse();
        ShapeManager.getInstance().shapes.add(shape);
        ShapeManager.getInstance().shapesClasses.add(shape.getClass());
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ((Ellipse2D.Double)shape).setFrame(startPoint, new Dimension(e.getX()  - startPoint.x, e.getY() - startPoint.y));
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
