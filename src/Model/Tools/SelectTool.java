package Model.Tools;

import Controller.ShapeManager;
import Model.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class SelectTool extends ShapeTool {
    @Override
    public void mousePressed(MouseEvent e) {
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

    }

    @Override
    public void mouseDragged(MouseEvent e, Graphics g) {
        for (Shape shape: ShapeManager.getInstance().shapes) {
            Rectangle2D bounds = shape.getBounds();
            if (bounds.contains(e.getPoint())) {
                ShapeManager.getInstance().selectedShapes.add(shape);
            } else {
                ShapeManager.getInstance().selectedShapes.remove(shape);
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
