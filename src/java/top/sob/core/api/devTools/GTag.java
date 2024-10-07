package top.sob.core.api.devTools;

import java.util.Objects;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;

/**
 * A tag tree node, the node could be the root of the tree, a normal node or a
 * leaf node, it could be told with the functions {@link #isNode()},
 * {@link #isRoot()} and {@link #isRoot()}.
 */
public class GTag<T> {

    /**
     * The value of this tag node.
     */
    protected T value;
    /**
     * The parent of this node tag.
     */
    protected GTag<?> parent;
    /**
     * The children of this node tag.
     */
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
     * @return Is it a node
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
     * Gets the child of the tag, except it works more like finding an element from
     * a tree graph.
     * <p>
     * Let the argument {@code indexes} be {0, 2, 1}, then it will return this tag`s
     * 1st child`s 3rd child`s 2nd child.
     *
     * @param indexes The index array of the requested child.
     * @return See above.
     */
    public GTag<?> getChild(int... indexes) {
        GTag<?> tag = this;
        for (int i : indexes) {
            tag = tag.getChildren()[i];
        }
        return tag;
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

    public static GTag<Void> load(String file) throws IOException {
        return load(new File(file));
    }

    public static GTag<Void> load(File file) throws IOException {
        return load(new FileInputStream(file));
    }

    public static GTag<Void> load(InputStream stream) {
        return load(new InputStreamReader(stream));
    }

    @SuppressWarnings("unchecked")
    public static GTag<Void> load(Reader reader) {
        Gson json = new Gson();
        return (GTag<Void>) (json.fromJson(reader, GTag.class));
    }

}
