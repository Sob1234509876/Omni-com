package top.sob.core.loaders;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.proof.Creates;

import java.net.URL;
import java.util.Objects;

@Creates(links = "Loader#")
@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class LoaderProvider {

    public synchronized static Loader forUrl(URL url) {

        Objects.requireNonNull(url);

        return getProvider().getLoader(url);
    }

    public static LoaderProvider getProvider() {
        return LoaderProviderImpl.getInstance();
    }

    public abstract Loader getLoader(URL url);

}
