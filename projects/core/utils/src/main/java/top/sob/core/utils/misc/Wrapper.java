package top.sob.core.utils.misc;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.Properties;

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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Wrapper<?> wrapper)) return false;
        return Objects.equals(getHeader(), wrapper.getHeader()) && Objects.equals(getBody(), wrapper.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeader(), getBody());
    }
}
