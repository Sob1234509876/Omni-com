package top.sob.vanilla.models.auth;

import top.sob.vanilla.models.auth.list.BlackListSA;
import top.sob.vanilla.models.auth.passcode.PasscodeSA;
import top.sob.vanilla.api.game.trans.Operation;

import java.util.LinkedList;
import java.util.List;

public class AuthorizationImpl implements Authorization {

    private final List<SpecificAuthorization> methods = new LinkedList<>();

    {
        getMethods().add(PasscodeSA.getInstance());
        getMethods().add(BlackListSA.getInstance());
    }

    @Override
    public boolean authorize(Operation op) {

        var flag = true;

        for (SpecificAuthorization m : methods)
            flag &= m.authorize(op);

        return flag;
    }

    @Override
    public List<SpecificAuthorization> getMethods() {
        return methods;
    }

}
