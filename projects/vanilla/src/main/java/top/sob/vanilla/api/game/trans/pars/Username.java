package top.sob.vanilla.api.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.vanilla.exceptions.proof.WIPException;

import java.util.Properties;

public class Username extends Text {
    public Username(@NotNull Properties header, @NotNull String body) {
        super(header, body);
    }

    public Username(@NotNull String body) {
        super(body);
    }

    @Override
    public String getName() {
        var a = "";
        throw new WIPException();
    }

    @Override
    public String getHelp() {
        var a = "";
        throw new WIPException();
    }
}
