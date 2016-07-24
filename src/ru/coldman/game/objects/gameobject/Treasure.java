package ru.coldman.game.objects.gameobject;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public class Treasure extends AbstractGameObject {

    private int score = 5;

    public Treasure(Coordinate coordinate) {
        super.setType(GameObjectType.TREASURE);
        super.setCoordinate(coordinate);
        super.setIcon(new ImageIcon(getClass().getResource("/resources/images/gold.png")));
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
