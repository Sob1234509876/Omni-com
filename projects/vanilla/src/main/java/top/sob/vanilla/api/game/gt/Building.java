package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.DynamicGInstance;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;

public class Building extends DynamicGInstance implements Placeable {

    public Building(@NotNull GTag<?> body, String name) {
        super(body, d -> d.toBigInteger().toString(), name);
    }

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }

    @Override
    public void run() {
        throw new WIPException();
    }

}
