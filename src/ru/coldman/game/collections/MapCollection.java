package ru.coldman.game.collections;


import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class MapCollection implements GameCollection {

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// хранит все объекты с доступом по координатам
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // хранит список объектов для каждого типа

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());// ! узкое место - каждый раз создается новая коллекция
    }
    
    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return gameObjects.get(coordinate);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    //метод по добавлению объектов
    public void addGameObject(AbstractGameObject gameObject) {
        //находим передеваемый тип объекта в коллекции typeObjects
        // и создаём кололлекцию этих объектов из коллекции typeObjects с названием tmpList
        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        //если таких объектов там нет то создать коллекцию
        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }
        //Добавляем этот элемент к коллекции таких же элементов
        tmpList.add(gameObject);
        //в коллецию gameObjects передаём  ключ:координаты и объект
        gameObjects.put(gameObject.getCoordinate(), gameObject);
        //в коллецию typeObjects передаём ключ: тип объекта и как объект коллекцию объектов
        typeObjects.put(gameObject.getType(), tmpList);
    }

 
}
