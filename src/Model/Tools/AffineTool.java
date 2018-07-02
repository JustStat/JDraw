package Model.Tools;

import Controller.Actions.ActionManager;
import Controller.Actions.EditAction;
import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Geometry.GBounds;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import static java.lang.Math.PI;

public class AffineTool extends ShapeTool {
    Point startPoint;
    double curangle = 0;
    int rtx = 0, rty = 0;
    Shape editShape;
    ArrayList<Shape> sourceArray = new ArrayList<>();
    ArrayList<Shape> origignalShapes = new ArrayList<>();
    ArrayList<Shape> editedShapes = new ArrayList<>();
    EditAction action = new EditAction();
    int index = -1;

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        ActionManager.getInstance().addActionToList(action);
        if (ShapeManager.getInstance().selectedShapes.size() == 0) {
            sourceArray = ShapeManager.getInstance().shapes;
        } else {
            sourceArray = ShapeManager.getInstance().selectedShapes;
        }
        action.saveOriginalShapes(sourceArray);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        index = -1;
        ActionManager.getInstance().saveEditedShapes(editedShapes);
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
                origignalShapes.clear();
                editedShapes.clear();
                for (Shape shape : sourceArray) {
                    deltaX = e.getX() - startPoint.x;
                    deltaY = e.getY() - startPoint.y;
                    origignalShapes.add(shape);
                    GAffineTransforms.moveShape(shape, deltaX, deltaY);
                    try {
                        editedShapes.add(shape);
                    } catch (Throwable throwable) {

                    }

                }
            }
            startPoint = e.getPoint();
        } else {
            curangle += getAngle(e.getPoint(), new Point(rtx, rty));
            origignalShapes.clear();
            editedShapes.clear();
            for (Shape shape : sourceArray) {
                origignalShapes.add((Shape)shape);
                GAffineTransforms.rotateShape(shape, Math.toRadians(curangle));
                rtx = e.getX();
                rty = e.getY();
                editedShapes.add(shape);
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
