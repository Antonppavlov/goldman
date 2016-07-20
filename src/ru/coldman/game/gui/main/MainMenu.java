package ru.coldman.game.gui.main;


import ru.coldman.game.gui.child.game.GameFrame;
import ru.coldman.game.gui.child.load.LoadGameFrame;
import ru.coldman.game.gui.child.statistic.StatisticFrame;
import ru.coldman.game.gui.main.element.Button;
import ru.coldman.game.gui.main.element.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Антон on 16.07.2016.
 */
public class MainMenu extends JFrame {

    private final Button btnNewGame;
    private final Button btnLoadGame;
    private final Button btnStatistics;
    private final Button btnExit;

    private final GameFrame gameFrame;
    private final StatisticFrame statisticFrame;
    private final LoadGameFrame loadGameFrame;

    public MainMenu() {
        this.btnNewGame = new Button("New game");
        btnNewGame.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/new.png"))); // NOI18N
        this.btnLoadGame = new Button("Load game");
        btnLoadGame.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/load.png"))); // NOI18N

        this.btnStatistics = new Button("Statistics");
        btnStatistics.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/stat.png"))); // NOI18N

        this.btnExit = new Button("Exit");
        btnExit.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/exit.png"))); // NOI18N

        createWindows();

        gameFrame = new GameFrame();
        statisticFrame = new StatisticFrame();
        loadGameFrame = new LoadGameFrame();
        addListenerButton();
    }

    private void createWindows() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new Panel(btnNewGame));
        panel.add(new Panel(btnLoadGame));
        panel.add(new Panel(btnStatistics));
        panel.add(new Panel(btnExit));

        getContentPane().add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addListenerButton() {
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNewGame();
            }
        });
        btnLoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLoadGame();
            }

        });

        btnStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStatistics();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                //
                //  Object[] options = { "Yes", "No" };
                //  JOptionPane.showOptionDialog(null, "Exit game?",
                //          "", JOptionPane.YES_NO_OPTION,
                //          JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//
                //  this.setVisible(false);
                System.exit(0);
            }
        });
    }


    private void btnStatistics() {
        statisticFrame.showFrame(this);
    }

    private void btnLoadGame() {
        loadGameFrame.showFrame(this);
    }

    private void btnNewGame() {
        gameFrame.showFrame(this);
    }
}
