package Model.Tools;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Tool {

    public abstract void mousePressed(MouseEvent e);

    public abstract void mouseReleased(MouseEvent e);

    public abstract void mouseDragged(MouseEvent e, Graphics g);

    public abstract void mouseMoved(MouseEvent e, Graphics g);
}
