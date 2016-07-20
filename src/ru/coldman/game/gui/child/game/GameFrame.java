package ru.coldman.game.gui.child.game;


import ru.coldman.game.gui.child.BaseChildFrame;
import ru.coldman.game.gui.main.element.Panel;
import ru.coldman.game.object.objects.maps.FSGameMap;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Антон on 16.07.2016.
 */
public class GameFrame extends BaseChildFrame {

    private JMenu menuFile;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemExitGame;
    private JMenu menuService;
    private JMenuItem menuItemStatistics;
    private JMenuBar menuBar;


    private JPanel panelGamePlayArea;

    private JButton btnUp;
    private JButton btnDown;
    private JButton btnLeft;
    private JButton btnRight;

    private JLabel textScoreText;
    private JLabel textScore;
    private JLabel textTurnsLeftText;
    private JLabel textTurnsLeft;
    private JButton btnSave;
    private JButton btnExit;
    private JPanel panelGamePanel;


    private  FSGameMap fsGameMap;
    public GameFrame() {
        createGamePlayArea();
        createMenuBar();
        createPanelControlGame();
        createFrame();
        loadGame("C:\\Users\\Антон\\IdeaProjects\\goldman\\goldman\\src\\resources\\game.txt");
    }

    private void loadGame(String pathToFile) {
        fsGameMap=new FSGameMap();
        fsGameMap.loadMap(pathToFile);
    }


    private void createFrame() {
        this.setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        getContentPane().add(panelGamePlayArea);
        getContentPane().add(panelGamePanel);
    }

    private void createGamePlayArea() {
        panelGamePlayArea = new JPanel();
        panelGamePlayArea.setPreferredSize(new Dimension(300, 300));
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuItemSave = new JMenuItem("Save game");
        menuItemExitGame = new JMenuItem("Exit game");
        menuFile.add(menuItemSave);
        menuFile.add(menuItemExitGame);

        menuService = new JMenu("Service");
        menuItemStatistics = new JMenuItem("Statistics");
        menuService.add(menuItemStatistics);

        menuBar.add(menuFile);
        menuBar.add(menuService);

    }

    private void createPanelControlGame() {
        btnUp = new JButton();
        btnUp.setPreferredSize(new Dimension(40, 40));
        btnDown = new JButton();
        btnDown.setPreferredSize(new Dimension(40, 40));
        btnLeft = new JButton();
        btnLeft.setPreferredSize(new Dimension(40, 40));
        btnRight = new JButton();
        btnRight.setPreferredSize(new Dimension(40, 40));

        btnUp.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/up.png")));
        btnDown.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/down.png")));
        btnLeft.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/left.png")));
        btnRight.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/right.png")));

        JPanel panelControlGame = new JPanel();
        panelControlGame.setLayout(new BorderLayout());
        panelControlGame.add(new Panel(btnUp), BorderLayout.NORTH);
        panelControlGame.add(new Panel(btnRight), BorderLayout.EAST);
        panelControlGame.add(new Panel(btnLeft), BorderLayout.WEST);
        panelControlGame.add(new Panel(btnDown), BorderLayout.SOUTH);

        textScoreText = new JLabel("Score:");
        textScore = new JLabel("0");
        Panel panelScore = new Panel();
        panelScore.add(textScoreText);
        panelScore.add(textScore);
        textTurnsLeftText = new JLabel("Left turns:");
        textTurnsLeft = new JLabel("0");
        Panel panelTurns = new Panel();
        panelScore.add(textTurnsLeftText);
        panelScore.add(textTurnsLeft);

        btnSave = new ru.coldman.game.gui.main.element.Button("Save");
        btnSave.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/save.png"))); // NOI18N
        btnExit = new ru.coldman.game.gui.main.element.Button("Exit game");
        btnExit.setIcon(new ImageIcon(getClass().getResource("/ru/coldman/game/images/exit.png"))); // NOI18N


        panelGamePanel = new JPanel();
        panelGamePanel.setLayout(new BoxLayout(panelGamePanel, BoxLayout.Y_AXIS));
        panelGamePanel.add(panelControlGame);
        panelGamePanel.add(panelScore);
        panelGamePanel.add(panelTurns);
        panelGamePanel.add(new Panel(btnSave));
        panelGamePanel.add(new Panel(btnExit));
    }



}
