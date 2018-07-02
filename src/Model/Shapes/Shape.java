package Model.Shapes;


import Controller.ShapeManager;
import Controller.StyleGenerator;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Shape implements Cloneable {
    public ArrayList<Point> corePoints;
    public ArrayList<Point> points;
    public double[][] affineMatrixTranslation;
    public double[][] affineMatrixRotation;
    public double[][] affineMatrixScale;
    public Color strokeColor = null;
    public int strokeType = -1;
    public int strokeWidth = -1;

    public void paint(Graphics g) {
        g.setColor(this.strokeColor);
        if (strokeType < 0) {
            strokeType = ShapeManager.getInstance().currentStrokeType;
        }
        if (strokeColor == null) {
            strokeColor = ShapeManager.getInstance().currentStrokeColor;
        }
        if (strokeWidth < 0) {
            strokeWidth = ShapeManager.getInstance().currentStrokeSize;
        }
        ((Graphics2D)g).setStroke(StyleGenerator.getStrokeWithType(this.strokeType, this.strokeWidth));
    }

    public Rectangle2D getBounds() {
        double x1, y1, x2, y2;
        int i = points.size();
        if (i > 0) {
            y1 = y2 = points.get(--i).y;
            x1 = x2 = points.get(i).x;
            while (i > 0) {
                double y = points.get(--i).y;
                double x = points.get(i).x;
                if (x < x1) x1 = x;
                if (y < y1) y1 = y;
                if (x > x2) x2 = x;
                if (y > y2) y2 = y;
            }
        } else {
            x1 = y1 = x2 = y2 = 0.0;
        }

        return new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
    }

    public String getName() {
        return "Unknown";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public ArrayList<double[][]> getShapeMatrixes() {
        ArrayList<double[][]> matrixes = new ArrayList<>(3);
        double[][] temp = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = affineMatrixTranslation[i][j];
            }
        }
        matrixes.add(temp);
        temp = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = affineMatrixRotation[i][j];
            }
        }
        matrixes.add(temp);
        temp = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = affineMatrixScale[i][j];
            }
        }
        matrixes.add(temp);
        return matrixes;
    }

    public void setShapeMatrixes(ArrayList<double[][]> matrixes) {
        double[][] temp = matrixes.get(0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                affineMatrixTranslation[i][j] = temp[i][j];
            }
        }
        temp = matrixes.get(1);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                affineMatrixRotation[i][j] = temp[i][j];
            }
        }
        temp = matrixes.get(2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                affineMatrixScale[i][j] = temp[i][j];
            }
        }
    }
}