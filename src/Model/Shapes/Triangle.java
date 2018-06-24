package Model.Shapes;

import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Geometry.GLine;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;

public class Triangle extends Shape {
    @Override
    public void paint(Graphics g) {
        int nPoints = 3;
        ArrayList<Point> tPoints = new ArrayList<>(Collections.nCopies(nPoints, new Point(0, 0)));
        for(int i=0; i<nPoints; i++)
        {
            double angle = 2*Math.PI *i/nPoints;
            tPoints.get(i).x = (int)(corePoints.get(0).x + (corePoints.get(1).x - corePoints.get(0).x)*Math.sin(angle));
            tPoints.get(i).y = (int)(corePoints.get(0).y - (corePoints.get(1).x - corePoints.get(0).x)*Math.cos(angle));

            tPoints.set(i, GAffineTransforms.applyTransformForPoint(this, tPoints.get(i)));
        }

        for (int i = 0; i < nPoints - 1; i++) {
            GLine.drawLine(tPoints.get(i).x, tPoints.get(i).y, tPoints.get(i+1).x, tPoints.get(i+1).y, g);
        }
        GLine.drawLine(tPoints.get(nPoints - 1).x, tPoints.get(nPoints - 1).y, tPoints.get(0).x, tPoints.get(0).y, g);

    }

    @Override
    public String getName() {
        return "Треугольник";
    }
}
