package top.sob.vanilla.util.serialize;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.sob.vanilla.annotations.Template;

import java.io.Serializable;

@Template
public abstract class SpecialSerializer<I, O> implements Serializable {

    @SuppressWarnings("unused")
    @NotNull
    public abstract O writeObject(@Nullable I obj);

    @SuppressWarnings("unused")
    @Nullable
    public abstract I readObject(O data);

}
