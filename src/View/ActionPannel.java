package View;

import Controller.Actions.ActionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPannel extends JPanel {
    public ActionPannel(MainForm form) {
        setLayout(new GridLayout(1, 3));
        JButton undo = new JButton();
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionManager.getInstance().undoAction();
                form.updateCanvas();
            }
        });
        this.add(undo);

        JButton redo = new JButton();
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionManager.getInstance().redoAction();
                form.updateCanvas();
            }
        });
        this.add(redo);
    }
}
