package top.sob.vanilla.models.logic.buy;

import top.sob.vanilla.game.trans.Operation;
import top.sob.vanilla.game.trans.Response;
import top.sob.vanilla.game.trans.pars.cmds.Buy;

import top.sob.vanilla.proof.WIPException;

import top.sob.vanilla.models.logic.SpecificLogic;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class BuyLogic implements SpecificLogic {

    private static final BuyLogic INSTANCE = new BuyLogic();

    public static BuyLogic getInstance() {
        return INSTANCE;
    }

    private BuyLogic() {
        getFilters().add(o -> o.getBody().contains(Buy.getInstance()));
    }

    private final Set<Predicate<Operation>> filters = new HashSet<>();

    @Override
    public Response<?> actToOperation(Operation elements) {

        if (canAct(elements)) throw new IllegalArgumentException("Parameter did not pass filtration.");

        throw new WIPException();
    }

    @Override
    public Set<Predicate<Operation>> getFilters() {
        return filters;
    }
}
