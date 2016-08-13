package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;


/**
 * класс отвечает за работу объекта NOTHING (т.е. пустоту на карте)
 */
public class Nothing extends AbstractGameObject {

    public Nothing(Coordinate coordinate) {
        super.setType(GameObjectType.NOTHING);
        super.setCoordinate(coordinate);
        super.setIcon(null);

    }
}
