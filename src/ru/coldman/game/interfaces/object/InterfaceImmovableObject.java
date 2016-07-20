package ru.coldman.game.interfaces.object;

import ru.coldman.game.objects.Coordinate;
import ru.coldman.game.enums.GameObjectType;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public interface InterfaceImmovableObject {
    ImageIcon getImageIcon();

    Coordinate getCoordinate();

    GameObjectType getType();

}
