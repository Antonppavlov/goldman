package ru.coldman.game.interfaces.map;

import ru.coldman.game.abstracts.AbstractGameMap;

import java.awt.*;

/**
 * Интерфейс для отрисовки карты
 */
public interface InterfaceDrawableGameMap {

    Component getMap();

    AbstractGameMap getGameMap();

    boolean drawMap();


}
