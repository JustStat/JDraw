package Model.Shapes;

import java.awt.*;

public class Polygon extends Shape {
    @Override
    public void paint(Graphics g) {
        int[] pointsX = new int[points.size()];
        int[] pointsY = new int[points.size()];
        for (int i = 0; i < points.size(); i++) {
            pointsX[i] = points.get(i).x;
            pointsY[i] = points.get(i).y;
        }
        g.drawPolygon(pointsX, pointsY, points.size());
    }
}
