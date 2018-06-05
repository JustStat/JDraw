package View;

import Controller.ShapeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private Image img;
    private Graphics buf;

    public Canvas() {
        img = new BufferedImage(2500, 2500, BufferedImage.TYPE_INT_ARGB);
        buf = img.getGraphics();
    }

    public void draw() {
        buf.setColor(Color.WHITE);
        buf.fillRect(0,0,this.getWidth(), this.getHeight());
        buf.setColor(Color.BLACK);
        ShapeManager.getInstance().paintAll(buf);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0,this);
    }
}
