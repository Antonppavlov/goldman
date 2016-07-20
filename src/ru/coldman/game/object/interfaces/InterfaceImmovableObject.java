package ru.coldman.game.object.interfaces;

import ru.coldman.game.object.Coordinate;
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
