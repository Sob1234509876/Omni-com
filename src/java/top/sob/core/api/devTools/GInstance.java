package top.sob.core.api.devTools;

import java.math.*;
import java.util.function.*;

/**
 * A new game instance, use for storing inventory data or others. Similar to
 * Java {@link Object}.
 * 
 * @see Object
 */
public class GInstance {

    /** The tag tree. */
    protected final GTag<?> tagTreeRoot;
    /** The game type of this instance. */
    protected final GType gType;

    protected BigInteger B_amount;
    protected BigInteger S_amount;
    protected final Function<BigInteger[], String> GetStringFun;

    /**
     * Creates a new instance of a game type with the given tag.
     * 
     * @param tagTreeRoot The given tag.
     * @param gType       The given type.
     */
    public GInstance(GTag<?> tagTreeRoot, GType gType, Function<BigInteger[], String> fun) {
        this.tagTreeRoot = tagTreeRoot;
        this.gType = gType;
        this.GetStringFun = fun;
    }

    /**
     * Creates a new instance of a game type.
     * 
     * @param gType The given type.
     */
    public GInstance(GType gType, Function<BigInteger[], String> fun) {
        this(null, gType, fun);
    }

    // TODO: This doc
    public GInstance(GType gType) {
        this(gType, (amount) -> String.format("%s whole %s fraction", amount[0], amount[1]));
    }

    /**
     * Gets the type of this instance.
     * 
     * @return The type of this instance.
     * @see Object#getClass()
     */
    public final GType getType() {
        return gType;
    }

    /**
     * Gets the tag root of this instance.
     * 
     * @return The root of this tag tree of this instance.
     */
    public GTag<?> getTag() {
        return tagTreeRoot;
    }

}
