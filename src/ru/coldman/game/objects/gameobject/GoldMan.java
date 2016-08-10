package ru.coldman.game.objects.gameobject;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.objects.Coordinate;

/**
 * Created by Антон on 19.07.2016.
 */
public class GoldMan extends AbstractMovingObject {

    private int totalScore = 0;// кол-во очков, собранных игроком
    private int turnsNumber = 0;// кол-во сделанных ходов

    public GoldMan(Coordinate coordinate) {
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/resources/images/goldman_up.png"));
    }

    public void addSTotalcore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/resources/images/goldman_down.png"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/resources/images/goldman_left.png"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/resources/images/goldman_right.png"));
                break;
            case UP:
                super.setIcon(getImageIcon("/resources/images/goldman_up.png"));
                break;
        }
    }
    // super.setIconRight("/resources/images/goldman_right.png");
    // super.setIconLeft("/resources/images/goldman_left.png");
    // super.setIconUp("/resources/images/goldman_up.png");
    // super.setIconDown("/resources/images/goldman_down.png");




}

