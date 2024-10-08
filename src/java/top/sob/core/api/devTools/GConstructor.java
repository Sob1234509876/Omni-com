package top.sob.core.api.devTools;

import java.lang.reflect.Constructor;

/**
 * Funny things that is used to copy java reflect`s {@link Constructor}, the only
 * difference is that only one constructor is allowed for a game type.
 *
 * @see GType GType - The place where a game constructor should be obtained
 * @see GInstance GInstance - The instance a constructor constructs.
 */
@FunctionalInterface
public interface GConstructor {

    /**
     * Constructs a new instance with the given arguments.
     *
     * @param args The given arguments for constructing a new game instance.
     * @return The game instance.
     * @see GInstance GInstance - The class of the constructed instance. Similar to
     * Java {@link Object}.
     */
    GInstance newInstance(Object... args);

}
