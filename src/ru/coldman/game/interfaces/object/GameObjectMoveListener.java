package ru.coldman.game.interfaces.object;


import ru.coldman.game.abstracts.AbstractGameObject;

public interface GameObjectMoveListener {
    
    void moveAction(AbstractGameObject obj1, AbstractGameObject obj2);

}
