package top.sob.vanilla.api;

import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.api.devTools.GInstance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class GTs {

    private static final Set<GInstance> registered = new HashSet<>();

    private GTs() {
    }

    public static void register(GInstance... clazz) {
        Collections.addAll(registered, clazz);
    }

    @Unmodifiable
    public static Set<GInstance> getRegistered() {
        return Collections.unmodifiableSet(registered);
    }

}
