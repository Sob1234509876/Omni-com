package top.sob.vanilla.api.game.trans.pars.cmds;

import top.sob.vanilla.exceptions.proof.WIPException;
import top.sob.vanilla.utils.TranslationUtils;

public class Info extends Command {


    private static final Info INSTANCE = new Info();

    private Info() {
    }

    public static Info getInstance() {
        return INSTANCE;
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }

    @Override
    public String getName() {
        return TranslationUtils.CHAT_CMD_NAME;
    }
}
