package top.sob.vanilla.api.game.trans.pars;

import java.math.BigInteger;
import java.util.*;

public class Info extends Command {

    @SuppressWarnings("unused")
    public static final Set<Map<String, Class<?>>> CMD_PARAMETER_CLASSES;
    public static final Entry<String, Class<?>> PAGE = Map.entry("page", BigInteger.class);
    public static final Entry<String, Class<?>> CLASS = Map.entry("class", String.class);
    public static final Entry<String, Class<?>> SUB_CLASS = Map.entry("subClass", String.class);

    static {
        CMD_PARAMETER_CLASSES = Set.of(
                Map.ofEntries(),
                Map.ofEntries(PAGE),
                Map.ofEntries(CLASS),
                Map.ofEntries(CLASS, PAGE),
                Map.ofEntries(CLASS, SUB_CLASS),
                Map.ofEntries(CLASS, SUB_CLASS, PAGE)
        );
    }

    @Override
    public String getName() {

        // TODO: Set for lang

        return "Info";
    }

    @Override
    public String getHelp() {
        return "";
    }

}
