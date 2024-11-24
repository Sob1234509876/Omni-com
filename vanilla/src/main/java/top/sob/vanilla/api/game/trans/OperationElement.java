package top.sob.vanilla.api.game.trans;

import top.sob.core.annotations.Immutable;

import java.io.Serializable;

@SuppressWarnings("unused")
@Immutable
public abstract class OperationElement implements Serializable {

    public abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
