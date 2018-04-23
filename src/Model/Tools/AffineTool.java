package Model.Tools;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class AffineTool extends ShapeTool {
    private Point startPoint;
    private double rtx = 0, rty = 0;
    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        ArrayList<Shape> shapes = ShapeManager.getInstance().shapes;
        shape = shapes.get(0);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {

        AffineTransform transform = new AffineTransform();
        if (e.getButton() == MouseEvent.BUTTON1) {
            transform.translate((startPoint.x - e.getX())*(-1) , (startPoint.y - e.getY())*(-1));
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            Rectangle rect = shape.getBounds();
            Point center = new Point(rect.x + rect.width / 2, rect.y + rect.height / 2);
            Double theta = Math.atan2((rtx - center.x)*(e.getY() - center.y) - (e.getX() - center.x)*(rty - center.y), (rtx - center.x)*(e.getX() - center.x) + (e.getY() - center.y)*(rty - center.y));
            transform.rotate(Math.toRadians(theta*57), center.x, center.y);
            rtx = e.getX();
            rty = e.getY();
        }
        shape = transform.createTransformedShape(shape);
        ShapeManager.getInstance().shapes.set(0, shape);
        startPoint = e.getPoint();

    }

    @Override
    public void mouseMoved(MouseEvent e, Graphics g) {

    }
}
