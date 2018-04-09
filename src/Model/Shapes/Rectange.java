package Model.Shapes;

import java.awt.*;

import static java.lang.Math.abs;

public class Rectange extends Shape {

    @Override
    public void paint(Graphics g) {
        g.drawRect(points.get(0).x, points.get(0).y,  points.get(1).x - points.get(0).x, points.get(1).y - points.get(0).y);
    }
}
