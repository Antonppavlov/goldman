package ru.coldman.game.abstracts;

import ru.coldman.game.objects.Coordinate;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.interfaces.object.InterfaceImmovableObject;

import javax.swing.*;

/**
 * Created by Антон on 19.07.2016.
 */
public abstract class AbstractGameObject implements InterfaceImmovableObject {

    private ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/images/noicon.png"));
    private Coordinate coordinate;
    private GameObjectType gameObjectType;

    public void setIcon(String pathImageIcon) {
        if (pathImageIcon == null) {
            imageIcon = null;
        } else
            this.imageIcon = new ImageIcon(getClass().getResource(pathImageIcon));
    }

    public ImageIcon getIcon() {
        return imageIcon;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setGameObjectType(GameObjectType gameObjectType) {
        this.gameObjectType = gameObjectType;
    }

    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    @Override
    public Coordinate getCoordinate() {
        return coordinate;
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
