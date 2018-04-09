package Model.Shapes;

import java.awt.*;

public class Triangle extends Shape {
    @Override
    public void paint(Graphics g) {
        int nPoints = 3;
        int[] xPoints = new int[nPoints+1];
        int[] yPoints = new int[nPoints+1];
        for(int i=0; i<nPoints; i++)
        {
            double angle = 2*Math.PI *i/nPoints;
            xPoints[i] = (int)(points.get(0).x + (points.get(1).x - points.get(0).x)*Math.sin(angle));
            yPoints[i] = (int)(points.get(0).y - (points.get(1).x - points.get(0).x)*Math.cos(angle));
        }

        g.drawPolygon(xPoints, yPoints, nPoints);

    }
}
