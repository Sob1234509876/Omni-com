package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.proof.From;
import top.sob.core.annotations.proof.Modifiable;

import top.sob.core.utils.misc.Wrapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Modifiable
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
