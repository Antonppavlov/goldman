package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Wall extends AbstractGameObject {
    public Wall(Coordinate coordinate) {
        super.setGameObjectType(GameObjectType.WALL);
        super.setCoordinate(coordinate);
        super.setIcon("/resources/images/wall.png");
    }
}
