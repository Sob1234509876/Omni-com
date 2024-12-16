package top.sob.vanilla.models.auth;

import top.sob.core.proof.Modifiable;
import top.sob.vanilla.game.trans.Operation;

import java.util.List;

public interface Authorization {

    boolean authorize(Operation op);

    @Modifiable
    List<SpecificAuthorization> getMethods();

}
