package ru.coldman.game.abstracts;

import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.interfaces.gameobjects.MovingObject;
import ru.coldman.game.objects.Coordinate;

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
        if (gameObject == null) { // край карты
            return ActionResult.NO_ACTION;
        }
        return doAction(gameObject);
    }


    public ActionResult doAction(AbstractGameObject gameObject) {
//если gameObject == null   происходит если край карты
        // то вернуть NO_ACTION т.е не делать действия
//свич с типом объекта
        switch (gameObject.getType()) {

            case NOTHING: {
                return ActionResult.MOVE;
            }

            case WALL: {// по-умолчанию объект не может ходить через стену
                return ActionResult.NO_ACTION;
            }
        }

        return ActionResult.NO_ACTION;
    }


    public Coordinate getDirectionCoordinate(MovingDirection direction) {

        // берем текущие координаты объекта, которые нужно передвинуть (индексы начинаются с нуля)
        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// определяем, в каком направлении нужно двигаться
            case UP: {
                newCoordinate.setY(y - this.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + this.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - this.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + this.getStep());
                break;
            }
        }

        return newCoordinate;


    }
}
