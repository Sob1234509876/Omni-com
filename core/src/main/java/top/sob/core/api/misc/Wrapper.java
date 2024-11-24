package top.sob.core.api.misc;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Immutable;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;

@Immutable
public class Wrapper<T> implements Serializable {

    @NotNull
    private final Properties header;

    @NotNull
    private final T body;

    @NotNull
    public Properties getHeader() {
        return header;
    }

    @NotNull
    public T getBody() {
        return body;
    }

    @SuppressWarnings("unused")
    public Wrapper(@NotNull T body) {
        this(new Properties(), body);
    }

    @SuppressWarnings("unused")
    public Wrapper(@NotNull Properties header, @NotNull T body) {

        Objects.requireNonNull(header);
        Objects.requireNonNull(body);

        this.header = header;
        this.body = body;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
