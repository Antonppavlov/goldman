package ru.coldman.game.object.objects;

import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.abstracts.AbstractMovingObject;
import ru.coldman.game.object.enums.GameObjectType;
import ru.coldman.game.object.enums.MovingDirection;

/**
 * Created by Антон on 19.07.2016.
 */
public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setIconRight("/ru/coldman/game/images/monster_right.jpg");
        super.setIconLeft("/ru/coldman/game/images/monster_left.jpg");
        super.setIconUp("/ru/coldman/game/images/monster_up.jpg");
        super.setIconDown("/ru/coldman/game/images/monster_down.jpg");
        super.setIcon("/ru/coldman/game/images/monster_up.jpg");
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
