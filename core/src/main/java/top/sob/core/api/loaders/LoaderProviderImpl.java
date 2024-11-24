package top.sob.core.api.loaders;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import top.sob.core.annotations.Creates;
import top.sob.core.annotations.NotSafe;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@Creates(links = "Loader#this")
@API(status = API.Status.STABLE, since = "1.2.8a")
public class LoaderProviderImpl extends LoaderProvider {

    private static final LoaderProviderImpl INSTANCE = new LoaderProviderImpl();
    private static final Cache<URI, Loader> CACHE = CacheBuilder.newBuilder().build();

    private LoaderProviderImpl() {
    }

    @NotSafe(desc = "See UniversalLoader#findResource(String)")
    @NotNull
    @Override
    public Loader getLoader(@NotNull URL url) {

        Objects.requireNonNull(url);

        URI uri;
        try {
            uri = url.toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            return CACHE.get(uri, () -> new UniversalLoader(url));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public static LoaderProviderImpl getInstance() {
        return INSTANCE;
    }

}
