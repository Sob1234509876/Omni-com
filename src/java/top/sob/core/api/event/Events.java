package top.sob.core.api.event;

import java.util.*;

/**
 * An API with utils to fire events and do stuffs about it.
 *
 * @see ArrayList
 * @see List
 */
public final class Events {

    /**
     * The list of event listeners, private because the class is final.
     */
    private static List<EventListener> eventListeners = new LinkedList<>();

    /**
     * No instance constructing
     */
    private Events() {
    }

    /**
     * Adds an event listener to the last of {@link #eventListeners}.
     *
     * @param listener The event listener.
     * @return true (See {@link Collection<>#add(Object)}).
     * @see LinkedList#add(Object)
     */
    public static synchronized boolean addEventListener(EventListener listener) {
        return eventListeners.add(listener);
    }

    /**
     * Adds an event listener to the preferred index of {@link #eventListeners}.
     *
     * @param index    The preferred index.
     * @param listener The event listener.
     * @see LinkedList#add(int, Object)
     */
    public static synchronized void addEventListener(int index, EventListener listener) {
        eventListeners.add(index, listener);
    }

    /**
     * Removes the event listener at the index of {@link #eventListeners}.
     *
     * @param index The listener-that-will-be-deleted`s index.
     * @return The original event listener (See {@link List#remove(int)}).
     * @see LinkedList#remove(int)
     */
    public static synchronized EventListener removeEventListener(int index) {
        return eventListeners.remove(index);
    }

    /**
     * Removes an event listener that is the first one to be equaled to
     * {@code listener} from {@link #eventListeners}.
     *
     * @param listener The listener that will be deleted.
     * @return {@code true} if this contains the event listener.
     * @see LinkedList#remove(Object)
     */
    public static synchronized boolean removeEventListener(EventListener listener) {
        return eventListeners.remove(listener);
    }

    /**
     * Fires an event. For every event listener in {@link #eventListeners} , it will
     * iterate through the list and use the {@link EventListener#act(Event)} method
     * with the fired event.
     *
     * @param event The fired event.
     */
    public static synchronized void fireEvent(Event event) {
        for (EventListener eventListener : eventListeners) {
            eventListener.act(event);
        }
    }

}
