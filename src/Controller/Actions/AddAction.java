package Controller.Actions;

import Controller.ShapeManager;
import Model.Shapes.Shape;

public class AddAction extends Action {
    public AddAction(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void redoAction() {
        ShapeManager.getInstance().shapes.add(shape);
    }

    @Override
    public void undoAction() {
        ShapeManager.getInstance().shapes.remove(shape);
    }
}
