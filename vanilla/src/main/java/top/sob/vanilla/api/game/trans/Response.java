package top.sob.vanilla.api.game.trans;

import org.jetbrains.annotations.NotNull;

import top.sob.core.api.misc.Wrapper;

import java.util.Properties;

public abstract class Response<T> extends Wrapper<T> {

    @SuppressWarnings("unused")
    public Response(@NotNull T body) {
        super(body);
    }

    @SuppressWarnings("unused")
    public Response(@NotNull Properties header, @NotNull T body) {
        super(header, body);
    }

}
