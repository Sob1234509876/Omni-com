package top.sob.vanilla.game.gt.politic;

import org.jetbrains.annotations.Nullable;

public interface Property extends Resource {

    boolean needLicense();

    @Nullable License getLicense();

}
