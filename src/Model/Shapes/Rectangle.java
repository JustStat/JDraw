package Model.Shapes;

import Controller.ShapeManager;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;

public class Rectangle extends java.awt.Rectangle implements IEditable {

    @Override
    public Shape resizeShape(int index, Point point) {
        RectangularShape retval = (RectangularShape) this.clone();
        if (index == 0) {
            retval.setFrame(point.x, point.y, this.width + (this.x - point.x), this.height + (this.y - point.y));
        } else {
            retval.setFrame(retval.getX(), retval.getY(), point.getX()  - this.x, point.getY() - this.y);
        }
        return retval;
    }

    @Override
    public Shape rotateShape(double theta, Point center) {
        return null;
    }
}
