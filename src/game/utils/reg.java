package game.utils;

import java.util.*;

/**
 * {@code reg<T>}, known as register array. The usage of it is to create a array
 * to store your created items, machines and etc. It is also used to prevent
 * threads from overriding your newly created objects. Uses {@code ArrayList} to
 * store objects.
 * 
 * @see ArrayList
 * @version 1.1.1a
 */
public class Reg<T> {

    private ArrayList<T> list = new ArrayList<T>();
    private String name;
    private T type;

    /**
     * Creates a register array using the name of {@code String name}.
     * 
     * @param name
     * @see ArrayList
     */
    public Reg(String name) {
        this.name = name;
    }

    public Iterator<T> iterator() {
        return list.iterator();
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

    /**
     * The same usage of {@code ArrayList}.
     * 
     * @param object the object you want to add
     * @see ArrayList#add(Object)
     */

    public void add(T object) {
        this.list.add(object);
    }

    /**
     * The same usage of {@code ArrayList}.
     * 
     * @return the size of this
     * @see ArrayList#size()
     */
    public Integer size() {
        return this.list.size();
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
