package top.sob.core.utils.models.transform.filters;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

public class ProtocolFilter implements Predicate<URL> {

    private static final Cache<String, ProtocolFilter> CACHE = CacheBuilder.newBuilder().build();

    public static ProtocolFilter forProtocol(String protocol) {
        try {
            return CACHE.get(protocol, () -> new ProtocolFilter(protocol));
        } catch (ExecutionException e) {
            throw new RuntimeException("This should not been thrown :", e);
        }
    }

    private final String PROTOCOL;

    private ProtocolFilter(String protocol) {
        PROTOCOL = protocol;
    }

    @Override
    public boolean test(URL url) {
        return url.getProtocol().equals(PROTOCOL);
    }

}

