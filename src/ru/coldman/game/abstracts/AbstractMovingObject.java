package ru.coldman.game.abstracts;

import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.interfaces.gameobjects.MovingObject;

/**
 * класс, который отвечает за любой движущийся объект. наследуется от класса
 * AbstractGameObject с добавлением функций движения
 */
public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {

    public abstract void changeIcon(MovingDirection direction);

    private int step = 1;// по-умолчанию у всех объектов шаг равен 1

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    //метод изменяет иконку
    protected void actionBeforeMove(MovingDirection direction) {
        // при движении объект должен сменить иконку и произвести звук
        changeIcon(direction);
//        playSound(); на будушее

    }

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        //отрисовка действия
        actionBeforeMove(direction);
        //результат действия
        return doAction(gameObject);
    }


    public ActionResult doAction(AbstractGameObject gameObject) {
//если gameObject == null   происходит если край карты
        // то вернуть NO_ACTION т.е не делать действия
        if (gameObject == null) { // край карты
            return ActionResult.NO_ACTION;
        }
//свич с типом объекта
        switch (gameObject.getType()) {
// если впереди пустота вернуть MOVE
            case NOTHING: {
                return ActionResult.MOVE;
            }
        }
//если ничего из перечисленного то ничего не делать
        return ActionResult.NO_ACTION;
    }
}
