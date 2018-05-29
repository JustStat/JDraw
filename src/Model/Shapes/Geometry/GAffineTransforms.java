package Model.Shapes.Geometry;

import Model.Shapes.Shape;

import java.awt.*;

public class GAffineTransforms  {
    public static void moveShape(Shape shape, int tx, int ty) {

//        shape.affineMatrixTranslation = getTranslationMatrix(tx, ty);
        shape.affineMatrixTranslation[2][0] += tx/2;
        shape.affineMatrixTranslation[2][1] += ty/2;
        GAffineTransforms.applyTransformsForShape(shape);

    }

    public static void scaleShape(Shape shape, double scale) {
        Point center = getShapeCenter(shape);
        shape.affineMatrixScale = getScaleMatrix(scale, center);
        GAffineTransforms.applyTransformsForShape(shape);
    }

    public static void rotateShape(Shape shape, double theta) {
        Point center = getShapeCenter(shape);
        shape.affineMatrixRotation = getRotationMatrix(theta, center);
        GAffineTransforms.applyTransformsForShape(shape);

    }

    public static Point applyTransformForPoint(Shape shape, Point point) {
        Point tp = new Point(0,0);
        double[] pv = new double[3];
        pv[0] = point.x;
        pv[1] = point.y;
        pv[2] = 1;

        double[][] tm = getShapeTransformMatrix(shape);

        double[] dpv = new double[3];
        final int rowCount = 1;             // Число строк результирующей матрицы.
        final int colCount = 3;         // Число столбцов результирующей матрицы.
        final int sumLength = 3;         // Число членов суммы при вычислении значения ячейки.

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                int sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += pv[i] * tm[i][col];
                dpv[col] = sum;
            }
        }
        tp.x = (int)dpv[0];
        tp.y = (int)dpv[1];

        return tp;
    }

    public static Point applyInverseTransformForPoint(Shape shape, Point point) {
        Point tp = new Point(0,0);
        double[] pv = new double[3];
        pv[0] = point.x;
        pv[1] = point.y;
        pv[2] = 1;

        double[][] tm = getInverseMatrix(getShapeTransformMatrix(shape));

        double[] dpv = new double[3];
        final int rowCount = 1;             // Число строк результирующей матрицы.
        final int colCount = 3;         // Число столбцов результирующей матрицы.
        final int sumLength = 3;         // Число членов суммы при вычислении значения ячейки.

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                int sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += pv[i] * tm[i][col];
                dpv[col] = sum;
            }
        }
        tp.x = (int)dpv[0];
        tp.y = (int)dpv[1];

        return tp;
    }

    public static void normalizeShape(Shape shape) {
        double[][] nm = new double[3][3];
        nm[0][0] = 1;
        nm[1][1] = 1;
        nm[2][2] = 1;
        shape.affineMatrixTranslation = nm;
        shape.affineMatrixRotation = nm;
        shape.affineMatrixScale = nm;
    }

    private static double[][] getShapeTransformMatrix(Shape shape) {
        double[][] tm = multMatrixs((multMatrixs(shape.affineMatrixRotation, shape.affineMatrixScale)), shape.affineMatrixTranslation);
        return tm;
    }

    public static void applyTransformsForShape(Shape shape) {
        int k = 0;
        for (Point point:shape.corePoints) {
            double[] pv = new double[3];
            pv[0] = point.x;
            pv[1] = point.y;
            pv[2] = 1;

            double[][] tm = getShapeTransformMatrix(shape);

            double[] dpv = new double[3];
            final int rowCount = 1;             // Число строк результирующей матрицы.
            final int colCount = 3;         // Число столбцов результирующей матрицы.
            final int sumLength = 3;         // Число членов суммы при вычислении значения ячейки.

            for (int row = 0; row < rowCount; ++row) {
                for (int col = 0; col < colCount; ++col) {
                    int sum = 0;
                    for (int i = 0; i < sumLength; ++i)
                        sum += pv[i] * tm[i][col];
                    dpv[col] = sum;
                }
            }
            shape.points.get(k).x = (int)dpv[0];
            shape.points.get(k).y = (int)dpv[1];
            k++;
        }
    }

    private static double[][] getTranslationMatrix(int tx, int ty) {
        double[][] tm = new double[3][3];
        tm[0][0] = 1;
        tm[1][1] = 1;
        tm[2][2] = 1;
        tm[2][0] = tx;
        tm[2][1] = ty;

        return tm;
    }

    private static double[][] getRotationMatrix(double theta, Point center) {
        double sin = Math.sin(theta);
        double cos = Math.cos(theta);


        double[][] rm = new double[3][3];
        rm[0][0] = cos;
        rm[0][1] = sin;
        rm[1][1] = cos;
        rm[1][0] = -sin;
        rm[2][2] = 1;

        double[][] t1 = getTranslationMatrix(-center.x, -center.y);
        double[][] t2 = getTranslationMatrix(center.x, center.y);

        return multMatrixs(multMatrixs(t1, rm), t2);

    }

    private static double[][] getScaleMatrix(double scaleFactor, Point center) {
        double[][] sm = new double[3][3];
        sm[0][0] = scaleFactor;
        sm[1][1] = scaleFactor;
        sm[2][2] = 1;

        double[][] t1 = getTranslationMatrix(-center.x, -center.y);
        double[][] t2 = getTranslationMatrix(center.x, center.y);

        return multMatrixs(multMatrixs(t1, sm), t2);
    }

    private static double[][] multMatrixs(double[][] m1, double[][] m2) {
        double[][] dpv = new double[3][3];
        final int rowCount = 3;             // Число строк результирующей матрицы.
        final int colCount = 3;         // Число столбцов результирующей матрицы.
        final int sumLength = 3;           // Число членов суммы при вычислении значения ячейки.

        for (int row = 0; row < rowCount; ++row) {
            for (int col = 0; col < colCount; ++col) {
                double sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += m1[row][i] * m2[i][col];
                dpv[row][col] = sum;
            }
        }

        return dpv;
    }

    private static double[][] getInverseMatrix(double [][]A)
    {
        double temp;

        double[][] E = new double[3][3];


        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                E[i][j] = 0f;

                if (i == j)
                    E[i][j] = 1f;
            }

        for (int k = 0; k < 3; k++)
        {
            temp = A[k][k];

            for (int j = 0; j < 3; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }

            for (int i = k + 1; i < 3; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < 3; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int k = 3 - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < 3; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        return E;

    }

    public static Point getShapeCenter(Shape shape) {
        int X = 0, Y = 0, i = 0;
        for (Point point : shape.corePoints) {
            X += point.x;
            Y += point.y;
            i++;
        }
        return new Point(X/i, Y/i);
    }

}
