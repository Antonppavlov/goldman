package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;

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
