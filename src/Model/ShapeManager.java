package Model;

import java.awt.*;
import java.util.ArrayList;

public class ShapeManager {

    public ArrayList<Shape> shapes = new ArrayList<>();

    private static ShapeManager instance;

    public static synchronized ShapeManager getInstance() {
        if (instance == null) {
            instance = new ShapeManager();
        }
        return instance;
    }

    public void paintAll(Graphics g) {
        for (Model.Shape shape:shapes) {
                shape.paint(g);

        }
    }
}
