package ru.coldman.game.utils;

import javax.swing.*;
import java.awt.*;

public class MessageManager {

    public static void aVoid(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Message Dialog", JOptionPane.PLAIN_MESSAGE);
    }
}
