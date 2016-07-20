package ru.coldman.game.interfaces.object;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.MovingDirection;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public interface InterfaceMovingObject {
    void move(MovingDirection movingDirection); //передаём направление для перемещения

    void getMoveResult(AbstractGameObject objectInNewCoordinate);

    ImageIcon getIconLeft();

    ImageIcon getIconUp();

    ImageIcon getIconDown();

    ImageIcon getIconRight();

}
