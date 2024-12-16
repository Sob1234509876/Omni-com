package top.sob.core.utils;

import top.sob.core.proof.Modifiable;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    @Modifiable
    public static <T, R> R[] castArray(T[] array, R[] holder, Function<T, R> cast) {
        return Stream.of(array).map(cast).toList().toArray(holder);
    }

    @SafeVarargs
    public static <T> List<T> concat(T[]... arrays) {
        var lst = new LinkedList<T>();

        for (T[] array : arrays)
            Collections.addAll(lst, array);

        return lst;
    }

    public static final class Specific {
        private Specific() {
        }

        public static URL[] castArray(URI[] array) {
            return ArrayUtils.castArray(array, new URL[0], uri -> {
                try {
                    return uri.toURL();
                } catch (MalformedURLException mue) {
                    return null;
                }
            });
        }

        public static URI[] castArray(URL[] array) {
            return ArrayUtils.castArray(array, new URI[0], url -> {
                try {
                    return url.toURI();
                } catch (URISyntaxException mue) {
                    return null;
                }
            });
        }
    }

}
