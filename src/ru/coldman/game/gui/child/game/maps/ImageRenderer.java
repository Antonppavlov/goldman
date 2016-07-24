package ru.coldman.game.gui.child.game.maps;

import ru.coldman.game.abstracts.AbstractGameObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        //указываем текст null
        lbl.setText(null);

        //переопределяем внешний вид отображения в ячейке
        AbstractGameObject value1 = (AbstractGameObject) value;
        lbl.setIcon(value1.getImageIcon());

        return lbl;
    }
}