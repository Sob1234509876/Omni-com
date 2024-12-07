package top.sob.core.api.devTools;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.function.Function;

public abstract class DynamicGInstance extends GInstance implements Runnable {

    public DynamicGInstance(@NotNull GTag<?> body, Function<BigDecimal, String> amt2Str, String name) {
        super(body, amt2Str, name);
    }

    public DynamicGInstance(@NotNull GTag<?> body, String name) {
        super(body, name);
    }

}
