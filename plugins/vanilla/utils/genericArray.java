package vanilla.utils;

import java.util.Arrays;

/** Just a class for creating generic arrays */
public class genericArray<T> {
    private T[] array;
    private int pointer = 0;

    public void resetPointer() {
        pointer = 0;
    }

    /**
     * Creates an array with the size of {@code size}.
     * 
     * @param size the size of the array.
     */
    @SuppressWarnings("unchecked")
    public genericArray(int size) {
        array = (T[]) new Object[size];
    }

    /**
     * Sets the value of the given index.
     * 
     * @param index the index.
     * @param value the value.
     * @return the orignal value.
     */
    public T setElement(int index, T value) {
        T T = array[index];
        array[index] = value;
        return T;
    }

    /**
     * Gets the value of the array in the given index.
     * 
     * @param index the index
     * @return the value.
     */
    public T getElement(int index) {
        return array[index];
    }

    /**
     * Returns the length of this.
     * 
     * @return the length of this.
     */
    public int length() {
        return array.length;
    }

    /** @see Arrays#toString(Object) */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    /**
     * 
     * @return
     */
    public T[] getArray() {
        return array;
    }

    /**
     * 
     * @param value
     */
    public void append(T value) {
        setElement(pointer, value);
    }

}
