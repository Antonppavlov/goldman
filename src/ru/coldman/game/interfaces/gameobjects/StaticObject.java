/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.coldman.game.interfaces.gameobjects;

import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.objects.Coordinate;

import javax.swing.*;

/**
 *
 * @author Tim
 */
public interface StaticObject {
 
    // объект должен иметь иконку
    ImageIcon getIcon();

    // координаты
    Coordinate getCoordinate();

    // тип объекта
    GameObjectType getType();
    
            
}
