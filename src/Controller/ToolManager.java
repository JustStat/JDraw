package Controller;

import Model.Tools.RectangleTool;
import Model.Tools.ShapeTool;
import Model.Tools.Tool;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ToolManager {
    public Class currentToolClass;
    public Tool currentTool = new RectangleTool();
    public ArrayList<Tool> tools = new ArrayList<>();

    private static ToolManager instance;

    public static synchronized ToolManager getInstance() {
        if (instance == null) {
            instance = new ToolManager();
        }
        return instance;
    }

    public void mousePressed(MouseEvent e) {
        tools.add(currentTool);
        currentTool.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        currentTool.mouseReleased(e);
    }


    public void mouseDragged(MouseEvent e, Graphics g) {
        currentTool.mouseDragged(e, g);

    }

    public void mouseMoved(MouseEvent e, Graphics g) {
        currentTool.mouseMoved(e, g);
    }

    public Boolean needRepaint() {
        return ((currentTool instanceof ShapeTool) && ((ShapeTool) currentTool).needRepaint());
    }
}
