package top.sob.vanilla.api.game.gt;

import org.jetbrains.annotations.NotNull;
import top.sob.core.api.devTools.GInstance;
import top.sob.core.api.devTools.GTag;
import top.sob.vanilla.exceptions.proof.WIPException;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.function.Function;

public class Item extends GInstance {

    private final MatterState state;

    public static Function<BigDecimal, String> getAmt2StrFun(MatterState state) {
        return d -> String.format("%s %s", d, state.getUnit());
    }

    public Item(@NotNull GTag<?> body, MatterState state, String name) {
        super(body, getAmt2StrFun(state), name);
        this.state = state;
    }

    public MatterState getState() {
        return state;
    }

    public enum MatterState {
        GAS("mol"),
        LIQUID("L"),
        SOLID("kg"),
        PLASMA("mol"),
        DEGENERATE_MATTER("t"),
        SUPER_SOLID("t"),
        BEC("u"),
        QGP("u"),
        PHYSICAL("m");

        private final String unit;

        MatterState(String unit) {
            this.unit = unit;
        }

        public String getUnit() {
            return unit;
        }
    }

    public enum PhysicalProperty {
        NORMAL,
        SUPER_FLUIDITY,
        SUPER_CONDUCTIVITY,
        CRYSTAL,
        LIQUID_CRYSTAL
    }

    @Override
    public Painter<GInstance> getPainter() {
        throw new WIPException();
    }

}
