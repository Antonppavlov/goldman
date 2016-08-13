package ru.coldman.game.gui.child.game;


import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.gui.child.BaseChildFrame;
import ru.coldman.game.gui.main.element.Panel;
import ru.coldman.game.interfaces.gamemap.DrawableMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


    private DrawableMap gameMap; // передаем объект карты, которая умеет себя рисовать

    public GameFrame() {
        createGamePlayArea();
        createMenuBar();
        createPanelControlGame();
        createFrame();
        addListener();
    }

    private void addListener() {
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(MovingDirection.UP,GameObjectType.GOLDMAN);
            }
        });
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(MovingDirection.DOWN,GameObjectType.GOLDMAN);
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(MovingDirection.LEFT,GameObjectType.GOLDMAN);
            }
        });
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(MovingDirection.RIGHT,GameObjectType.GOLDMAN);
            }
        });
    }

    private void createGamePlayArea() {
        panelGamePlayArea = new JPanel();
        panelGamePlayArea.setBorder(BorderFactory.createEtchedBorder());
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

        btnUp.setIcon(new ImageIcon(getClass().getResource("/resources/images/up.png")));
        btnDown.setIcon(new ImageIcon(getClass().getResource("/resources/images/down.png")));
        btnLeft.setIcon(new ImageIcon(getClass().getResource("/resources/images/left.png")));
        btnRight.setIcon(new ImageIcon(getClass().getResource("/resources/images/right.png")));

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
        btnSave.setIcon(new ImageIcon(getClass().getResource("/resources/images/save.png"))); // NOI18N
        btnExit = new ru.coldman.game.gui.main.element.Button("Exit game");
        btnExit.setIcon(new ImageIcon(getClass().getResource("/resources/images/exit.png"))); // NOI18N


        panelGamePanel = new JPanel();
        panelGamePanel.setLayout(new BoxLayout(panelGamePanel, BoxLayout.Y_AXIS));
        panelGamePanel.add(panelControlGame);
        panelGamePanel.add(panelScore);
        panelGamePanel.add(panelTurns);
        panelGamePanel.add(new Panel(btnSave));
        panelGamePanel.add(new Panel(btnExit));
    }


    private void createFrame() {
        this.setJMenuBar(menuBar);
        setLayout(new FlowLayout());
        getContentPane().add(panelGamePlayArea);
        getContentPane().add(panelGamePanel);
    }

    public void setMap(DrawableMap gameMap) {
        this.gameMap = gameMap;
        gameMap.drawMap();

        panelGamePlayArea.removeAll();
        panelGamePlayArea.add(gameMap.getMapComponent());
    }




    private void move(MovingDirection movingDirection, GameObjectType gameObjectType) {
        gameMap.getGameMap().move(movingDirection, gameObjectType);
        gameMap.drawMap();
    }
    }

