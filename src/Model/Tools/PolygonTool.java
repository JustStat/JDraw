package Model.Tools;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;

public class PolygonTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
        if (shape == null) {
            shape = new Polygon();
            ShapeManager.getInstance().shapes.add(shape);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            ((Polygon)shape).addPoint(e.getX(), e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            shape = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {

    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }


}
