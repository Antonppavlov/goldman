package ru.coldman.game.gui.child;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class BaseChildFrame extends JFrame {

    public BaseChildFrame() {
        setCloseOperation();
    }

    private JFrame parentFrame;

    public JFrame getParentFrame() {
        return parentFrame;
    }

    public void showFrame(JFrame parent) {
        this.parentFrame = parent;
        parent.setVisible(false);

        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        // setResizable(false);
        super.setVisible(true);
    }

    protected void closeFrame() {
        if (parentFrame == null) {
            throw new IllegalArgumentException("parent frame must not be null!");
        }
        super.setVisible(false);
        parentFrame.setVisible(true);

    }

    protected void setCloseOperation() {
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });

    }

}
