package top.sob.core.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import top.sob.core.ui.Graphic;
import top.sob.core.utils.io.swing.SwingPrintWriter;
import top.sob.core.utils.io.swing.SwingReader;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

public final class UIUtils {

    private UIUtils() {
    }

    private static final Cache<Class<?>, Constructor<?>> CACHE = CacheBuilder.newBuilder().build();

    public static final SwingPrintWriter out = new SwingPrintWriter(Graphic.OUTPUT);
    public static final SwingReader in = new SwingReader(Graphic.INPUT);

    @SuppressWarnings("unchecked")
    public static <T> T getInput(Object message, Class<? super T> type) {
        try {
            out.println(message);
            var constructor = CACHE.get(type,
                    () -> type.getConstructor(String.class));
            var tmp = (T) constructor.newInstance(in.readLine());
            out.flush();
            return tmp;
        } catch (ExecutionException e) {
            throw new IllegalArgumentException("Illegal argument \"type\", unable to find constructor new(String): ", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Runtime exception during construction: ", e);
        } catch (IOException e) {
            throw new RuntimeException("Runtime exception during reading from user: ", e);
        }
    }

    public static String getInput(Object message) {
        return getInput(message, String.class);
    }

}
