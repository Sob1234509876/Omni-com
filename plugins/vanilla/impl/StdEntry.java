package vanilla.impl;

import java.util.Map.*;

/**
 * A entry in the most simplest way to create.
 */
public class StdEntry<K, V> implements Entry<K, V> {

    private K key;
    private V value;

    /** Creates a empty key-value entry. */
    public StdEntry() {
    }

    /**
     * Creates a key-value entry.
     * 
     * @param key   the key
     * @param value the data
     */
    public StdEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        V t = this.value;
        this.value = value;
        return t;
    }

}
