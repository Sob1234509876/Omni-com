package com.sob.core.api;

public class Event {

    protected final String type;
    protected final Object newValue;
    protected final Object oldValue;
    
    public Event() {
        this("Blank");
    }

    public Event(String type) {
        this(type, null, null);
    }

    public Event(String type, Object newValue, Object oldValue) {
        this.type = type;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

}
