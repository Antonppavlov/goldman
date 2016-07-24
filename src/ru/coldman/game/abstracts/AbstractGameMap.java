package ru.coldman.game.abstracts;

import ru.coldman.game.collections.GameCollection;
import ru.coldman.game.interfaces.map.InterfaceGameMap;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * базовый функционал для заполнения массивов из какого-то источника
 * далее из этих массивов будет заполнена карта
 */
// Serializable нужен для сериализации (сохранения) объекта карты, чтобы можно было сохранять игру и восстанавливать
public abstract class AbstractGameMap implements InterfaceGameMap, Serializable {

    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private int timeLimit;
    private String name;
    private boolean exitExist;
    private boolean goldManExist;
    // хранит все объекты с доступом по координатам
    // хранит список объектов для каждого типа
    private GameCollection gameCollection;

    public AbstractGameMap(GameCollection gameCollection){
        this.gameCollection=gameCollection;
    }


    public GameCollection getGameCollection() {
        if (gameCollection == null)
            try {
                throw new Exception("Game collection not initialized!");
            } catch (Exception ex) {
                Logger.getLogger(AbstractGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        return gameCollection;
    }

    public void setGameCollection(GameCollection gameCollection) {
        this.gameCollection = gameCollection;
    }



    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        // приоритет объекта зависит от номера индекса объекта enum
        if (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) {
            return firstObject;
        } else return secondObject;
    }


    public boolean isExitExist() {
        return exitExist;
    }

    public void setExitExist(boolean isExitExist) {
        this.exitExist = isExitExist;
    }

    public boolean isGoldManExist() {
        return goldManExist;
    }

    public void setGoldManExist(boolean isGoldManExist) {
        this.goldManExist = isGoldManExist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }


    public boolean isValidMap() {
        return goldManExist && exitExist; // если есть и вход и выход - карта валидна
    }

}
