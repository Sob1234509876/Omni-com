package top.sob.vanilla.models.auth.list;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;
import top.sob.vanilla.models.auth.SpecificAuthorization;
import top.sob.vanilla.api.game.trans.Operation;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class BlackListSA extends Wrapper<Set<InetAddress>> implements SpecificAuthorization {

    private static final BlackListSA DEFAULT = new BlackListSA();

    public BlackListSA() {
        this(new Properties(), new HashSet<>());
    }

    public BlackListSA(@NotNull Properties properties) {
        this(properties, new HashSet<>());
    }

    public BlackListSA(@NotNull Properties properties, @NotNull Set<InetAddress> init) {
        super(properties, init);
    }

    public static BlackListSA getInstance() {
        return DEFAULT;
    }

    @Override
    public boolean authorize(Operation op) {
        return !getBody().contains(op.getFrom());
    }

}
