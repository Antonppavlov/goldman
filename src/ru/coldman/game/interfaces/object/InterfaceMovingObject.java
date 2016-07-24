package ru.coldman.game.interfaces.object;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.MovingDirection;

import javax.swing.*;

/**
 * Интерфейс для движемых объектов
 */
public interface InterfaceMovingObject extends InterfaceImmovableObject {
    //передаём направление из enum MovingDirection для перемещения
    void move(MovingDirection movingDirection);

    void getMoveResult(AbstractGameObject objectInNewCoordinate);

    ImageIcon getIconLeft();

    ImageIcon getIconUp();

    ImageIcon getIconDown();

    ImageIcon getIconRight();

}
