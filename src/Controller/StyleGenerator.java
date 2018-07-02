package Controller;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class StyleGenerator {
    public static Stroke getDashedStroke() {
        float dash1[] = {10.0f};
        BasicStroke dashed =
                new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        return dashed;
    }

    public static Stroke getBasicStrokeWithWidth(int width) {
        float dash1[] = {10.0f};
        BasicStroke basic =
                new BasicStroke(width,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, null, 0.0f);
        return basic;
    }

    public static Stroke getStrokeWithType(int type, int width) {
        switch (type) {
            case 0:
                return getBasicStrokeWithWidth(width);
            case 1:
                return getDashedStroke();
            default:
                return new BasicStroke();
        }
    }
}
