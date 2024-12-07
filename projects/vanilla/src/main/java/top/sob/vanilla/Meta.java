package top.sob.vanilla;

public final class Meta {

    private Meta() {
    }

    public static final ClassLoader THIS_CLASS_LOADER;

    public static final String INDEX_NAME = "assets/net/index_" + top.sob.core.Meta.LANGUAGE.toLowerCase() + ".html";

    static {

        THIS_CLASS_LOADER = Main.class.getClassLoader();

    }

}
