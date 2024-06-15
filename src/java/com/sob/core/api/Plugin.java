package com.sob.core.api;

import java.util.*;

public class Plugin {

    private static List<EventListener> eventListeners = new LinkedList<>();

    public static void addEventListener(EventListener listener) {
        eventListeners.add(listener);
    }

    public static void removeEventListener(int index) {
        eventListeners.remove(index);
    }

    public static void removeEventListener(EventListener listener) {
        eventListeners.remove(listener);
    }

    public static void fireEvent(Event event) {
        Iterator<EventListener> iterator = eventListeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().act(event);
        }
    }

}
