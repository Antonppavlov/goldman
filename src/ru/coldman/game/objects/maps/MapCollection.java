package ru.coldman.game.objects.maps;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.movestrategies.MoveStrategy;
import ru.coldman.game.objects.Coordinate;
import ru.coldman.game.objects.GoldMan;
import ru.coldman.game.objects.Nothing;
import ru.coldman.game.objects.listeners.MapListenersRegistrator;
import ru.coldman.game.objects.listeners.MoveResultListener;

import java.util.*;

public class MapCollection extends MapListenersRegistrator {// объекты для карты, которые умеют уведомлять всех слушателей о своих ходах

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
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);// движение по направлению (без стратегии)
    }


    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);// движение по стратегии
    }


    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy) {

        GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;
        //цикл для всех объектов этого типа в EnumMap GameObjects
        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            //если этот объект наследуется от абстрактного класса AbstractMovingObject то
            if (gameObject instanceof AbstractMovingObject) {// дорогостоящая операция - instanceof

                //привести его к AbstractMovingObject, сделать ссылку movingObject и сослаться на этот объект
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;


                if (moveStrategy!=null){// если указана стратегия движения - то берем наравления оттуда
                    direction = moveStrategy.getDirection(movingObject, goldMan, this);
                }



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
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        swapObjects(movingObject, new Nothing(newCoordinate));
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }

            }

            notifyMoveListeners(actionResult, goldMan);
        }
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

    @Override
    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, goldMan);
        }
    }

 //  @Override
 //  public void moveObjectRandom(GameObjectType objectType) {
 //      doMoveAction(null, objectType);
 //  }
}


