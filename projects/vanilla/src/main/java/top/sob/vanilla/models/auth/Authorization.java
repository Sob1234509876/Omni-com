package top.sob.vanilla.models.auth;

import top.sob.core.annotations.proof.Modifiable;
import top.sob.vanilla.api.game.trans.Operation;

import java.util.List;

public interface Authorization {

    boolean authorize(Operation op);

    @Modifiable
    List<SpecificAuthorization> getMethods();

}
