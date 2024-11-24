package top.sob.vanilla.api.game.trans.pars;

import org.jetbrains.annotations.NotNull;
import top.sob.vanilla.api.game.trans.Parameter;

import java.util.*;

public abstract class Command extends HashMap<String, Parameter> implements Parameter {

    public static final String UNKNOWN_NAME = "?";

    private final String name;

    @SuppressWarnings("unused")
    public Command() {
        this(UNKNOWN_NAME);
    }

    @SuppressWarnings("unused")
    public Command(@NotNull String name) {
        Objects.requireNonNull(name);

        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        var sb = new StringBuilder();

        forEach((k, v) -> {
            var v2 = (v == null ? "" : "=" + v);
            sb.append("--").append(k).append(v2).append(' ');
        });

        return sb.toString();
    }

    @SuppressWarnings("unused")
    public String[] toArgs() {

        var args = new LinkedList<String>();
        var sb = new StringBuilder();

        forEach((k, v) -> {
            var v2 = (v == null ? "" : "=" + v);
            args.add(sb.append("-").append(k).append(v2).toString());
            sb.delete(0, sb.length());
        });

        return args.toArray(new String[0]);
    }


}
