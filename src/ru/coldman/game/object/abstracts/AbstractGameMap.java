package ru.coldman.game.object.abstracts;

import ru.coldman.game.object.Coordinate;
import ru.coldman.game.object.enums.GameObjectType;
import ru.coldman.game.object.interfaces.InterfaceGameMaps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;

/**
 * базовая карта без конкретного отображения
 */// Serializable нужен для сериализации (сохранения) объекта карты, чтобы можно было сохранять игру и восстанавливать
public abstract class AbstractGameMap implements InterfaceGameMaps, Serializable {

    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private int timeLimit;
    private String name;
    private boolean exitExist;
    private boolean goldManExist;
    // хранит все объекты с доступом по координатам
    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();
    // хранит список объектов для каждого типа
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class);


    //метод по добавлению объектов
    public void addGameObject(AbstractGameObject gameObject) {
        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);
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

    public AbstractGameObject getPriorityObject(AbstractGameObject firstObject, AbstractGameObject secondObject) {
        // приоритет объекта зависит от номера индекса объекта enum
        if (firstObject.getType().getIndexPriority() > secondObject.getType().getIndexPriority()) {
            return firstObject;
        } else return secondObject;
    }

    public boolean isValidMap() {
        return goldManExist && exitExist; // если есть и вход и выход - карта валидна
    }

    public ArrayList<AbstractGameObject> getList(GameObjectType type) {
        return typeObjects.get(type);
    }

    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }
}
