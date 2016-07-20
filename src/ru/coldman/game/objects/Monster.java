package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;

/**
 * Created by Антон on 19.07.2016.
 */
public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setIconRight("/resources/images/monster_right.jpg");
        super.setIconLeft("/resources/images/monster_left.jpg");
        super.setIconUp("/resources/images/monster_up.jpg");
        super.setIconDown("/resources/images/monster_down.jpg");
        super.setIcon("/resources/images/monster_up.jpg");
        super.setCoordinate(coordinate);
        super.setGameObjectType(GameObjectType.MONSTER);
    }

    @Override
    public void move(MovingDirection movingDirection) {

    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {

    }
}
