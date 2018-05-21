package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;

public class AffineTool extends ShapeTool {
    Point startPoint;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        int deltaX, deltaY;
        deltaX = e.getX() - startPoint.x;
        deltaY = e.getY() - startPoint.y;
        if (e.getButton() == 1) {
            for (Shape shape: ShapeManager.getInstance().shapes) {
                GAffineTransforms.moveShape(shape, deltaX, deltaY);
            }
        } else {
            for (Shape shape: ShapeManager.getInstance().shapes) {
                GAffineTransforms.rotateShape(shape, Math.toRadians(30), GAffineTransforms.getShapeCenter(shape));
            }
        }

        startPoint = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public Boolean needRepaint() {
        return true;
    }
}
