package ru.coldman.game.abstracts;

import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.interfaces.object.InterfaceImmovableObject;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 * Абстрактый класс который импрелементит интерфейс не движемых игровых объектов
 */
public abstract class AbstractGameObject implements InterfaceImmovableObject {


    private GameObjectType gameObjectType;// все объекты будут иметь тип
    private Coordinate coordinate;// все объекты будут иметь координаты положения

    private ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/images/noicon.png"));

    public void setIcon(ImageIcon pathImageIcon) {
        if (pathImageIcon == null) {
            imageIcon = null;
        } else
            this.imageIcon = pathImageIcon;
    }

    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;
    }


    @Override
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setType(GameObjectType gameObjectType) {
        this.gameObjectType = gameObjectType;
    }

    public GameObjectType getType() {
        return gameObjectType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractGameObject that = (AbstractGameObject) o;

        if (imageIcon != null ? !imageIcon.equals(that.imageIcon) : that.imageIcon != null) return false;
        if (coordinate != null ? !coordinate.equals(that.coordinate) : that.coordinate != null) return false;
        return gameObjectType == that.gameObjectType;

    }

    @Override
    public int hashCode() {
        int result = imageIcon != null ? imageIcon.hashCode() : 0;
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        result = 31 * result + (gameObjectType != null ? gameObjectType.hashCode() : 0);
        return result;
    }
}
