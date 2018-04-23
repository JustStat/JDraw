package View;

import Controller.ShapeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {
    private Image img;
    private Graphics buf;
    public double scale = 1;

    public Canvas() {
        img = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
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
