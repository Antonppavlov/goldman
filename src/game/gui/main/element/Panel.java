package ru.coldman.game.gui.main.element;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Антон on 16.07.2016.
 */
public class Panel extends JPanel {

    public Panel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public Panel(JComponent component) {
        this();
        add(component);
    }

}
