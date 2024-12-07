package top.sob.vanilla.api.game.trans.pars.cmds;

import top.sob.vanilla.exceptions.proof.WIPException;
import top.sob.vanilla.utils.TranslationUtils;

public class Use extends Command {

    private static final Use INSTANCE = new Use();

    private Use() {
    }

    public static Use getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return TranslationUtils.USE_CMD_NAME;
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }

}
