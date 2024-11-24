package top.sob.vanilla.util;

import top.sob.core.annotations.Immutable;
import top.sob.core.annotations.Singleton;
import top.sob.vanilla.api.game.logic.Logic;
import top.sob.vanilla.api.game.logic.LogicImpl;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.OperationTemplate;
import top.sob.vanilla.api.game.trans.Parameter;
import top.sob.vanilla.api.game.trans.Response;

@Immutable
@Singleton(desc = "Implementation for GameBaseProvider", instance = "GameBaseProviderImpl#INSTANCE")
class GameBaseProviderImpl extends GameBaseProvider {

    private static final GameBaseProvider INSTANCE = new GameBaseProviderImpl();

    public static GameBaseProvider getInstance() {
        return INSTANCE;
    }

    private static int OPERATION_SEQUENCE = 0;
    private static int RESPONSE_SEQUENCE = 0;

    private GameBaseProviderImpl() {
    }

    @Override
    public <T> Operation<T> createOperation(T body) {
        return new Operation<>(body) {
            {
                getHeader().setProperty("sequence", "" + OPERATION_SEQUENCE++);
            }
        };
    }

    @Override
    public <T> Response<T> createResponse(T body) {
        return new Response<>(body) {
            {
                getHeader().setProperty("sequence", "" + RESPONSE_SEQUENCE++);
            }
        };
    }

    public Logic getLogic() {
        return LogicImpl.INSTANCE;
    }

    @Override
    public OperationTemplate createOpTemplate(Parameter[] parameters) {
        return null;
    }
}
