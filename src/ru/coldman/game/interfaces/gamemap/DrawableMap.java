package ru.coldman.game.interfaces.gamemap;

import ru.coldman.game.abstracts.AbstractGameMap;

import java.awt.*;

public interface DrawableMap {

    Component getMapComponent();

    AbstractGameMap getGameMap();

    boolean drawMap();

}
