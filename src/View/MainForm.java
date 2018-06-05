/*
 * Created by JFormDesigner on Sat Mar 17 14:16:46 VLAT 2018
 */

package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import Controller.ToolManager;
import Model.Tools.*;

/**
 * @author unknown
 */
public class MainForm extends JFrame {
    public ToolManager toolManager = ToolManager.getInstance();
    public MainForm() {
        initComponents();

        imagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                toolManager.mousePressed(e);
                if (toolManager.needRepaint()) {
                    imagePanel.draw();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                toolManager.mouseReleased(e);
                if (toolManager.needRepaint()) {
                    imagePanel.draw();
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
        imagePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                toolManager.mouseDragged(e, getGraphics());
                if (toolManager.needRepaint()) {
                    imagePanel.draw();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                toolManager.mouseMoved(e);
                if (toolManager.needRepaint()) {
                    imagePanel.draw();
                }

            }
        });
        toolBar.add(new ToolButton(LineTool.class,"/Line.png",this));
        toolBar.add(new ToolButton(RectangleTool.class, "/Rectangle.png", this));
        toolBar.add(new ToolButton(EllipseTool.class, "/Ellipse.png", this));
        toolBar.add(new ToolButton(TriangleTool.class, "/Triangle.png", this));
        toolBar.add(new ToolButton(PolylineTool.class, "/Polyline.png", this));
        toolBar.add(new ToolButton(BezierTool.class, "/Bezier.png", this));
        toolBar.add(new ToolButton(PolygonTool.class, "/Polygon.png", this));
        toolBar.add(new ToolButton(AffineTool.class, "/Transform.png", this));
        toolBar.add(new ToolButton(ScaleTool.class, "/Scale.png", this));
        toolBar.add(new ToolButton(SelectTool.class, "/Select.png", this));

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kirill Varlamov
        dialogPane = new JPanel();
        toolBar = new JToolBar();
        imagePanel = new Canvas();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        ShapeList = new JList();
        panel2 = new JPanel();
        label1 = new JLabel();
        comboLineType = new JComboBox<>();
        panel3 = new JPanel();
        label2 = new JLabel();
        comboFillType = new JComboBox();
        panel4 = new JPanel();
        label3 = new JLabel();
        spinnerLineSize = new JSpinner();
        panel5 = new JPanel();

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

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(100, 200));
                panel1.setMaximumSize(new Dimension(100, 32767));
                panel1.setLayout(new GridLayout(5, 1));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(ShapeList);
                }
                panel1.add(scrollPane1);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(2, 1));

                    //---- label1 ----
                    label1.setText("\u0422\u0438\u043f \u043b\u0438\u043d\u0438\u0438");
                    panel2.add(label1);

                    //---- comboLineType ----
                    comboLineType.setModel(new DefaultComboBoxModel<>(new String[] {
                        "______",
                        "------",
                        "_._._._"
                    }));
                    panel2.add(comboLineType);
                }
                panel1.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(2, 1));

                    //---- label2 ----
                    label2.setText("\u0422\u0438\u043f \u0437\u0430\u043b\u0438\u0432\u043a\u0438");
                    panel3.add(label2);
                    panel3.add(comboFillType);
                }
                panel1.add(panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(new GridLayout(2, 1));

                    //---- label3 ----
                    label3.setText("\u0422\u043e\u043b\u0449\u0438\u043d\u0430 \u043b\u0438\u043d\u0438\u0438");
                    panel4.add(label3);

                    //---- spinnerLineSize ----
                    spinnerLineSize.setModel(new SpinnerNumberModel(1, 1, 100, 1));
                    panel4.add(spinnerLineSize);
                }
                panel1.add(panel4);

                //======== panel5 ========
                {
                    panel5.setLayout(new GridLayout(2, 1));
                }
                panel1.add(panel5);
            }
            dialogPane.add(panel1, BorderLayout.EAST);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kirill Varlamov
    private JPanel dialogPane;
    private JToolBar toolBar;
    private Canvas imagePanel;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JList ShapeList;
    private JPanel panel2;
    private JLabel label1;
    private JComboBox<String> comboLineType;
    private JPanel panel3;
    private JLabel label2;
    private JComboBox comboFillType;
    private JPanel panel4;
    private JLabel label3;
    private JSpinner spinnerLineSize;
    private JPanel panel5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
