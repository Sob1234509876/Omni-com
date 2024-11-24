package top.sob.vanilla.api.game.logic;

import top.sob.vanilla.api.game.trans.OperationElement;

@FunctionalInterface
public interface Logic {
    Object actToOperation(OperationElement[] elements);
}
