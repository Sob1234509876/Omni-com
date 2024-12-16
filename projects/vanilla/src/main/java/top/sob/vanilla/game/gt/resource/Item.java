package top.sob.vanilla.game.gt.resource;

import org.jetbrains.annotations.NotNull;

import top.sob.core.api.devTools.Amount;
import top.sob.vanilla.game.gt.politic.Property;

public interface Item extends Property {

    @NotNull MatterState getState();

    PhysicalProperty getProperties();

    @NotNull Amount getWorth();

    enum MatterState {
        GAS("mol"),
        LIQUID("L"),
        SOLID("kg"),
        PLASMA("mol"),
        DEGENERATE_MATTER("t"),
        SUPER_SOLID("t"),
        BEC("u"),
        QGP("u"),
        PHYSICAL("m"),
        ABSTRACT("");

        private final String unit;

        MatterState(String unit) {
            this.unit = unit;
        }

        public String getUnit() {
            return unit;
        }
    }

    enum PhysicalProperty {
        NORMAL,
        SUPER_FLUIDITY,
        SUPER_CONDUCTIVITY,
        CRYSTAL,
        LIQUID_CRYSTAL
    }

}
