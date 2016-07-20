package ru.coldman.game.object.objects;

import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.enums.GameObjectType;

/**
 * Created by Антон on 19.07.2016.
 */
public class Treasure extends AbstractGameObject {

    private int score = 5;

    public Treasure(Coordinate coordinate) {
        super.setGameObjectType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon("/ru/coldman/game/images/gold.png");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
