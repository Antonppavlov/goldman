package ru.coldman.game.gui.child.load;

import ru.coldman.game.gui.child.BaseChildFrame;
import ru.coldman.game.gui.main.element.Button;
import ru.coldman.game.gui.main.element.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Антон on 16.07.2016.
 */
public class LoadGameFrame extends BaseChildFrame {

    private JScrollPane scrollPane1;
    private JTable tableGames;
    private Button btnDelete;
    private Button btnLoadGame;
    private Button btnReturn;


    public LoadGameFrame() {
        btnReturn = new Button("<< Return to menu");
        btnLoadGame=new Button("Load game");
        btnDelete=new Button("Delete");

        tableGames = new JTable();
        scrollPane1 = new JScrollPane();

        createButton();
        createTable();
        createFrame();
        addListener();

    }

    private void createButton(){
        btnLoadGame.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/load_small.png"))); // NOI18N
        btnDelete.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/delete.png"))); // NOI18N

    }

    private void createTable(){
        tableGames.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        scrollPane1.setViewportView(tableGames);


    }

    private void createFrame(){
        JPanel panel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(btnLoadGame);
        panel.add(btnDelete);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel2.add(btnReturn);

        setLayout(new BorderLayout());
        getContentPane().add(panel2,BorderLayout.NORTH);
        getContentPane().add(scrollPane1,BorderLayout.CENTER);
        getContentPane().add(panel,BorderLayout.SOUTH);
    }

    private void addListener(){
        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnReturnListener();
            }
        });
    }

    private void btnReturnListener(){
        this.closeFrame();
    }
}
