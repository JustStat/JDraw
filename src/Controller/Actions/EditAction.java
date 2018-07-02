package Controller.Actions;

import Controller.ShapeManager;
import Model.Shapes.Geometry.GAffineTransforms;
import Model.Shapes.Shape;

import java.util.ArrayList;

public class EditAction extends Action {
    ArrayList<double[][]> originalShapes = new ArrayList<>();
    ArrayList<double[][]> editedShapes = new ArrayList<>();
    ArrayList<Shape> sourceShapes;

    public EditAction() { }

    public void saveOriginalShapes(ArrayList<Shape> shapes) {
        try {
            originalShapes.clear();
            for (Shape shape: shapes) {
                ArrayList<double[][]> temp = shape.getShapeMatrixes();
                this.originalShapes.add(temp.get(0));
                this.originalShapes.add(temp.get(1));
                this.originalShapes.add(temp.get(2));
            }
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        this.sourceShapes = shapes;
    }

    public void saveEditedShape(ArrayList<Shape> shapes) {
        editedShapes.clear();
        try {
            for (Shape shape: shapes) {
                ArrayList<double[][]> temp = shape.getShapeMatrixes();
                this.editedShapes.add(temp.get(0));
                this.editedShapes.add(temp.get(1));
                this.editedShapes.add(temp.get(2));
            }
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    @Override
    public void redoAction() {
        for (Shape shape: sourceShapes) {
            shape.setShapeMatrixes(editedShapes);
            GAffineTransforms.applyTransformsForShape(shape);
        }
    }

    @Override
    public void undoAction() {
        for (Shape shape: sourceShapes) {
            shape.setShapeMatrixes(originalShapes);
            GAffineTransforms.applyTransformsForShape(shape);
        }
    }
}
