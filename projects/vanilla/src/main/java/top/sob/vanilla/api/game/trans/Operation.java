package top.sob.vanilla.api.game.trans;

import org.jetbrains.annotations.NotNull;

import top.sob.core.utils.misc.Wrapper;
import top.sob.vanilla.utils.HttpUtils;

import java.net.InetAddress;
import java.util.Properties;
import java.util.Set;

public abstract class Operation extends Wrapper<Set<Parameter>> {

    private final InetAddress from;

    @SuppressWarnings("unused")
    public Operation(@NotNull Set<Parameter> body) {
        super(body);

        this.from = HttpUtils.getThisAddress();
    }

    @SuppressWarnings("unused")
    public Operation(@NotNull Properties header, @NotNull Set<Parameter> body) {
        super(header, body);

        this.from = HttpUtils.getThisAddress();
    }

    public InetAddress getFrom() {
        return from;
    }
}
