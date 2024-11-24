package top.sob.core.api.loaders;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Creates;

import java.net.URL;
import java.util.Objects;

@Creates(links = "Loader#")
@API(status = API.Status.STABLE, since = "1.2.8a")
public abstract class LoaderProvider {

    private static LoaderProvider provider;

    public synchronized static Loader forUrl(URL url) {

        Objects.requireNonNull(url);

        return getProvider().getLoader(url);
    }

    public static LoaderProvider getProvider() {

        if (provider == null)
            return LoaderProviderImpl.getInstance();

        return provider;
    }

    @SuppressWarnings("unused")
    public synchronized static void setProvider(@NotNull LoaderProvider provider) {

        Objects.requireNonNull(provider);

        LoaderProvider.provider = provider;
    }

    public abstract Loader getLoader(URL url);

}
