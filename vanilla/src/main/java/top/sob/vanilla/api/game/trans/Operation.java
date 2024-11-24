package top.sob.vanilla.api.game.trans;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Immutable;

import top.sob.core.api.misc.Wrapper;

import java.util.Properties;

@Immutable
public abstract class Operation<T> extends Wrapper<T> {

    @SuppressWarnings("unused")
    public Operation(@NotNull T body) {
        super(body);
    }

    @SuppressWarnings("unused")
    public Operation(@NotNull Properties header, @NotNull T body) {
        super(header, body);
    }

}
