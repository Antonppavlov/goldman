package ru.coldman.game.object.objects;

import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Exit extends AbstractGameObject {

    public Exit(Coordinate coordinate) {
        setIcon("/ru/coldman/game/images/exit.gif");
        setGameObjectType(GameObjectType.EXIT);
        setCoordinate(coordinate);
    }
}
