package top.sob.vanilla.game.trans.pars.cmds;

import top.sob.vanilla.proof.WIPException;
import top.sob.vanilla.utils.TranslationUtils;

public class Chat extends Command {

    private static final Chat INSTANCE = new Chat();

    private Chat() {
    }

    public static Chat getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return TranslationUtils.CHAT_CMD_NAME;
    }

    @Override
    public String getHelp() {
        throw new WIPException();
    }
}
