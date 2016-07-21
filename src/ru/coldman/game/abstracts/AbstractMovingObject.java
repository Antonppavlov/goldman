package ru.coldman.game.abstracts;

import ru.coldman.game.interfaces.object.InterfaceMovingObject;

import javax.swing.*;

/**
 * Класс движемых игровых объектов. наследуется от класса не движемых игрвых объектов и имплементит интерфейс движемых объектов
 */
public abstract class AbstractMovingObject extends AbstractGameObject implements InterfaceMovingObject {

    private ImageIcon iconLeft;
    private ImageIcon iconUp;
    private ImageIcon iconDown;
    private ImageIcon iconRight;


    @Override
    public ImageIcon getIconLeft() {
        return iconLeft;
    }

    public void setIconLeft(String pathImageIcon) {
        this.iconLeft = new ImageIcon(getClass().getResource(pathImageIcon));
    }

    @Override
    public ImageIcon getIconUp() {
        return iconUp;
    }

    public void setIconUp(String pathImageIcon) {
        this.iconUp = new ImageIcon(getClass().getResource(pathImageIcon));
    }

    @Override
    public ImageIcon getIconDown() {
        return iconDown;
    }

    public void setIconDown(String pathImageIcon) {
        this.iconDown = new ImageIcon(getClass().getResource(pathImageIcon));
    }

    @Override
    public ImageIcon getIconRight() {
        return iconRight;
    }

    public void setIconRight(String pathImageIcon) {
        this.iconRight = new ImageIcon(getClass().getResource(pathImageIcon));
    }
}
