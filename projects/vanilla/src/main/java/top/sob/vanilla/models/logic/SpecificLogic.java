package top.sob.vanilla.models.logic;

import top.sob.core.utils.misc.Filterable;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.Response;

public interface SpecificLogic extends Filterable<Operation> {

    Response<?> actToOperation(Operation elements);

    default boolean canAct(Operation op) {
        return test(op);
    }

}
