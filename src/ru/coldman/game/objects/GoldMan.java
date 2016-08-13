package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;

/**
 * класс отвечает за работу объекта GOLDMAN - главный персонаж игры
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

 
}
