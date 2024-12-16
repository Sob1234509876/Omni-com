package top.sob.vanilla.game.trans.pars.cmds;

import top.sob.vanilla.game.trans.Parameter;

public abstract class Command implements Parameter {

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

}
