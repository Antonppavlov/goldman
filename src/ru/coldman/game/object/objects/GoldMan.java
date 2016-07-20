package ru.coldman.game.object.objects;

import ru.coldman.game.object.abstracts.AbstractGameObject;
import ru.coldman.game.object.abstracts.AbstractMovingObject;
import ru.coldman.game.object.enums.GameObjectType;
import ru.coldman.game.object.enums.MovingDirection;

/**
 * Created by Антон on 19.07.2016.
 */
public class GoldMan extends AbstractMovingObject {

    private int totalScore = 0;
    private int totalNumberSteps = 0;

    public GoldMan(Coordinate coordinate) {
        super.setIconRight("/ru/coldman/game/images/goldman_right.png");
        super.setIconLeft("/ru/coldman/game/images/goldman_left.png");
        super.setIconUp("/ru/coldman/game/images/up.png");
        super.setIconDown("/ru/coldman/game/images/down.png");
        super.setIcon("/ru/coldman/game/images/up.png");
        super.setCoordinate(coordinate);
        super.setGameObjectType(GameObjectType.GOLDMAN);
    }

    @Override
    public void move(MovingDirection movingDirection) {
    }

    @Override
    public void getMoveResult(AbstractGameObject objectInNewCoordinate) {
    }


    public void addIntTotalScore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalNumberSteps() {
        return totalNumberSteps;
    }

    public void setTotalNumberSteps(int totalNumberSteps) {
        this.totalNumberSteps = totalNumberSteps;
    }

}
