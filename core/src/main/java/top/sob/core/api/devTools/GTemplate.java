package top.sob.core.api.devTools;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Creates;
import top.sob.core.annotations.Mutable;
import top.sob.core.api.misc.Wrapper;

import java.util.Objects;
import java.util.Properties;

@Mutable
@Creates(links = "GType#new(GTemplate)")
@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class GTemplate extends Wrapper<String> {

    private final String name;

    @SuppressWarnings("unused")
    public GTemplate(@NotNull String desc, @NotNull String name) {
        super(desc);

        Objects.requireNonNull(name);

        this.name = name;
    }

    @API(status = API.Status.STABLE, since = "1.2.8a")
    public String getName() {
        return name;
    }

    @API(status = API.Status.STABLE, since = "1.2.8a")
    public String getDescription() {
        return getBody();
    }

    @API(status = API.Status.STABLE, since = "1.2.8a")
    public Properties getFlags() {
        return getHeader();
    }

}
