package top.sob.vanilla.thread.server;

import top.sob.core.eventbus.FilteredAsyncEventBus;

public class ServerEventBus extends FilteredAsyncEventBus {

    private static final ServerEventBus BUS = new ServerEventBus();

    private ServerEventBus() {
        getFilters().add(object -> object instanceof ServerEvent<?>);
    }

    public static ServerEventBus getEventBus() {
        return BUS;
    }

}
