package top.sob.vanilla.game.gt.politic;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.game.gt.resource.Item;

import java.math.BigDecimal;

public abstract class Currency extends Item {

    public Currency(@NotNull GTag<?> body, @NotNull String name, @NotNull BigDecimal worth) {
        super(body, MatterState.ABSTRACT, name, worth);
    }

}
