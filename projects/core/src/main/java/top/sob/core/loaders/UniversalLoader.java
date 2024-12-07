package top.sob.core.loaders;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.core.annotations.proof.NotSafe;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@NotSafe(desc = "See method #findResource(String)")
@API(status = API.Status.STABLE, since = "1.2.8a")
public class UniversalLoader implements Loader {

    private boolean isClosed = false;
    private final URL baseUrl;

    public UniversalLoader(@NotNull URL url) {
        Objects.requireNonNull(url);
        baseUrl = url;
    }

    @NotSafe(desc = "Might return an unchecked url")
    @Nullable
    @Override
    public URL findResource(@NotNull String name) {

        if (isClosed)
            throw new RuntimeException(new IOException("Loader closed"));

        Objects.requireNonNull(name);

        try {
            return new URL(baseUrl, name);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override
    public void close() {
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
