package ru.coldman.game.objects;

import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.MovingDirection;
import ru.coldman.game.objects.sound.SoundObject;
import ru.coldman.game.objects.sound.WavPlayer;

/**
 * класс отвечает за работу объекта MONSTER
 */
public class Monster extends AbstractMovingObject implements SoundObject {

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

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {


        switch (gameObject.getType()) {


            case TREASURE:
            case EXIT:
            case MONSTER: { // монстр не может наступать на сокровище и на других монстров
                return ActionResult.NO_ACTION;
            }

            case GOLDMAN: {
                return ActionResult.DIE;
            }

        }

        return super.doAction(gameObject);
    }

    @Override
    public String getSoundName(ActionResult actionResult) {
        switch (actionResult) {
            case DIE: return WavPlayer.WAV_DIE;
        }

        return null;
    }
}
