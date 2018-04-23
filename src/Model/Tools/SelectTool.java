package Model.Tools;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SelectTool extends ShapeTool {
    Point startPoint;
    @Override
    public void mousePressed(MouseEvent e) {
        shape = new Rectangle2D.Double();
        startPoint = e.getPoint();
        ShapeManager.getInstance().tempShapes.add(shape);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        ShapeManager.getInstance().tempShapes.remove(shape);
        shape = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        ShapeManager.getInstance().selectedShapes.clear();
        Point point1 = new Point(min(startPoint.x, e.getX()), min(startPoint.y, e.getY()));
        Point point2 = new Point(max(startPoint.x, e.getX()), max(startPoint.y, e.getY()));
        ((Rectangle2D)shape).setRect(point1.x, point1.y, point2.x - point1.x, point2.y - point1.y);
        ((Graphics2D)g).draw(shape);
        for (Shape ashape: ShapeManager.getInstance().shapes) {
            if (shape.intersects(ashape.getBounds2D())) {
                ShapeManager.getInstance().selectedShapes.add(ashape);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }

    public Boolean needRepaint() {
        return true;
    }

}
