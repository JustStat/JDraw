package Model.Tools;

import Model.Shapes.Shape;

public abstract class ShapeTool extends Tool {
    protected Shape shape;
    public Boolean needRepaint() {
        return shape != null;
    };
}