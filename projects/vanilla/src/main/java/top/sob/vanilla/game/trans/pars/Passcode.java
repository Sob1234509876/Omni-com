package top.sob.vanilla.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.vanilla.proof.WIPException;

import java.util.Properties;

public class Passcode extends Text {
    public Passcode(@NotNull Properties header, @NotNull String body) {
        super(header, body);
    }

    public Passcode(@NotNull String body) {
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
