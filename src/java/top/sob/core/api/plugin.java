package top.sob.core.api;

import java.util.*;

import top.sob.core.api.event.Event;
import top.sob.core.api.event.EventListener;

/** An API with utils to fire events and do stuffs about it. */
public final class plugin {

    /** The list of event listeners, private because the class is final. */
    private static List<EventListener> eventListeners = new LinkedList<>();

    /**
     * Adds an event listener to the last of {@link #eventListeners}.
     * 
     * @see LinkedList#add(Object)
     * @param listener The event listener.
     */
    public static void addEventListener(EventListener listener) {
        eventListeners.add(listener);
    }

    /**
     * Adds an event listener to the preferred index of {@link #eventListeners}.
     * 
     * @param index    The preferred index.
     * @param listener The event listener.
     * @see LinkedList#add(int, Object)
     */
    public static void addEventListener(int index, EventListener listener) {
        eventListeners.add(index, listener);
    }

    /**
     * Removes the event listener at the index of {@link #eventListeners}.
     * 
     * @param index The listener-that-will-be-deleted`s index.
     * @see LinkedList#remove(int)
     */
    public static void removeEventListener(int index) {
        eventListeners.remove(index);
    }

    /**
     * Removes an event listener that is the first one to be equaled to
     * {@code listner} from {@link #eventListeners}.
     * 
     * @param listener The listener that will be deleted.
     * @see LinkedList#remove(Object)
     */
    public static void removeEventListener(EventListener listener) {
        eventListeners.remove(listener);
    }

    /**
     * Fires an event. For every event listener in {@link #eventListeners} , it will
     * iterate through the list and use the {@Link EventListener#act(Event)} method
     * with the fired event.
     * 
     * @param event The fired event.
     */
    public static void fireEvent(Event event) {
        Iterator<EventListener> iterator = eventListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().act(event);
        }
    }

}
