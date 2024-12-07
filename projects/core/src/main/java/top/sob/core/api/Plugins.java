package top.sob.core.api;

import top.sob.core.utils.misc.Wrapper;
import top.sob.core.loading.PluginWrapper;
import top.sob.core.loading.ScriptWrapper;

import java.util.*;

public class Plugins {

    private static final Set<Wrapper<Class<?>>> REGISTERED = new HashSet<>();

    public static final String INIT_FLAG = "finish-init";
    public static final String RUN_FLAG = "finish-run";

    @SuppressWarnings("unchecked")
    public static void register(Wrapper<Class<?>> wrapper) {
        register(new Wrapper[]{wrapper});
    }

    public static void register(Collection<? extends Wrapper<Class<?>>> wrapper) {
        REGISTERED.addAll(wrapper);
    }

    public static void register(Wrapper<Class<?>>[] wrapper) {
        register(Arrays.asList(wrapper));
    }

    public static void init() {

        REGISTERED.forEach(wrapper -> {

            if (wrapper instanceof PluginWrapper) {
                try {
                    ((PluginWrapper) wrapper).init();
                } catch (Throwable ex) {
                    throw new RuntimeException("", ex);
                }
            }

        });

    }

    public static void run() {

        REGISTERED.forEach(wrapper -> {

            if (wrapper instanceof PluginWrapper) {
                try {
                    ((PluginWrapper) wrapper).run();
                } catch (Throwable ex) {
                    throw new RuntimeException("", ex);
                }
            }

        });

    }

    /**
     * Scripts are re-runnable plugins, so this is safe by definition. One will not need to prevent a script been run multiple times, unlike plugins.
     */
    public static Set<ScriptWrapper> getScripts() {
        var set = new HashSet<ScriptWrapper>();

        REGISTERED.forEach(wrapper -> {
            if (wrapper instanceof ScriptWrapper)
                set.add((ScriptWrapper) wrapper);
        });

        return set;
    }

    public static Set<Wrapper<Class<?>>> getRegistered() {
        return Collections.unmodifiableSet(REGISTERED);
    }
}
