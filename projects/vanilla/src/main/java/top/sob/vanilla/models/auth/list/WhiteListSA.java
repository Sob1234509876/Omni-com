package top.sob.vanilla.models.auth.list;

import org.jetbrains.annotations.NotNull;
import top.sob.core.utils.misc.Wrapper;
import top.sob.vanilla.models.auth.SpecificAuthorization;
import top.sob.vanilla.api.game.trans.Operation;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class WhiteListSA extends Wrapper<Set<InetAddress>> implements SpecificAuthorization {

    private static final WhiteListSA DEFAULT = new WhiteListSA();

    public static WhiteListSA getInstance() {
        return DEFAULT;
    }

    public WhiteListSA() {
        this(new Properties(), new HashSet<>());
    }

    public WhiteListSA(@NotNull Properties properties) {
        this(properties, new HashSet<>());
    }

    public WhiteListSA(@NotNull Properties properties, @NotNull Set<InetAddress> init) {
        super(properties, init);
    }

    @Override
    public boolean authorize(Operation op) {
        return getBody().contains(op.getFrom());
    }

}
