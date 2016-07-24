package ru.coldman.game.objects.gameobject;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public class Exit extends AbstractGameObject {

    public Exit(Coordinate coordinate) {
        setIcon(new ImageIcon(getClass().getResource("/resources/images/exit.gif")));
        setType(GameObjectType.EXIT);
        setCoordinate(coordinate);
    }
}
