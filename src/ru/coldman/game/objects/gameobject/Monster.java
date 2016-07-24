package ru.coldman.game.objects.gameobject;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.objects.Coordinate;

/**
 * Created by Антон on 19.07.2016.
 */
public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setIconRight("/resources/images/monster_right.jpg");
        super.setIconLeft("/resources/images/monster_left.jpg");
        super.setIconUp("/resources/images/monster_up.jpg");
        super.setIconDown("/resources/images/monster_down.jpg");
        super.setIcon(getIconUp());
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.MONSTER);
    }

    @Override
    public void move(MovingDirection movingDirection) {

    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {

    }
}
