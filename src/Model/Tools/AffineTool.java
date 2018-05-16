package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.IEditable;
import Model.Shapes.ShapeTransform;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.*;
import java.util.ArrayList;

public class AffineTool extends ShapeTool {
    private Point startPoint;
    private double rtx = 0, rty = 0;
    private int curIndex = -1;
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        curIndex = -1;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {

        if (e.getButton() == MouseEvent.BUTTON1) {
            for (int i = 0; i < ShapeManager.getInstance().shapes.size(); i++) {
                if (ShapeManager.getInstance().selectedShapes.contains(i)) {
                    shape = ShapeManager.getInstance().shapes.get(i);
                    if (curIndex < 0) {
                        curIndex = ShapeManager.getInstance().checkCorePointForShape(shape, new Point.Double(e.getX(), e.getY()));
                    }
                    if (curIndex >= 0) {
                        ShapeManager.getInstance().shapes.set(i, ((IEditable)shape).resizeShape(curIndex, e.getPoint()));

//                        corePoints.set(index, new Point2D.Double(e.getX(), e.getY()));
//                        Path2D.Double dd = new Path2D.Double();
//                        dd.moveTo(corePoints.get(0).x, corePoints.get(0).y);
//                        for (int j = 1; j < corePoints.size(); j++) {
//                            dd.lineTo(corePoints.get(j).x, corePoints.get(j).y);
//                            ShapeManager.getInstance().shapes.set(i, dd);
//                        }

                    } else {
                            ShapeManager.getInstance().shapes.set(i, ShapeTransform.translateShape(shape, (startPoint.x - e.getX())*(-1), (startPoint.y - e.getY())*(-1)));
                    }
                }
            }
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            for (int i = 0; i < ShapeManager.getInstance().shapes.size(); i++) {
                if (ShapeManager.getInstance().selectedShapes.contains(i)) {
                    shape = ShapeManager.getInstance().shapes.get(i);
                    Rectangle rect = shape.getBounds();
                    Point center = new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
                    Double theta = Math.atan2((rtx - center.x)*(e.getY() - center.y) - (e.getX() - center.x)*(rty - center.y), (rtx - center.x)*(e.getX() - center.x) + (e.getY() - center.y)*(rty - center.y));
                    ShapeManager.getInstance().shapes.set(i, ((IEditable)shape).rotateShape(theta, center));
                    rtx = e.getX();
                    rty = e.getY();
                }
            }
        }

        startPoint = e.getPoint();

    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
