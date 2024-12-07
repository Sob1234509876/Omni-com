package top.sob.core.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.MoreExecutors;
import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

@API(status = API.Status.STABLE, since = "1.2.8a")
public class FilteredAsyncEventBus extends AsyncEventBus {

    private static final List<Predicate<Object>> filters = new LinkedList<>();

    @SuppressWarnings("unused")
    public FilteredAsyncEventBus() {
        this("unnamed");
    }

    @SuppressWarnings("unused")
    public FilteredAsyncEventBus(@NotNull String name) {
        super(name, MoreExecutors.directExecutor());
    }

    @Override
    public void post(@NotNull Object event) {

        var flag = new AtomicBoolean(true);

        getFilters().forEach(predicate -> flag.set(predicate.test(event)));

        if (flag.get())
            super.post(event);
    }

    @SuppressWarnings("unused")
    @Subscribe
    public void act(@NotNull Object event) {
        super.post(event);
    }

    public static List<Predicate<Object>> getFilters() {
        return filters;
    }
}
