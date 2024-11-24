package top.sob.core.api;

import org.apiguardian.api.API;

import java.io.Closeable;

@API(status = API.Status.STABLE, since = "1.2.8a")
public interface CloseCheck extends Closeable {

    @SuppressWarnings("unused")
    @API(status = API.Status.STABLE, since = "1.2.8a")
    boolean isClosed();

}
