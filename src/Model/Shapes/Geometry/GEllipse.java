package Model.Shapes.Geometry;

import Model.Shapes.Shape;

import java.awt.*;

public class GEllipse {
    public static void drawEllipse(Shape shape, Point center, int xRadius, int yRadius, Graphics g) {
        int x, y; double xr2, yr2, d, xm;
        xr2 = Math.pow(xRadius, 2)*2;
        yr2 = Math.pow(yRadius, 2)*2;
        x = 0;
        y = yRadius;
        d = (yr2 - xr2 * y) + xr2*2;
        xm = xr2 / Math.sqrt((xr2 + yr2)*2) - 1;
        Pixel4(shape, center, x, y, g);
        while (x < xm) {
            if (d > 0) {
                --y;
                d = d + yr2*(x*2 + 3) - xr2*y*2;
            } else {
                d = d + yr2*(x*2 + 3);
            }
            x++;
            Pixel4(shape, center, x, y, g);
        }
        d = (xr2 - yr2*xRadius) + yr2*2;
        x = xRadius;
        y = 0;
        Pixel4(shape, center, x, y, g);
        xm = xm + 2;
        while (x > xm) {
            if (d > 0) {
                --x;
                d = d + xr2*(y*2+3)-yr2*x*2;
            } else {
                d = d + xr2*(y*2+3);
            }
            ++y;
            Pixel4(shape, center, x, y, g);
        }
    }

    private static void Pixel4(Shape shape, Point center, int xRadius, int yRadius, Graphics g) {
        Point p = new Point(center.x + xRadius, center.y + yRadius);
        p = GAffineTransforms.applyTransformForPoint(shape, p);
        g.drawLine(p.x, p.y, p.x, p.y);

        p = new Point(center.x + xRadius, center.y - yRadius);
        p = GAffineTransforms.applyTransformForPoint(shape, p);
        g.drawLine(p.x, p.y, p.x, p.y);

        p = new Point(center.x - xRadius, center.y + yRadius);
        p = GAffineTransforms.applyTransformForPoint(shape, p);
        g.drawLine(p.x, p.y, p.x, p.y);

        p = new Point(center.x - xRadius, center.y - yRadius);
        p = GAffineTransforms.applyTransformForPoint(shape, p);
        g.drawLine(p.x, p.y, p.x, p.y);

    }
}
