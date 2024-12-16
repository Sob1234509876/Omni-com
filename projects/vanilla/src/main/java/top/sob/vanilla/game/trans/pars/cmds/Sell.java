package top.sob.vanilla.game.trans.pars.cmds;

import top.sob.vanilla.proof.WIPException;
import top.sob.vanilla.utils.TranslationUtils;

public class Sell extends Command {

    private static final Sell INSTANCE = new Sell();

    private Sell() {
    }

    public static Sell getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return TranslationUtils.SELL_CMD_NAME;
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }
}
