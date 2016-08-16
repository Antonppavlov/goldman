package ru.coldman.game.objects.listeners;


import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.objects.GoldMan;

public interface MoveResultListener {
    
      void notifyActionResult(ActionResult actionResult,  final AbstractMovingObject abstractMovingObject);

}
