package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.From;
import top.sob.core.annotations.Mutable;

import top.sob.core.api.misc.Wrapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Mutable
@From(links = "GInstance#getTag()")
@API(status = API.Status.STABLE, since = "1.2.8a")
public class GTag<T> extends Wrapper<T> {

    private final List<GTag<?>> children = new LinkedList<>();

    @SuppressWarnings("unused")
    public GTag(@NotNull T body) {
        super(body);
    }

    public List<GTag<?>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "{body=" +
                getBody() +
                ", children=" +
                Arrays.toString(getChildren().toArray()) +
                "}";
    }
}
