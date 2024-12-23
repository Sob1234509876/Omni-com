package top.sob.core.loading;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static top.sob.core.api.Plugins.INIT_FLAG;
import static top.sob.core.api.Plugins.RUN_FLAG;

public class PluginWrapper extends ClassWrapper implements Runnable {

    private final Method INIT_METHOD;
    private final Method RUN_METHOD;
    private final Object INSTANCE;

    public PluginWrapper(@NotNull Class<?> body) {
        super(body);

        if (body.getAnnotation(Plugin.class) == null)
            throw new IllegalArgumentException("Provided class is not a plugin.");

        try {
            INIT_METHOD = getBody().getMethod("init");
            RUN_METHOD = getBody().getMethod("run");
            INSTANCE = getBody().getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Provided class does not have a public method \"init()\" or \"run()\"", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Provided class does not have a public constructor of \"new()\"", e);
        }

    }

    @Override
    public void run() {

        if (getHeader().contains(RUN_FLAG))
            throw new IllegalStateException("Already ran.");

        getHeader().put(RUN_FLAG, RUN_FLAG);

        try {
            RUN_METHOD.invoke(getInstance());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Something flew out :", e);
        }
    }

    public void init() {

        if (getHeader().contains(INIT_FLAG))
            throw new IllegalStateException("Already initialized.");

        getHeader().put(INIT_FLAG, INIT_FLAG);

        try {
            INIT_METHOD.invoke(getInstance());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Something flew out :", e);
        }
    }

    @NotNull
    public Object getInstance() {
        return INSTANCE;
    }

}
