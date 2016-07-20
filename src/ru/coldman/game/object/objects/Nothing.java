package ru.coldman.game.object.objects;

import ru.coldman.game.object.Coordinate;
import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Nothing extends AbstractGameObject {
    public Nothing(Coordinate coordinate) {
        super.setGameObjectType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
        super.setIcon(null);
    }
}
