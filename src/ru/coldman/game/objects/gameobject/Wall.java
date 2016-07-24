package ru.coldman.game.objects.gameobject;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public class Wall extends AbstractGameObject {
    public Wall(Coordinate coordinate) {
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);

        super.setIcon(new ImageIcon(getClass().getResource("/resources/images/wall.png")));
    }
}
