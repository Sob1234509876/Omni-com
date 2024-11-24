package top.sob.vanilla.api.game.trans;

import top.sob.core.annotations.Immutable;

import java.io.Serializable;

@Immutable
public interface Parameter extends Serializable {

    String getName();

    String getHelp();

}
