package Model.Shapes;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends Line2D.Double implements IEditable {
    @Override
    public Shape resizeShape(int index, Point point) {
        final Line2D newLine = getNormalizedLine(this);
        if (index == 0) {
            newLine.setLine(point, this.getP2());
        } else {
            newLine.setLine(this.getP1(), point);
        }
        return newLine;
    }

    @Override
    public Shape rotateShape(double theta, Point center) {
        return null;
    }

    private static Line2D getNormalizedLine(final Line2D line) {
        final Line2D lineClone = (Line2D) line.clone();

        final Point2D p1 = line.getP1();
        final Point2D p2 = line.getP2();
        if (p1.getX() < p2.getX()) {
            return lineClone;
        }
        if (p1.getX() > p2.getX()) {
            lineClone.setLine(p2, p1);
            return lineClone;
        }
        if (p1.getY() < p2.getY()) {
            return lineClone;
        }
        lineClone.setLine(p2, p1);
        return lineClone;
    }
}
