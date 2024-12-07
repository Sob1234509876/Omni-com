package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;
import java.util.Collections;
import java.util.Set;

public class Recipe extends GInstance {

    private final Set<Item> input;
    private final Set<Item> output;
    private final int duration;

    public Recipe(@NotNull GTag<?> body, @NotNull String name, Set<Item> input, Set<Item> output, int duration) {
        super(body, d -> d.toBigInteger().toString(), name);

        this.duration = duration;
        this.input = input;
        this.output = output;
    }

    public int getDuration() {
        return duration;
    }

    @Unmodifiable
    public Set<Item> getInput() {
        return Collections.unmodifiableSet(input);
    }

    @Unmodifiable
    public Set<Item> getOutput() {
        return Collections.unmodifiableSet(output);
    }

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }
}
