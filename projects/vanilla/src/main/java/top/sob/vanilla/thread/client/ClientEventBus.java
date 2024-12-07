package top.sob.vanilla.thread.client;

import top.sob.core.eventbus.FilteredAsyncEventBus;

public class ClientEventBus extends FilteredAsyncEventBus {
    private static final ClientEventBus BUS = new ClientEventBus();

    private ClientEventBus() {
        getFilters().add(object -> object instanceof ClientEvent<?>);
    }

    public static ClientEventBus getEventBus() {
        return BUS;
    }
}
