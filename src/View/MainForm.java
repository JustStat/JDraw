/*
 * Created by JFormDesigner on Sat Mar 17 14:16:46 VLAT 2018
 */

package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.*;

import Controller.ToolManager;
import Model.Line;
import Model.LineTool;
import Model.ShapeManager;
import Model.Tool;
import net.miginfocom.swing.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author unknown
 */
public class MainForm extends JFrame {
    public ToolManager toolManager = new ToolManager();
    public MainForm() {
        initComponents();

        imagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                toolManager.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                toolManager.mouseReleased(e);
            }
        });
        imagePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                toolManager.mouseDragged(e, getGraphics());
                imagePanel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                toolManager.mouseMoved(e);
            }
        });
        toolBar.add(new ToolButton(LineTool.class,"resources/Line.png",this));

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kirill VVV
        dialogPane = new JPanel();
        toolBar = new JToolBar();
        imagePanel = new JPanel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                ShapeManager.getInstance().paintAll(g);
            }
        };

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== toolBar ========
            {
                toolBar.setOrientation(SwingConstants.VERTICAL);
                toolBar.setMaximumSize(new Dimension(50, 46));
                toolBar.setMinimumSize(new Dimension(50, 46));
                toolBar.setOpaque(false);
                toolBar.setPreferredSize(new Dimension(50, 46));
            }
            dialogPane.add(toolBar, BorderLayout.WEST);

            //======== imagePanel ========
            {
                imagePanel.setBackground(Color.white);
                imagePanel.setMinimumSize(new Dimension(52, 52));
                imagePanel.setLayout(new BorderLayout());
            }
            dialogPane.add(imagePanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kirill VVV
    private JPanel dialogPane;
    private JToolBar toolBar;
    private JPanel imagePanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}