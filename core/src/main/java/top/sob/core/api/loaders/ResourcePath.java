package top.sob.core.api.loaders;

import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.core.annotations.Mutable;
import top.sob.core.exceptions.MultiThrowable;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.stream.Stream;

@Mutable
@API(status = API.Status.STABLE, since = "1.2.8a")
public class ResourcePath implements Closeable {

    private final Queue<URL> UNOPENED_URLS = new ArrayDeque<>();
    private final LinkedList<Loader> LOADERS = new LinkedList<>();
    private boolean closed = false;

    public ResourcePath() {
    }

    @SuppressWarnings("unused")
    public ResourcePath(URL[] urls) {
        UNOPENED_URLS.addAll(Arrays.asList(urls));
    }

    @SuppressWarnings("unused")
    public ResourcePath(Collection<URL> urls) {
        UNOPENED_URLS.addAll(urls);
    }

    public synchronized void addResource(@NotNull URL url) {

        Objects.requireNonNull(url);

        UNOPENED_URLS.add(url);
    }

    @SuppressWarnings("unused")
    public synchronized boolean addResources(@NotNull URL[] urls) {

        Objects.requireNonNull(urls);

        return addResources(Arrays.asList(urls));
    }


    public synchronized boolean addResources(@NotNull Collection<URL> urls) {

        Objects.requireNonNull(urls);

        var lst = new LinkedList<URL>();
        urls.stream().filter(Objects::nonNull).forEach(lst::add);

        return UNOPENED_URLS.addAll(lst);
    }

    @NotNull
    public synchronized URL[] findResources(@NotNull String name) {

        if (closed) throw new IllegalStateException("Path closed.");

        Objects.requireNonNull(name);

        var tmp = (Loader) null;
        var tmp2 = (URL) null;
        var list = new LinkedList<URL>();

        for (int i = 0; (tmp = getLoader(i)) != null; i++) {
            tmp2 = tmp.findResource(name);

            if (tmp2 != null) list.add(tmp2);
        }

        return list.toArray(new URL[0]);

    }

    @NotNull
    public synchronized InputStream[] findResourcesAsStreams(@NotNull String name) {

        Objects.requireNonNull(name);

        var lst = new LinkedList<InputStream>();
        var t = new MultiThrowable();

        Stream.of(findResources(name)).forEach((url -> {
            try {
                lst.add(url.openStream());
            } catch (IOException e) {
                t.addThrowable(e);
            }
        }));

        if (!t.getThrowable().isEmpty()) throw new RuntimeException(t);

        return lst.toArray(new InputStream[0]);

    }

    @Nullable
    public synchronized InputStream findResourceAsStream(@NotNull String name, int index) {
        Objects.requireNonNull(name);

        var tmp = findResourcesAsStreams(name);

        if (tmp.length < index)
            return null;

        return tmp[index];
    }

    @SuppressWarnings("unused")
    @Nullable
    public synchronized InputStream findResourceAsStream(@NotNull String name) {
        Objects.requireNonNull(name);

        return findResourceAsStream(name, 0);
    }

    @Nullable
    public synchronized URL findResource(@NotNull String name) {
        return findResource(name, 0);
    }

    @Nullable
    public synchronized URL findResource(@NotNull String name, int i) {
        return findResources(name)[i];
    }

    private synchronized Loader getLoader(int i) {

        if (closed) return null;

        if (LOADERS.size() > i) return LOADERS.get(i);

        var tmp = UNOPENED_URLS.poll();

        if (tmp == null) return null;

        LOADERS.add(LoaderProvider.forUrl(tmp));
        return LOADERS.getLast();
    }

    @Override
    public synchronized void close() throws IOException {

        var t = new MultiThrowable();

        LOADERS.stream().filter(Objects::nonNull).forEach((l) -> {
            try {
                l.close();
            } catch (IOException e) {
                t.addThrowable(e);
            }
        });

        if (!t.getThrowable().isEmpty()) throw new IOException(t);

        closed = true;
    }
}
