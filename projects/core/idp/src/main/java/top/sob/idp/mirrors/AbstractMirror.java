package top.sob.idp.mirrors;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractMirror extends HashSet<String> implements Mirror {
    public AbstractMirror() {
    }

    public AbstractMirror(@NotNull Collection<? extends String> c) {
        super(c);
    }

    public AbstractMirror(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public AbstractMirror(int initialCapacity) {
        super(initialCapacity);
    }
}
