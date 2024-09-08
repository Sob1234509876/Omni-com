package top.sob.core.api;

import java.util.List;
import java.util.LinkedList;

import top.sob.core.api.devTools.GType;

/**
 * An api stored with all the gt created.
 */
public final class register {

    /** No instance making */
    private register() {
    }

    /** The list of {@link GType}s. */
    public static final List<GType> GT_LIST = new LinkedList<>();

}
