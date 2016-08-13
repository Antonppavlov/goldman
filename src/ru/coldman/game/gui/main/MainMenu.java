package ru.coldman.game.gui.main;


import ru.coldman.game.enums.LocationType;
import ru.coldman.game.gui.child.game.GameFrame;
import ru.coldman.game.gui.child.game.maps.JTableGameMap;
import ru.coldman.game.gui.child.load.LoadGameFrame;
import ru.coldman.game.gui.child.statistic.StatisticFrame;
import ru.coldman.game.gui.main.element.Button;
import ru.coldman.game.gui.main.element.Panel;
import ru.coldman.game.objects.maps.MapCollection;

import javax.swing.*;
import java.awt.*;
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

    private GameFrame gameFrame;
    private StatisticFrame statisticFrame;
    private LoadGameFrame loadGameFrame;

    private JTableGameMap gameMap = new JTableGameMap(LocationType.FS, "src/resources/maps/game.txt", new MapCollection());

    public MainMenu() {
        this.btnNewGame = new Button("New game");
        btnNewGame.setIcon(new ImageIcon(getClass().getResource("/resources/images/new.png"))); // NOI18N
        this.btnLoadGame = new Button("Load game");
        btnLoadGame.setIcon(new ImageIcon(getClass().getResource("/resources/images/load.png"))); // NOI18N

        this.btnStatistics = new Button("Statistics");
        btnStatistics.setIcon(new ImageIcon(getClass().getResource("/resources/images/stat.png"))); // NOI18N

        this.btnExit = new Button("Exit");
        btnExit.setIcon(new ImageIcon(getClass().getResource("/resources/images/exit.png"))); // NOI18N

        createWindows();


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

        setPreferredSize(new Dimension(270, 250));
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
                System.exit(0);
            }
        });
    }


    private void btnStatistics() {
        statisticFrame = new StatisticFrame();
        statisticFrame.showFrame(this);
    }

    private void btnLoadGame() {
        loadGameFrame = new LoadGameFrame();
        loadGameFrame.showFrame(this);
    }

    private void btnNewGame() {
        gameFrame = new GameFrame();
        gameFrame.setMap(gameMap);
        gameFrame.showFrame(this);
    }
}
