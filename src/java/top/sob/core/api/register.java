package top.sob.core.api;

import java.util.*;

import top.sob.core.api.devTools.*;

/**
 * An api stored with all the data in-game that are allowed to used to other
 * plugins. E.x : player inventory.
 */
public final class register {

    /** No instance making */
    private register() {
    }

    /** The list of {@link GType}s. */
    public static final List<GType> GT_LIST = new LinkedList<>();

}
