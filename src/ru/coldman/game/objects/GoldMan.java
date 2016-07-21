package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;

/**
 * Created by Антон on 19.07.2016.
 */
public class GoldMan extends AbstractMovingObject {

    private int totalScore = 0;
    private int totalNumberSteps = 0;

    public GoldMan(Coordinate coordinate) {
        super.setIconRight("/resources/images/goldman_right.png");
        super.setIconLeft("/resources/images/goldman_left.png");
        super.setIconUp("/resources/images/goldman_up.png");
        super.setIconDown("/resources/images/goldman_down.png");
        super.setIcon("/resources/images/goldman_up.png");
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
