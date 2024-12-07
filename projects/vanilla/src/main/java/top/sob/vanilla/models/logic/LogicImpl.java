package top.sob.vanilla.models.logic;

import top.sob.core.annotations.proof.Modifiable;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.Response;
import top.sob.vanilla.exceptions.proof.WIPException;

import java.util.HashSet;
import java.util.Set;

public class LogicImpl implements Logic {

    private static final LogicImpl INSTANCE = new LogicImpl();

    private final Set<SpecificLogic> sls = new HashSet<>();

    private LogicImpl() {
    }

    public static LogicImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Response<?> actToOperation(Operation op) {

        if (op.getBody().isEmpty())
            throw new ArrayStoreException("Array length lesser than 1.");

        final var tmp = new Response[]{null};

        getSpecLogic().forEach(l -> {
            if (l.canAct(op))
                tmp[0] = l.actToOperation(op);
        });

        return tmp[0];
    }

    @Modifiable
    public Set<SpecificLogic> getSpecLogic() {
        return sls;
    }
}
