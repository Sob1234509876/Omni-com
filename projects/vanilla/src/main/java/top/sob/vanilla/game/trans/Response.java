package top.sob.vanilla.game.trans;

import org.jetbrains.annotations.NotNull;

import top.sob.core.utils.misc.Wrapper;
import top.sob.vanilla.utils.HttpUtils;

import java.net.InetAddress;
import java.util.Properties;

public abstract class Response<T> extends Wrapper<T> {

    private final InetAddress from;

    @SuppressWarnings("unused")
    public Response(@NotNull T body) {
        super(body);

        this.from = HttpUtils.getThisAddress();
    }

    @SuppressWarnings("unused")
    public Response(@NotNull Properties header, @NotNull T body) {
        super(header, body);

        this.from = HttpUtils.getThisAddress();
    }

    public InetAddress getFrom() {
        return from;
    }
}
