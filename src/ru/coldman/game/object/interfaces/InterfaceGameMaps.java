package ru.coldman.game.object.interfaces;

/**
 * интерфейс для игровой карты
 */
public interface InterfaceGameMaps {

    int getHeight();

    int getWidth();

    boolean loadMap(Object source);

    boolean saveMap(Object source);

    boolean drawMap();

    int getTimeLimit();

}
