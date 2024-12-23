package top.sob.core;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.util.concurrent.MoreExecutors;

public final class Buses {
    private Buses() {
    }

    private static final AsyncEventBus ROOT_BUS = new AsyncEventBus("root", MoreExecutors.directExecutor());

    public static AsyncEventBus getRootBus() {
        return ROOT_BUS;
    }
}
