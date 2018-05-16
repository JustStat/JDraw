package Model.Tools;


import java.awt.*;

public abstract class ShapeTool extends Tool {
    protected Shape shape;
    public Boolean needRepaint() {
        return shape != null;
    };
}