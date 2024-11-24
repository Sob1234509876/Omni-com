package top.sob.core.api.devTools;

import org.apiguardian.api.API;
import top.sob.core.annotations.Creates;
import top.sob.core.annotations.From;
import top.sob.core.annotations.Immutable;

@Immutable
@FunctionalInterface
@From(links = "GType#getConstructor()")
@Creates(links = "GInstance#")
@API(status = API.Status.STABLE, since = "1.2.8a")
public interface GConstructor {

    @SuppressWarnings("unused")
    @API(status = API.Status.STABLE, since = "1.2.8a")
    GInstance newInstance(Object... args);

}
