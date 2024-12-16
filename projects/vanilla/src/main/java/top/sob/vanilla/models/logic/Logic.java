package top.sob.vanilla.models.logic;

import top.sob.vanilla.game.trans.Operation;
import top.sob.vanilla.game.trans.Response;

public interface Logic {

    Response<?> actToOperation(Operation op);

}
