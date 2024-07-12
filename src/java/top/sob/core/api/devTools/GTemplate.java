package top.sob.core.api.devTools;

/** Create your own gt template using this interface */
public abstract class GTemplate {
    /** The gt`s name */
    protected String name;
    /** The gt`s description */
    protected String description;
    /** The gt`s flags */
    protected String[] flags;

    /**
     * Returns the name of this.
     * 
     * @return the name of this
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of this.
     * 
     * @return the description of this
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the flags of this.
     * 
     * @return the flags of this
     */
    public String[] getFlags() {
        return flags;
    }

    /**
     * Sets this name into a new one.
     * 
     * @param o the new name
     * @return returns this
     */
    public GTemplate setName(String o) {
        name = o;
        return this;
    }

    /**
     * Sets this description into a new one.
     * 
     * @param o the new description
     * @return returns this
     */
    public GTemplate setDescription(String o) {
        description = o;
        return this;
    }

    /**
     * Sets this flag array into a new one.
     * 
     * @param o the new flag array
     * @return returns this
     */
    public GTemplate setFlags(String... o) {
        flags = o;
        return this;
    }

}
