package top.sob.vanilla.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.vanilla.game.trans.Parameter;

import java.math.BigDecimal;
import java.math.MathContext;

public class Real extends BigDecimal implements Parameter {

    @SuppressWarnings("unused")
    public Real(@NotNull String val) {
        super(val);
    }

    @SuppressWarnings("unused")
    public Real(@NotNull String val, @NotNull MathContext mc) {
        super(val, mc);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getHelp() {
        return "";
    }
}
