package ru.coldman.game.interfaces.map;

/**
 * интерфейс для игровой карты
 */
public interface InterfaceGameMap {

    int getHeight();

    int getWidth();

    int getTimeLimit();

    boolean loadMap(Object source);

    boolean saveMap(Object source);


}
