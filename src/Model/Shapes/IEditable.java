package Model.Shapes;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public interface IEditable {
    AffineTransform transform = new AffineTransform();
    Shape resizeShape(int index, Point point);
    public Shape rotateShape( final double theta, Point center);
}