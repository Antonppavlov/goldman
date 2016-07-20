package ru.coldman.game.gui.main.element;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Антон on 16.07.2016.
 */
public class Button extends JButton {
    public Button(String btnText){
        setText(btnText);
        setFont(new Font("Comic Sans MS", 0, 18)); // NOI18N

        setPreferredSize(new Dimension(150,40));
    }
}
