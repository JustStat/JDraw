package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Shape;


import java.awt.*;
import java.awt.event.MouseEvent;

public class ScaleTool extends ShapeTool{

    private static float scaleFactor = 1;
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            scaleFactor *= 2;
        } else {
            scaleFactor *= 0.5;
        }
        for (Shape shape: ShapeManager.getInstance().shapes) {
            GAffineTransforms.scaleShape(shape, scaleFactor);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public Boolean needRepaint() {
        return true;
    }
}
