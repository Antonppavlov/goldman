package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;

/**
 * класс отвечает за работу объекта MONSTER
 */
public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/resources/images/monster_up.jpg"));// иконку по-умолчанию (можно сделать реализацию случайного выбора иконки)

    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/resources/images/monster_down.jpg"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/resources/images/monster_right.jpg"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/resources/images/monster_right.jpg"));
                break;
            case UP:
                super.setIcon(getImageIcon("/resources/images/monster_up.jpg"));
                break;
        }
    }


}
