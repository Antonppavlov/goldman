package ru.coldman.game.objects.listeners;


import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.objects.GoldMan;

import java.util.List;

public interface MoveResultNotifier {

    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    void removeMoveListener(MoveResultListener listener);

    void removeAllMoveListeners();

     void notifyMoveListeners(ActionResult actionResult, AbstractMovingObject abstractMovingObject);

}
