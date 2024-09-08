package top.sob.core.api.devTools;

import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Function;

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
     * 
     * Creates a new instance of the given type, but with a different function to
     * represent the amount of items and some tags that carry information.
     * 
     * @param tagTreeRoot The root of the tags.
     * @param gType       The type.
     * @param fun         The function to represent the amount of item.
     */
    public GInstance(GTag<?> tagTreeRoot, GType gType, Function<BigInteger[], String> fun) {

        Objects.requireNonNull(fun);

        this.tagTreeRoot = tagTreeRoot;
        this.gType = gType;
        this.GetStringFun = fun;
    }

    /**
     * Creates a new instance of the given type, but with a different function to
     * represent the amount of items. Equivalent to
     * 
     * <pre>{@code
     * GInstance(null, gType, fun);
     * }</pre>
     * 
     * @param gType The type.
     * @param fun   The function to represent the amount of item.
     */
    public GInstance(GType gType, Function<BigInteger[], String> fun) {
        this(null, gType, fun);
    }

    /**
     * Creates a new instance of the given type, equivalent to
     * 
     * <pre>{@code
     * GInstance(gType, (amount) -> String.format("%s whole %s fraction", amount[0], amount[1]));
     * }</pre>
     * 
     * @param gType The type.
     */
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
