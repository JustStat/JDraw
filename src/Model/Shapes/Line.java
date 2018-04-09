package Model.Shapes;

import java.awt.*;

public class Line extends Shape {
    @Override
    public void paint(Graphics g) {
        g.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y);
    }
}
