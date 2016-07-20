package ru.coldman.game.gui.child.game.maps;

import ru.coldman.game.abstracts.AbstractGameObject;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        lbl.setText(null);
        AbstractGameObject value1 = (AbstractGameObject) value;
        lbl.setIcon(value1.getIcon());
        
        return lbl;
    }
}