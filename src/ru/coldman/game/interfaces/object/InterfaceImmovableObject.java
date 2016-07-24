package ru.coldman.game.interfaces.object;

import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 * Интерфейс для не движемых объектов
 */
public interface InterfaceImmovableObject {
    ImageIcon getImageIcon();

    Coordinate getCoordinate();

    GameObjectType getType();

}
