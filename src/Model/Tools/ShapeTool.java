package Model.Tools;

import Model.Shapes.Shape;

public abstract class ShapeTool extends Tool {
    public Shape shape;
    public Boolean needRepaint() {
        return shape != null;
    };
}