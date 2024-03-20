package src.utils;

import java.util.ArrayList;

//TODO : this.getLenth()

public class reg<T> {

    private ArrayList<T> list;
    private String name;
    private T type;

    public reg(String name) {
        this.name = name;
    }

    /**
     * The same usage of {@code ArrayList}.
     * 
     * @param index the index of the object you wish to get
     * @return the object
     * @see ArrayList#get(int)
     */

    public T get(Integer index) {
        return list.get(index);
    }

    /**
     * The same usage of {@code ArrayList}.
     * 
     * @param object the object you want to set to
     * @param index  the index of the parameter {@code object}
     * @see ArrayList#set(int, Object)
     */

    public void set(T object, Integer index) {
        this.list.set(index, object);
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.getName(), this.type.getClass().toString());
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type.getClass();
    }

}
