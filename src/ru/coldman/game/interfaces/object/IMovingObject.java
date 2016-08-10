package ru.coldman.game.interfaces.object;

import ru.coldman.game.abstracts.AbstractGameMap;
import ru.coldman.game.enums.MovingDirection;

/**
 * Интерфейс для движемых объектов
 */
public interface IMovingObject extends StaticObject {
    //передаём направление из enum MovingDirection для перемещения
    void move(MovingDirection direction, AbstractGameMap abstractGameMap);

    int getStep();

}
