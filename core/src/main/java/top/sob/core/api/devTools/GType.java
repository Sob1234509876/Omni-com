package top.sob.core.api.devTools;

import org.apiguardian.api.API;
import top.sob.core.annotations.Creates;
import top.sob.core.annotations.From;
import top.sob.core.annotations.Immutable;
import top.sob.core.api.misc.Wrapper;

@Immutable
@From(links = "GTemplate#this")
@Creates(links = "GConstructor#this")
@API(status = API.Status.STABLE, since = "1.2.8a")
public class GType extends Wrapper<String> {

    @SuppressWarnings("unused")
    public GType(GTemplate temp) {
        super(temp.getFlags(), temp.getName() + " - " + temp.getDescription());
    }

    @SuppressWarnings("unused")
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public GConstructor getConstructor() {
        return getDefConstructor();
    }

    private GConstructor getDefConstructor() {
        return (Object[] args) -> {

            if (args.length < 2)
                throw new IllegalArgumentException("Illegal argument amount");
            if (!(args[1] instanceof GType) || !(args[0] instanceof GTag<?>))
                throw new IllegalArgumentException("Illegal argument class");

            return new GInstance((GTag<?>) args[0], (GType) args[1]);

        };
    }

    public String getNameNDesc() {
        return getBody();
    }

}
