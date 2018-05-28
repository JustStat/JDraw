package Model.Shapes;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public abstract class Shape {
    public ArrayList<Point> corePoints;
    public ArrayList<Point> points;
    public double[][] affineMatrixTranslation;
    public double[][] affineMatrixRotation;
    public double[][] affineMatrixScale;


    public abstract void paint(Graphics g);
    public abstract Rectangle2D getBounds();
}