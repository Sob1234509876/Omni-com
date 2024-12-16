package top.sob.vanilla.game.trans.abs;

import top.sob.core.proof.Singleton;
import top.sob.vanilla.game.trans.Operation;
import top.sob.vanilla.game.trans.Parameter;
import top.sob.vanilla.game.trans.Response;
import top.sob.vanilla.models.logic.Logic;
import top.sob.vanilla.models.logic.LogicImpl;
import top.sob.vanilla.api.game.trans.*;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton(desc = "Implementation for GameBaseProvider", instance = "GameBaseProviderImpl#INSTANCE")
class GameBaseProviderImpl implements GameBaseProvider {

    private static final GameBaseProvider INSTANCE = new GameBaseProviderImpl();

    public static GameBaseProvider getInstance() {
        return INSTANCE;
    }

    private static final AtomicInteger OPERATION_SEQUENCE = new AtomicInteger();
    private static final AtomicInteger RESPONSE_SEQUENCE = new AtomicInteger();

    private GameBaseProviderImpl() {
    }

    @Override
    public Operation createOperation(Set<Parameter> body) {
        return new Operation(body) {
            {
                getHeader().setProperty("sequence", "" + OPERATION_SEQUENCE.getAndAdd(1));
            }
        };
    }

    @Override
    public <T> Response<T> createResponse(T body) {
        return new Response<>(body) {
            {
                getHeader().setProperty("sequence", "" + RESPONSE_SEQUENCE.getAndAdd(1));
            }
        };
    }

    public Logic getLogic() {
        return LogicImpl.getInstance();
    }

}
