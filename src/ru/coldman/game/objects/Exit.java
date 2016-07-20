package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Exit extends AbstractGameObject {

    public Exit(Coordinate coordinate) {
        setIcon("/resources/images/exit.gif");
        setGameObjectType(GameObjectType.EXIT);
        setCoordinate(coordinate);
    }
}
