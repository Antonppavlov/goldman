package ru.coldman.game.interfaces.collections;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.movestrategies.MoveStrategy;
import ru.coldman.game.objects.Coordinate;
import ru.coldman.game.objects.listeners.MoveResultNotifier;

import java.util.List;

public interface GameCollection extends MoveResultNotifier {

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    AbstractGameObject getObjectByCoordinate(int x, int y);

    void addGameObject(AbstractGameObject gameObject);

    List<AbstractGameObject> getAllGameObjects();

    List<AbstractGameObject> getGameObjects(GameObjectType type);


    //В этот метот передаётся направление движения, и тип объекта который будет двигаться
    //вызывается для того чтобы обработать движение объекта

    void moveObject(MovingDirection direction, GameObjectType gameObjectType);

    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);

}
