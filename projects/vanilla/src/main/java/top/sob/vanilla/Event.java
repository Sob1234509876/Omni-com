package top.sob.vanilla;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;

import java.util.Properties;

public class Event<T> extends Wrapper<T> {

    public static final String TYPE = "type";

    @SuppressWarnings("unused")
    public Event(@NotNull T body) {
        super(body);
    }

    @SuppressWarnings("unused")
    public Event(@NotNull Properties header, @NotNull T body) {
        super(header, body);
    }
}
