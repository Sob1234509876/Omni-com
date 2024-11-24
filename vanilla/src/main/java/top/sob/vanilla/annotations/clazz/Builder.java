package top.sob.vanilla.annotations.clazz;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@SuppressWarnings("unused")
public abstract class Builder<T> implements Serializable {

    @NotNull
    public abstract T build();

}
