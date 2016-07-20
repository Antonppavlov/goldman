package ru.coldman.game.gui.child.statistic;

import ru.coldman.game.gui.child.BaseChildFrame;
import ru.coldman.game.gui.main.element.Button;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StatisticFrame extends BaseChildFrame {

    private final Button btnReturn;
    private final JScrollPane scrollPaneTableStat;
    private final JTable tableStat;

    public StatisticFrame() {
        this.btnReturn = new Button("<< Return");
        this.scrollPaneTableStat = new JScrollPane();
        this.tableStat = new JTable();
        this.createButton();
        this.createTable();
        this.createFrame();

        addListener();
    }

    public void createButton() {

    }

    public void createTable() {
        tableStat.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPaneTableStat.setViewportView(tableStat);
    }

    public void createFrame() {

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(btnReturn);

        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(scrollPaneTableStat, BorderLayout.CENTER);

        this.setPreferredSize(new Dimension(500, 300));
        this.setMinimumSize(getPreferredSize());
        this.setLocationByPlatform(true);
        this.setLocationRelativeTo(null);
    }


    private void addListener() {
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnReturnListener();
            }
        });
    }

    private void btnReturnListener() {
        this.closeFrame();
    }
}
