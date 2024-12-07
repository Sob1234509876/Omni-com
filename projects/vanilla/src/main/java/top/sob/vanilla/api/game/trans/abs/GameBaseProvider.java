package top.sob.vanilla.api.game.trans.abs;

import top.sob.core.annotations.proof.Creates;
import top.sob.vanilla.annotations.proof.Provider;
import top.sob.vanilla.models.logic.Logic;
import top.sob.vanilla.api.game.trans.*;

import java.util.Set;

@Creates(links = {"Operation", "Response", "Logic", "OperationTemplate"})
@Provider(defaultProviders = "GameBaseProviderImpl")
public interface GameBaseProvider {

    @SuppressWarnings("unused")
    Operation createOperation(Set<Parameter> body);

    @SuppressWarnings("unused")
    <T> Response<T> createResponse(T body);

    Logic getLogic();

    static GameBaseProvider getDefaultProvider() {
        return GameBaseProviderImpl.getInstance();
    }

}
