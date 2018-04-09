package Model.Shapes;


import java.awt.*;
import java.util.ArrayList;

public abstract class Shape {
    public ArrayList<Point> points;

    public abstract void paint(Graphics g);
}