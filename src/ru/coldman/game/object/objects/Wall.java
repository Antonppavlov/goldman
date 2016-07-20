package ru.coldman.game.object.objects;

import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Wall extends AbstractGameObject {
    public Wall(Coordinate coordinate) {
        super.setGameObjectType(GameObjectType.WALL);
        super.setCoordinate(coordinate);
        super.setIcon("/ru/coldman/game/images/wall.png");
    }
}
