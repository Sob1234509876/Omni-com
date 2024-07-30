package top.sob.core.api.devTools;

import top.sob.core.api.*;

/**
 * A game type, can be created from a {@link GTemplate}. A game type is like a
 * Java {@link Class}, you can make instances of a game type.
 */
public class GType {

    /** The name of this game type. */
    protected String name;
    /** The description of this game type. */
    protected String description;
    /** Flags of this game type. */
    protected Object[] flags;

    /**
     * Creates a new game type from a {@link GTemplate}. It will sets the game
     * type`s
     * name, description and flags using the template.
     * 
     * @param temp The given template.
     */
    protected GType(GTemplate temp) {
        this.name = temp.getName();
        this.description = temp.getDescription();
        this.flags = temp.getFlags();

        register.GT_LIST.add(this);
    }

    /**
     * Similar to the method {@link Class#getConstructor(Class...)}, but every game
     * type only has one constructor. The default constructor (The returned value of
     * {@link #getDefConstructor()}) has only one argument and should be a game
     * type. The returned value is a game instance ({@link GInstance}) that is been
     * constructed through the constructor {@link GInstance#GInstance(GType)}.
     * 
     * @return
     */
    public GConstructor getConstructor() {
        return getDefConstructor();
    }

    private GConstructor getDefConstructor() {
        return (Object[] args) -> {

            if (args.length != 1) {
                throw new IllegalArgumentException("Illegal argument amount");
            } else if (args[0].getClass() != GType.class) {
                throw new IllegalArgumentException("Illegal argument class");
            }

            return new GInstance((GType) (args[0]));

        };
    }

    /**
     * Gets this game type`s name.
     * 
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets this game type`s description.
     * 
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets this game type`s flags.
     * 
     * @return The flags.
     */
    public Object[] getFlags() {
        return flags;
    }

}
