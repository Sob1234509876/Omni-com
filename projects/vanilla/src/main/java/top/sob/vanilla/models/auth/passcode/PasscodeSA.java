package top.sob.vanilla.models.auth.passcode;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import top.sob.core.annotations.proof.NotSafe;
import top.sob.vanilla.api.game.trans.pars.Passcode;
import top.sob.vanilla.api.game.trans.pars.Username;
import top.sob.vanilla.models.auth.SpecificAuthorization;
import top.sob.vanilla.api.game.trans.Operation;
import top.sob.vanilla.api.game.trans.pars.cmds.Login;
import top.sob.vanilla.api.game.trans.pars.cmds.Register;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class PasscodeSA implements SpecificAuthorization {

    private static final PasscodeSA DEFAULT = new PasscodeSA(PasscodeDatabase.getDefault());

    private final Cache<InetAddress, Long> CACHE = CacheBuilder.newBuilder()
            .expireAfterAccess(365, TimeUnit.DAYS)
            .build();

    public static PasscodeSA getInstance() {
        return DEFAULT;
    }

    private final PasscodeDatabase database;

    public PasscodeSA(PasscodeDatabase database) {
        this.database = database;
    }

    @Override
    public boolean authorize(Operation op) {

        if (CACHE.asMap().containsKey(op.getFrom()))
            return true;

        if (op.getBody().contains(Register.getInstance()))
            return register(op);

        if (op.getBody().contains(Login.getInstance()))
            return login(op);

        return false;
    }

    @NotSafe(desc = "This registration operation does not prevent bot registration and also might cause data leaks. This is a technical problem.")
    private boolean register(Operation op) {

        final var username = new String[]{""};
        final var passcode = new String[]{""};

        op.getBody().forEach(p -> {
            if (p instanceof Username)
                username[0] = ((Username) p).getBody();

            if (p instanceof Passcode)
                passcode[0] = ((Passcode) p).getBody();
        });

        getDatabase().put(username[0], passcode[0]);

        return true;
    }

    @NotSafe(desc = "Unsafe transmission.")
    private boolean login(Operation op) {
        return false;
    }

    public PasscodeDatabase getDatabase() {
        return database;
    }
}
