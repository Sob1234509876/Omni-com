package top.sob.vanilla.event;

import org.jetbrains.annotations.NotNull;

import java.util.Properties;

public class ClientEvent<T> extends Event<T> {

    @SuppressWarnings("unused")
    public ClientEvent(@NotNull T body) {
        super(body);
    }

    @SuppressWarnings("unused")
    public ClientEvent(@NotNull Enum<?> type, @NotNull T body) {
        super(body);
        getHeader().put(Event.TYPE, type);
    }

    @SuppressWarnings("unused")
    public ClientEvent(@NotNull Properties header, @NotNull T body) {
        super(header, body);
    }
}
