package top.sob.vanilla.api.game.trans.pars.cmds;

import top.sob.vanilla.exceptions.proof.WIPException;
import top.sob.vanilla.utils.TranslationUtils;

@SuppressWarnings("unused")
public class Buy extends Command {

    private static final Buy INSTANCE = new Buy();

    private Buy() {
    }

    public static Buy getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return TranslationUtils.BUY_CMD_NAME;
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }

}
