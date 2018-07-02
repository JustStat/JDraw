package Controller.Actions;

import Model.Shapes.Shape;

public abstract class Action {
    protected Shape shape;
    public abstract void redoAction();
    public abstract void undoAction();
}
