package Model;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends Shape {
    @Override
    public void paint(Graphics g) {
        int nPoints = 3;
        int[] xPoints = new int[nPoints+1];
        int[] yPoints = new int[nPoints+1];
        for(int i=0; i<nPoints; i++)
        {
            double angle = 2*Math.PI *i/nPoints;
            xPoints[i] = (int)(150 + 75*Math.sin(angle));
            yPoints[i] = (int)(100 - 40*Math.cos(angle));
        }

        g.drawPolygon(xPoints, yPoints, nPoints);

    }
}
