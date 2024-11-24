package top.sob.vanilla.api.game.trans;

import top.sob.core.annotations.Immutable;
import top.sob.core.Utilities;
import top.sob.vanilla.Meta;

import java.io.Serializable;
import java.util.stream.Stream;

@Immutable
public abstract class OperationTemplate implements Serializable {

    private static final String HELP_STR;

    static {
        var tmp = Utilities.getConfig(Meta.LANG, "vanilla", "pre", "paraHelp");
        HELP_STR = (tmp == null ? "Help" : tmp);
    }

    @SuppressWarnings("unused")
    public int getParameterAmt() {
        return getParameters().length;
    }

    @SuppressWarnings("unused")
    public String getHelpOf(String name) {
        var p = forName(name);
        if (p == null)
            throw new IllegalArgumentException("Argument " + name + " does not exist.");

        return p.getHelp();
    }

    public Parameter forName(String name) {

        for (var p : getParameters()) {
            if (p.getName().equals(name))
                return p;
        }

        return null;
    }

    public abstract Parameter[] getParameters();

    @SuppressWarnings("unused")
    public String getHelp() {
        var sb = new StringBuilder("--------" + HELP_STR + "--------\n");
        var ps = getParameters();

        Stream.of(ps).forEach((p) -> sb.append(p.getName())
                .append(" - ")
                .append(p.getHelp())
                .append(System.lineSeparator()));

        return sb.toString();
    }

}
