package top.sob.vanilla.util;

import org.jetbrains.annotations.Nullable;

public class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    @SuppressWarnings("unused")
    public T1 getFirst() {
        return first;
    }

    @SuppressWarnings("unused")
    public T2 getSecond() {
        return second;
    }

    @SuppressWarnings("unused")
    public Pair<T1, T2> setFirst(T1 first) {
        this.first = first;
        return this;
    }

    @SuppressWarnings("unused")
    public Pair<T1, T2> setSecond(T2 second) {
        this.second = second;
        return this;
    }

    @SuppressWarnings("unused")
    public Pair(@Nullable T1 first, @Nullable T2 second) {
        this.first = first;
        this.second = second;
    }

    @SuppressWarnings("unused")
    public Pair() {
        this(null, null);
    }

}

