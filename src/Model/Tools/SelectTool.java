package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SelectTool extends ShapeTool {
    Point startPoint;
    Rectangle2D selectRect;
    @Override
    public void mousePressed(MouseEvent e) {
        selectRect = new Rectangle2D.Double();
        startPoint = e.getPoint();
        ShapeManager.getInstance().tempShapes.add(selectRect);
        ShapeManager.getInstance().selectedShapes.clear();
        for (Shape shape: ShapeManager.getInstance().shapes) {
            Rectangle2D bounds = shape.getBounds();
            if (bounds.contains(e.getPoint())) {
                ShapeManager.getInstance().selectedShapes.add(shape);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ShapeManager.getInstance().tempShapes.remove(selectRect);
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ShapeManager.getInstance().selectedShapes.clear();
        Point point1 = new Point(min(startPoint.x, e.getX()), min(startPoint.y, e.getY()));
        Point point2 = new Point(max(startPoint.x, e.getX()), max(startPoint.y, e.getY()));
        selectRect.setRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
        for (Shape ashape: ShapeManager.getInstance().shapes) {
            if (selectRect.intersects(ashape.getBounds())) {
                ShapeManager.getInstance().selectedShapes.add(ashape);
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
}
