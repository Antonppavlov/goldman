package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;


/**
 * класс отвечает за работу объекта WALL
 */
public class Wall extends AbstractGameObject {

    public Wall(Coordinate coordinate) {
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/resources/images/wall.png"));

    }
}
