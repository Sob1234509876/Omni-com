package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.DynamicGInstance;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;
import java.math.BigDecimal;

public class Player extends DynamicGInstance implements Entity {

    private boolean aliveness = true;
    private BigDecimal hp = BigDecimal.ONE;

    public Player(@NotNull GTag<?> body, String name) {
        super(body, d -> "1", name);
    }

    @Override
    public void run() {
        throw new WIPException();
    }

    @Override
    public void setAliveness(boolean b) {
        aliveness = b;
    }

    @Override
    public boolean isAliveness() {
        return aliveness;
    }

    @Override
    public void setHp(BigDecimal hp) {
        this.hp = hp;
    }

    @Override
    public BigDecimal getHp() {
        return hp;
    }

    @Override
    public void uponDeath() {
        throw new WIPException();
    }

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }

}
