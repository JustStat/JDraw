package View;

import Controller.ShapeManager;
import Controller.StyleGenerator;
import Model.Shapes.Shape;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class PropertyPanel extends JPanel {
    
    private JScrollPane shapeListScroll = new JScrollPane();
    private JList shapeList = new JList();
    private DefaultListModel<String> shapeListModel = new DefaultListModel<>();
    private JPanel linePropPanel = new JPanel();
    private JLabel linePropLabel = new JLabel();
    private JComboBox<String> comboLineType = new JComboBox<>();
    private JPanel fillPropPanel = new JPanel();
    private JLabel fillPropLabel = new JLabel();
    private JComboBox comboFillType = new JComboBox();
    private JPanel lineSizePropPanel = new JPanel();
    private JLabel lineSizePropLabel = new JLabel();
    private JSpinner spinnerLineSize = new JSpinner();
    private JPanel emptyPanel = new JPanel();
    private WeakReference<MainForm> form;
    private boolean selectedByUser = true;

    public PropertyPanel(MainForm form) {
        this.setPreferredSize(new Dimension(100, 200));
        this.setMaximumSize(new Dimension(100, 32767));
        this.setLayout(new GridLayout(5, 1));

        //======== scrollPane1 ========
        {
            shapeListScroll.setViewportView(shapeList);
            shapeList.setModel(shapeListModel);
            shapeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            shapeList.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (selectedByUser) {
                        int[] selInds = shapeList.getSelectedIndices();
                        ShapeManager.getInstance().selectedShapes.clear();
                        for (Integer index:selInds) {
                            if (index < 0) continue;
                            Shape shape = ShapeManager.getInstance().shapes.get(index);
                            ShapeManager.getInstance().selectedShapes.add(shape);
                        }
                    }
                    form.updateCanvas();
                }
            });

        }
        this.add(shapeListScroll);

        //======== panel2 ========
        {
            linePropPanel.setLayout(new GridLayout(2, 1));

            //---- label1 ----
            linePropLabel.setText("\u0422\u0438\u043f \u043b\u0438\u043d\u0438\u0438");
            linePropPanel.add(linePropLabel);

            //---- comboLineType ----
            comboLineType.setModel(new DefaultComboBoxModel<>(new String[] {
                    "______",
                    "------",
                    "_._._._"
            }));
            comboLineType.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Shape shape: ShapeManager.getInstance().selectedShapes) {
                        shape.strokeType = comboLineType.getSelectedIndex();
                    }
                    ShapeManager.getInstance().currentStrokeType = comboLineType.getSelectedIndex();
                }
            });
            linePropPanel.add(comboLineType);
        }
        this.add(linePropPanel);

        //======== panel3 ========
        {
            fillPropPanel.setLayout(new GridLayout(2, 1));

            //---- label2 ----
            fillPropLabel.setText("\u0422\u0438\u043f \u0437\u0430\u043b\u0438\u0432\u043a\u0438");
            fillPropPanel.add(fillPropLabel);
            fillPropPanel.add(comboFillType);
        }
        this.add(fillPropPanel);

        //======== panel4 ========
        {
            lineSizePropPanel.setLayout(new GridLayout(2, 1));

            //---- label3 ----
            lineSizePropLabel.setText("\u0422\u043e\u043b\u0449\u0438\u043d\u0430 \u043b\u0438\u043d\u0438\u0438");
            lineSizePropPanel.add(lineSizePropLabel);

            //---- spinnerLineSize ----
            spinnerLineSize.setModel(new SpinnerNumberModel(1, 1, 100, 1));
            spinnerLineSize.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    for (Shape shape: ShapeManager.getInstance().selectedShapes) {
                        shape.strokeWidth = (Integer)spinnerLineSize.getValue();
                    }
                    ShapeManager.getInstance().currentStrokeSize = (Integer)spinnerLineSize.getValue();
                    form.updateCanvas();
                }
            });
            lineSizePropPanel.add(spinnerLineSize);
        }
        this.add(lineSizePropPanel);

        //======== panel5 ========
        {
            emptyPanel.setLayout(new GridLayout(1, 1));
        }
        this.add(emptyPanel);
        this.form = new WeakReference<>(form);

    }

    public void updateShapeList() {
        selectedByUser = false;
        ArrayList<Integer> indexes = new ArrayList<>();
        shapeListModel.removeAllElements();
        for (Shape shape: ShapeManager.getInstance().shapes) {
            shapeListModel.addElement(shape.getName());
            if (ShapeManager.getInstance().selectedShapes.contains(shape)) {
                int index = ShapeManager.getInstance().shapes.indexOf(shape);
                indexes.add(index);
            }
        }
        shapeList.setSelectedIndices(indexes.stream().mapToInt(i -> i).toArray());
        selectedByUser = true;
    }
}
