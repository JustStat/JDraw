package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Geometry.GBounds;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.PI;

public class AffineTool extends ShapeTool {
    Point startPoint;
    double curangle = 0;
    int rtx = 0, rty = 0;
    Shape editShape;
    int index = -1;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();


    }

    @Override
    public void mouseReleased(MouseEvent e) {
        index = -1;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        int deltaX, deltaY;
        if (e.getButton() == 1) {
            if (index < 0) {
                for (Shape shape : ShapeManager.getInstance().shapes) {
                    index = GBounds.checkCorePoints(shape, e.getPoint());
                    editShape = shape;
                    if (index >= 0) {
                        break;
                    }
                }
            }
            if (index >= 0) {
                if (editShape != null) {
                    Point tsp = GAffineTransforms.applyInverseTransformForPoint(editShape, startPoint);
                    Point ap = GAffineTransforms.applyInverseTransformForPoint(editShape, e.getPoint());
                    deltaX = (int) ap.getX() - tsp.x;
                    deltaY = (int) ap.getY() - tsp.y;
                    Point corePoint = editShape.corePoints.get(index);
                    corePoint.x += deltaX;
                    corePoint.y += deltaY;
                    GAffineTransforms.applyTransformsForShape(editShape);
                }
            } else {
                for (Shape shape : ShapeManager.getInstance().shapes) {
                    deltaX = e.getX() - startPoint.x;
                    deltaY = e.getY() - startPoint.y;
                    GAffineTransforms.moveShape(shape, deltaX, deltaY);
                }
            }
            startPoint = e.getPoint();
        } else {
            curangle += getAngle(e.getPoint(), new Point(rtx, rty));
            for (Shape shape: ShapeManager.getInstance().shapes) {

                GAffineTransforms.rotateShape(shape, Math.toRadians(curangle));
                rtx = e.getX();
                rty = e.getY();
            }
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public Boolean needRepaint() {
        return true;
    }

    private double getAngle(Point origin, Point other) {
        int dx, dy;
        double angle;
        dy = other.y - origin.y;
        dx = other.x - origin.x;
        if (dx == 0) // special case
            angle = dy >= 0? PI/2: -PI/2;
        else
        {
            angle = Math.atan(dy/dx);
            if (dx < 0) // hemisphere correction
                angle += PI;
        }
        // all between 0 and 2PI
        if (angle < 0) // between -PI/2 and 0
            angle += 2*PI;
        return angle;
    }
}
