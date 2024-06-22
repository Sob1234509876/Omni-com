package top.sob.core.api.event; // A bit too long

/**
 * An event class that can be used as transmitting signals and broadcasts across
 * the game. Should be used with {@link EventListener}.
 * 
 * @see EventListener
 */
public class Event {

    /** The type of event */
    protected final String type;
    /**
     * If there is value change, then this is the value after change
     * 
     * @see #oldValue
     */
    protected final Object newValue;
    /**
     * If there is value change, then this is the value before change
     * 
     * @see #newValue
     */
    protected final Object oldValue;

    /**
     * Creates an event with a type "Blank"
     * 
     * @see #Event(String)
     */
    public Event() {
        this("Blank");
    }

    /**
     * Creates an event using the given type string. The {@link #newValue} and
     * {@link #oldValue} are all null.
     * 
     * @param type The given type to construct an event.
     * @see #Event()
     * @see #Event(String, Object, Object)
     */
    public Event(String type) {
        this(type, null, null);
    }

    /**
     * Creates an event with the given type string and the old and new values.
     * 
     * @param type     The given type string.
     * @param newValue The changed value(s) after event.
     * @param oldValue The changed value(s) before event.
     */
    public Event(String type, Object newValue, Object oldValue) {
        this.type = type;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    @Override
    public String toString() {
        return String.format("top.sob.vanilla.core.api.Event<%s: %s, %s>", type, newValue.toString(),
                oldValue.toString());
    }

}
