package ru.coldman.game.interfaces.gameobjects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.MovingDirection;

/**
 * поведение для всех движущихся объектов:
 */
public interface MovingObject extends StaticObject {

    //реализация будет возвращать результат движения
    //параметрами передаётся направление и объект для движения
    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject);

    int getStep();

}
