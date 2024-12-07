package top.sob.vanilla.models.auth;

import top.sob.vanilla.api.game.trans.Operation;

public interface SpecificAuthorization {

    boolean authorize(Operation op);

}
