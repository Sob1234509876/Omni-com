package vanilla.utils;

/**
 * Used for setting varible values in methods
 * 
 * @see search#SearchInv(String, wrapper, wrapper)
 * @see search#searchInvEntry(String, wrapper, wrapper)
 */
public class wrapper<T> {

    public T data;

    /** Creates a empty wrapper */
    public wrapper() {
    }

    /**
     * Creates a wrapper with it`s value set to {@code data}
     * 
     * @param data
     */
    public wrapper(T data) {
        this.data = data;
    }

}
