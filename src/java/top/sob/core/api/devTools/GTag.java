package top.sob.core.api.devTools;

import java.util.*;

import com.google.gson.Gson;

import java.io.*;

/**
 * A tag tree node, the node could be the root of the tree, a normal node or a
 * leaf node, it could be telled with the functions {@link #} and {@link #}.
 */
public class GTag<T> {

    /** The value of this tag node. */
    protected T value;
    /** The parent of this node tag. */
    protected GTag<?> parent;
    /** The children of this node tag. */
    protected GTag<?>[] children;

    /**
     * Tells that is this tag a root tag node, equivalent to
     * 
     * <pre>{@code
     * Objects.isNull(parent);
     * }</pre>
     * 
     * @return Is this a root node tag.
     */
    public boolean isRoot() {
        return Objects.isNull(parent);
    }

    /**
     * Tells that is this tag a leaf tag node, equivalent to
     * 
     * <pre>{@code
     * Objects.isNull(children) || children.length == 0;
     * }</pre>
     * 
     * @return Is this a leaf node tag.
     */
    public boolean isLeaf() {
        return Objects.isNull(children) || children.length == 0;
    }

    /**
     * Tells that is this tag a normal node of a tag "tree", equivalent to
     * 
     * <pre>{@code
     *  !(isLeaf() || isRoot());
     * }</pre>
     * 
     * @return
     */
    public boolean isNode() {
        return !(isLeaf() || isRoot());
    }

    /**
     * Gets the value of this node.
     * 
     * @return The value of this node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets the parent of this node.
     * 
     * @return The parent of this node.
     */
    public GTag<?> getParent() {
        return parent;
    }

    /**
     * Gets the children of this node.
     * 
     * @return The children of this node.
     */
    public GTag<?>[] getChildren() {
        return children;
    }

    /**
     * Sets the value of this node.
     * 
     * @param value The new value.
     * @return This tag.
     */
    public GTag<T> setValue(T value) {
        this.value = value;
        return this;
    }

    /**
     * Sets the parent of this node.
     * 
     * @param parent The new parent.
     * @return This tag.
     */
    public GTag<T> setParent(GTag<?> parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Sets the children of this node.
     * 
     * @param children The new children.
     * @return This tag.
     */
    public GTag<T> setChildren(GTag<?>[] children) {
        this.children = children;
        return this;
    }

    public static GTag<Void> load(String file) throws FileNotFoundException, IOException {
        return load(new File(file));
    }

    public static GTag<Void> load(File file) throws FileNotFoundException, IOException {
        return load(new FileInputStream(file));
    }

    public static GTag<Void> load(InputStream stream) throws IOException {
        return load(new InputStreamReader(stream));
    }

    @SuppressWarnings("unchecked")
    public static GTag<Void> load(Reader reader) {
        Gson json = new Gson();
        return (GTag<Void>) (json.fromJson(reader, GTag.class));
    }

}
