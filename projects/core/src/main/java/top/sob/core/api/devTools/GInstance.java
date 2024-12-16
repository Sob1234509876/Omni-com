package top.sob.core.api.devTools;

import org.apiguardian.api.API;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@API(status = API.Status.STABLE, since = "1.2.8a")
public interface GInstance {

    @NotNull Painter<GInstance> getPainter();

    @NotNull Amount getAmount();

    @NotNull String getName();

    @NotNull GTag getTag();
}
