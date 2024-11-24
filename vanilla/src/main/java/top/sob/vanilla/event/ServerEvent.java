package top.sob.vanilla.event;

import org.jetbrains.annotations.NotNull;

import java.util.Properties;

public class ServerEvent<T> extends Event<T> {

    @SuppressWarnings("unused")
    public ServerEvent(@NotNull T body) {
        super(body);
    }

    @SuppressWarnings("unused")
    public ServerEvent(@NotNull Enum<?> type, @NotNull T body) {
        super(body);
        getHeader().put(Event.TYPE, type);
    }

    @SuppressWarnings("unused")
    public ServerEvent(@NotNull Properties header, @NotNull T body) {
        super(header, body);
    }
}
