package ru.coldman.game.interfaces.map;

import ru.coldman.game.abstracts.AbstractGameMap;

import java.awt.*;

/**
 * Интерфейс для отрисовки карты
 */
public interface IDrawableGameMap {

    Component getMap();

    AbstractGameMap getGameMap();

    boolean drawMap();


}
