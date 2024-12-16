package top.sob.vanilla.game.trans.pars.cmds;

import top.sob.vanilla.proof.WIPException;

public class Register extends Login {

    private static final Register INSTANCE = new Register();

    private Register() {
        super();
    }

    public static Register getInstance() {
        return INSTANCE;
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
