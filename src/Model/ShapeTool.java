package Model;

import java.awt.*;

public abstract class ShapeTool extends Tool {
    protected Shape shape;
    public abstract void paintShape(Graphics g);
}