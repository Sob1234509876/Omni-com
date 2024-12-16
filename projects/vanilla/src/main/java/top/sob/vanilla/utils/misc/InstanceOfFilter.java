package top.sob.vanilla.utils.misc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

public class InstanceOfFilter<T> implements Predicate<T> {

    public static final Cache<Class<?>, InstanceOfFilter<?>> CACHE = CacheBuilder.newBuilder().build();

    private final Class<?> clazz;

    private InstanceOfFilter(Class<?> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    public static <T> InstanceOfFilter<T> forClass(Class<T> clazz) {
        try {
            return (InstanceOfFilter<T>) CACHE.get(clazz, () -> new InstanceOfFilter<>(clazz));
        } catch (ExecutionException e) {
            throw new RuntimeException("IDK why :", e);
        }
    }

    @Override
    public boolean test(T object) {
        return clazz.isInstance(object);
    }

    @SuppressWarnings("unchecked")
    public Class<? super T> getInstanceOfType() {
        return (Class<? super T>) clazz;
    }
}
