package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Rectange;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class RectangleTool extends ShapeTool {

    private Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Rectangle();
        ShapeManager.getInstance().shapes.add(shape);
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ((Rectangle)shape).setBounds(startPoint.x, startPoint.y, e.getX()  -startPoint.x, e.getY() - startPoint.y);
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
