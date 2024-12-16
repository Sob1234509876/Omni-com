package top.sob.vanilla.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;
import top.sob.vanilla.game.trans.Parameter;
import top.sob.vanilla.proof.WIPException;

import java.util.Properties;

public class Text extends Wrapper<String> implements Parameter {

    public Text(@NotNull Properties header, @NotNull String body) {
        super(header, body);
    }

    public Text(@NotNull String body) {
        super(body);
    }

    @Override
    public String getName() {
        throw new WIPException();
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }
}
