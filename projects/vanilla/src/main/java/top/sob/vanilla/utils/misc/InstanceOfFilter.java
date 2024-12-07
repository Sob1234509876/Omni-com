package top.sob.vanilla.utils.misc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

public class InstanceOfFilter implements Predicate<Object> {

    public static final Cache<Class<?>, InstanceOfFilter> CACHE = CacheBuilder.newBuilder().build();

    private final Class<?> clazz;

    private InstanceOfFilter(Class<?> clazz) {
        this.clazz = clazz;
    }

    public static InstanceOfFilter forClass(Class<?> clazz) {
        try {
            return CACHE.get(clazz, () -> new InstanceOfFilter(clazz));
        } catch (ExecutionException e) {
            throw new RuntimeException("IDK why :", e);
        }
    }

    @Override
    public boolean test(Object object) {
        return clazz.isInstance(object);
    }

    public Class<?> getInstanceOfType() {
        return clazz;
    }
}
