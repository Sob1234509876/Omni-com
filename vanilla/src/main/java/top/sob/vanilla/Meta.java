package top.sob.vanilla;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.moandjiezana.toml.Toml;

import oshi.SystemInfo;
import top.sob.vanilla.exceptions.MissingResourceException;

import static top.sob.core.api.Meta.LANGUAGE;
import static top.sob.core.api.Meta.DEF_CHARSET;

public final class Meta {

    private Meta() {
    }

    @SuppressWarnings("unused")
    private static Object BufferForLoading;

    public static final ClassLoader THIS_CLASS_LOADER;
    private static final InputStream LANG_STREAM;
    private static final Reader LANG_READER;
    public static final Toml LANG;

    @SuppressWarnings("unused")
    public static final Gson JSON = new GsonBuilder().setPrettyPrinting().create();

    public static final File TMP_FILE_DIR;
    public static final String INDEX_NAME = "assets/net/index_" + top.sob.core.api.Meta.LANGUAGE.toLowerCase() + ".html";

    static {

        THIS_CLASS_LOADER = Main.class.getClassLoader();
        LANG_STREAM = THIS_CLASS_LOADER.getResourceAsStream(
                String.format("assets/lang/%s.lang", LANGUAGE));

        if (LANG_STREAM == null)
            throw new MissingResourceException(
                    String.format("assets/lang/%s.lang", LANGUAGE));

        LANG_READER = new InputStreamReader(LANG_STREAM, DEF_CHARSET);
        LANG = new Toml();

        LANG.read(LANG_READER);

        ///------///

        var dir = (File) null;

        switch (SystemInfo.getCurrentPlatform()) {
            case WINDOWS, WINDOWSCE -> dir = new File(System.getProperty("user.home"), "Sob1234509876/Vanilla");
            default -> dir = new File("/tmp/Sob1234509876/Vanilla");
        }

        TMP_FILE_DIR = dir;

    }

}
