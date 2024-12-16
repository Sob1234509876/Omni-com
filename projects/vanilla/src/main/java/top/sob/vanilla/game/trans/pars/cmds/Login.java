package top.sob.vanilla.game.trans.pars.cmds;

import top.sob.vanilla.proof.WIPException;

public class Login extends Command {

    private static final Login INSTANCE = new Login();

    Login() {
    }

    public static Login getInstance() {
        return INSTANCE;
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
