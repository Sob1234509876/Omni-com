package top.sob.core.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ApiUtils {

    private ApiUtils() {
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <V> V getValueBySystem(@NotNull String key, boolean nonNull) {

        Objects.requireNonNull(key);

        var tmp = System.getProperties().get(key);

        if (tmp == null)
            return null;

        if (tmp instanceof Method) {
            ((Method) tmp).setAccessible(true);
            try {
                return (V) (((Method) tmp).invoke(null));
            } catch (IllegalAccessException | InvocationTargetException ignored) {
            }
        }

        if (tmp instanceof Field) {
            ((Field) tmp).setAccessible(true);
            try {
                return (V) (((Field) tmp).get(null));
            } catch (IllegalAccessException ignored) {
            }
        }

        try {
            return (V) tmp;
        } catch (ClassCastException ignored) {
        }

        if (nonNull)
            throw new UnsupportedOperationException();

        return null;
    }

    public static <V> V getValueBySystem(@NotNull String key) {
        return getValueBySystem(key, true);
    }

}
