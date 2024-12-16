package top.sob.core.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import top.sob.core.ui.Graphic;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public final class UIUtils {

    private UIUtils() {
    }

    private static final Cache<Class<?>, Constructor<?>> CACHE = CacheBuilder.newBuilder().build();

    public static final PrintWriter out = Graphic.getIConsole().getConsole().getOut();
    public static final PrintWriter err = Graphic.getIConsole().getConsole().getErr();
    public static final Scanner in = Graphic.getIConsole().getConsole().getIn();

    @SuppressWarnings("unchecked")
    public static <T> T getInput(Object message, Class<? super T> type) {
        try {
            out.println(message);
            var constructor = CACHE.get(type,
                    () -> type.getConstructor(String.class));
            var tmp = (T) constructor.newInstance(in.nextLine());
            out.flush();
            return tmp;
        } catch (ExecutionException e) {
            throw new IllegalArgumentException("Illegal argument \"type\", unable to find constructor new(String): ", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Runtime exception during construction: ", e);
        }
    }

    public static String getInput(Object message) {
        return getInput(message, String.class);
    }

}
