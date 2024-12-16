package top.sob.vanilla.models.auth;

import top.sob.vanilla.game.trans.Operation;

public interface SpecificAuthorization {

    boolean authorize(Operation op);

}
