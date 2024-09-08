package top.sob.core.api.event;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An API with utils to fire events and do stuffs about it.
 * 
 * @see ArrayList
 * @see List
 */
public final class Events {

    /** The list of event listeners, private because the class is final. */
    private static List<EventListener> eventListeners = new ArrayList<>();

    /** No instance constructing */
    private Events() {
    }

    /**
     * Adds an event listener to the last of {@link #eventListeners}.
     * 
     * @see LinkedList#add(Object)
     * @return true (See {@link Collection#add(Object)}).
     * @param listener The event listener.
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
     * @return The orignal event listener (See {@link List#remove(int)}).
     * @see LinkedList#remove(int)
     */
    public static synchronized EventListener removeEventListener(int index) {
        return eventListeners.remove(index);
    }

    /**
     * Removes an event listener that is the first one to be equaled to
     * {@code listner} from {@link #eventListeners}.
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
     * iterate through the list and use the {@Link EventListener#act(Event)} method
     * with the fired event.
     * 
     * @param event The fired event.
     */
    public static synchronized void fireEvent(Event event) {
        Iterator<EventListener> iterator = eventListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().act(event);
        }
    }

}
