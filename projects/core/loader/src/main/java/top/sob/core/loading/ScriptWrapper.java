package top.sob.core.loading;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScriptWrapper extends ClassWrapper implements Runnable {

    private final Method RUN_METHOD;
    private final Object INSTANCE;

    public ScriptWrapper(@NotNull Class<?> body) {
        super(body);

        if (body.getAnnotation(Plugin.class) == null)
            throw new IllegalArgumentException("Provided class is not a plugin.");

        try {
            RUN_METHOD = getBody().getMethod("run");
            INSTANCE = getBody().getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Provided class does not have a public method \"run()\"", e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Provided class does not have a public constructor of \"new()\"", e);
        }

    }

    @Override
    public void run() {
        try {
            RUN_METHOD.invoke(getInstance());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("This should not been thrown", e);
        }
    }

    @NotNull
    public Object getInstance() {
        return INSTANCE;
    }

}
