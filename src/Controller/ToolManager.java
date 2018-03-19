package Controller;

import Model.*;

import javax.tools.Tool;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ToolManager {
    public Class currentToolClass;
    public Model.Tool currentTool = new RectangleTool();
    public ArrayList<Model.Tool> tools = new ArrayList<>();

    public void mousePressed(MouseEvent e) {
        tools.add(currentTool);
        currentTool.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        currentTool.mouseReleased(e);
    }


    public void mouseDragged(MouseEvent e, Graphics g) {
        if ((currentTool instanceof ShapeTool) && ((IDraggable) currentTool).isDragging()) {
            return;
        }
        currentTool.mouseDragged(e, g);

    }

    public void mouseMoved(MouseEvent e) {
//        currentTool.mouseMoved(e);
    }


    public void paintCurrent(Graphics g) {
        if (currentTool instanceof ShapeTool) {
            ((ShapeTool) currentTool).paintShape(g);
        }
    }
}
