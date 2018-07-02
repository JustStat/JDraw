package Controller.Actions;

import Controller.ShapeManager;
import Model.Shapes.Shape;

public class RemoveAction extends Action {
    public RemoveAction(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void redoAction() {
        ShapeManager.getInstance().shapes.remove(shape);
    }

    @Override
    public void undoAction() {
        ShapeManager.getInstance().shapes.add(shape);
    }
}
