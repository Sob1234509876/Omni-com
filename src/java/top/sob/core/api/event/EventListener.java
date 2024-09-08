package top.sob.core.api.event;

/**
 * An event listener that can act with the given function. Can use lambda
 * expressions.
 */
@FunctionalInterface
public interface EventListener extends java.util.EventListener {

    /**
     * This method is been used when the listener had received an event that comes
     * from the data bus or the method {@link Events}.
     * 
     * @param event The event.
     */
    public void act(Event event);

}
