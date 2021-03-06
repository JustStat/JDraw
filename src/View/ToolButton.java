package View;

import Model.Tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.net.URL;

public class ToolButton extends JButton {
    public ToolButton(Class<?> toolClass, String iconPath, MainForm form) {
        try {
            URL imgUrl = getClass().getResource(iconPath);
            setIcon(new ImageIcon(imgUrl, "Line"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Constructor c = toolClass.getConstructor();
                    Object obj = c.newInstance();
                    form.toolManager.currentTool = (Tool) obj;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        setBackground(Color.RED);
        setPreferredSize(new Dimension(50, 50));
    }
}
