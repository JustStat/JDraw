package Model.Shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;


public class Ellipse extends Ellipse2D.Double implements IEditable {
    @Override
    public Shape resizeShape(int index, Point point) {
        final RectangularShape retval = (RectangularShape) this.clone();
        if (index == 0) {
            retval.setFrame(point.x, point.y, this.width + (this.x - point.x), this.height + (this.y - point.y));
        } else {
            retval.setFrame(retval.getX(), retval.getY(), point.getX()  - this.x, point.getY() - this.y);
        }
        return retval;
    }

    public Shape rotateShape( final double theta, Point center) {
        final Rectangle2D bounds = this.getBounds2D();
        AffineTransform af = AffineTransform.getTranslateInstance(0 - bounds.getX(), 0 - bounds.getY());
        // apply normalisation translation ...
        Shape s = af.createTransformedShape(this);

        af = AffineTransform.getRotateInstance(Math.toRadians(theta*57), center.getX(), center.getY());
        // apply scaling ...
        s = af.createTransformedShape(s);

        // now retranslate the shape to its original position ...
        af = AffineTransform.getTranslateInstance(bounds.getX(), bounds.getY());
        return af.createTransformedShape(s);
    }
}
