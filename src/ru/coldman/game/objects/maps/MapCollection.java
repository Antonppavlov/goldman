package ru.coldman.game.objects.maps;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.interfaces.collections.GameCollection;
import ru.coldman.game.objects.Coordinate;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class MapCollection implements GameCollection {// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

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

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);

    }

    @Override
    public ActionResult moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        ActionResult actionResult=null;
        //цикл для всех объектов этого типа в EnumMap GameObjects
        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            //если этот объект наследуется от абстрактного класса AbstractMovingObject то
            if (gameObject instanceof AbstractMovingObject) {// дорогостоящая операция - instanceof

                //привести его к AbstractMovingObject, сделать ссылку movingObject и сослаться на этот объект
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                //получить новую кординату отравив в метод getNewCoordinate направление и объект
                Coordinate newCoordinate = getNewCoordinate(direction, movingObject);
                //сделать ссылку на объект хранящийся в этой координате
                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);
                //получение результата движение параметром из енума ActionResult
                //для этого в объекте movingObject.вызываю метот moveToObject и передаю в него направление и коориданыты объекта который находится на координатам
                //направление передаётся для смены картинки
                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                //свич по результатм
                switch (actionResult) {
                    //если результатом является движение то перадть два объета в метод swapObjects
                    //который поменяет их местами
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                }
            }
        }
        return actionResult;
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {
//метод меняет ссылки на объекты "координаты" местами
        swapCoordinates(obj1, obj2);
//добавляем в gameObjects новые объекты по координатам (заменяем)
        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);

    }

    //метод меняет ссылки на объекты "координаты" местами
    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

    private Coordinate getNewCoordinate(MovingDirection direction, AbstractMovingObject movingObject) {

        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = movingObject.getCoordinate().getX();
        int y = movingObject.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// определяем, в каком направлении нужно двигаться
            case UP: {
                newCoordinate.setY(y - movingObject.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + movingObject.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - movingObject.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + movingObject.getStep());
                break;
            }
        }

        return newCoordinate;
    }
}
