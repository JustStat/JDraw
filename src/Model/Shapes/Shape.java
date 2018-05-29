package Model.Shapes;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Shape {
    public ArrayList<Point> corePoints;
    public ArrayList<Point> points;
    public double[][] affineMatrixTranslation;
    public double[][] affineMatrixRotation;
    public double[][] affineMatrixScale;


    public void paint(Graphics g) {}

    public Rectangle2D getBounds() {
        double x1, y1, x2, y2;
        int i = points.size();
        if (i > 0) {
            y1 = y2 = points.get(--i).y;
            x1 = x2 = points.get(i).x;
            while (i > 0) {
                double y = points.get(--i).y;
                double x = points.get(i).x;
                if (x < x1) x1 = x;
                if (y < y1) y1 = y;
                if (x > x2) x2 = x;
                if (y > y2) y2 = y;
            }
        } else {
            x1 = y1 = x2 = y2 = 0.0;
        }

        return new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
    }
}