package ru.coldman.game.object.interfaces.object;

import ru.coldman.game.object.objects.Coordinate;
import ru.coldman.game.object.enums.GameObjectType;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public interface InterfaceImmovableObject {
    ImageIcon getImageIcon();

    Coordinate getCoordinate();

    GameObjectType getType();

}
