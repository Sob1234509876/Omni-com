package top.sob.vanilla.util;

import top.sob.core.annotations.Creates;
import top.sob.vanilla.annotations.Provider;
import top.sob.vanilla.api.game.logic.Logic;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.OperationTemplate;
import top.sob.vanilla.api.game.trans.Parameter;
import top.sob.vanilla.api.game.trans.Response;

import java.util.Collection;

@Creates(links = {"Operation", "Response", "Logic", "OperationTemplate"})
@Provider(defaultProviders = "GameBaseProviderImpl")
public abstract class GameBaseProvider {

    @SuppressWarnings("unused")
    public abstract <T> Operation<T> createOperation(T body);

    @SuppressWarnings("unused")
    public abstract <T> Response<T> createResponse(T body);

    public abstract Logic getLogic();

    @SuppressWarnings("unused")
    public abstract OperationTemplate createOpTemplate(Parameter[] parameters);

    @SuppressWarnings("unused")
    public OperationTemplate createOpTemplate(Collection<Parameter> collection) {
        return createOpTemplate(collection.toArray(new Parameter[0]));
    }

    public static GameBaseProvider getDefaultProvider() {
        return GameBaseProviderImpl.getInstance();
    }

}
