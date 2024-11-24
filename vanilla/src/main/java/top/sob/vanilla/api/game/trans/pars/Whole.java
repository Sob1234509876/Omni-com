package top.sob.vanilla.api.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.vanilla.api.game.trans.Parameter;

import java.math.BigInteger;

public class Whole extends BigInteger implements Parameter {

    @SuppressWarnings("unused")
    public Whole(@NotNull String val) {
        super(val);
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
