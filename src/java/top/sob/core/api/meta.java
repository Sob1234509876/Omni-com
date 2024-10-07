package top.sob.core.api;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.stream.Stream;

import top.sob.core.util;
import top.sob.core.Main;

/**
 * The game meta data, e.x : default encoding
 *
 * @since 1.2.8a
 */
public final class meta {

    /**
     * No instance making
     */
    private meta() {
    }

    /**
     * The game mode code enum.
     * <p>
     *
     * <pre>
     * TOO_UNREAL : Too easy for being a sci-fi game;
     * UNREAL : Being a sci-fi game but having a lot of places simplified;
     * NORMAL : Having moderate simplification;
     * REAL : Realistic;
     * TOO_REAL : Too realistic, which needs the player to master maths, chemistry, physics and other things;
     * </pre>
     *
     * @since 1.2.8a
     */
    public enum mcode {
        TOO_UNREAL,
        UNREAL,
        NORMAL,
        REAL,
        TOO_REAL
    }

    /**
     * The code after game mode selection
     */
    public static mcode G_MODE_CODE;
    /**
     * The default encoding
     */
    public static final Charset DEF_CHARSET;
    /**
     * The class loader for this jar
     */
    public static final ClassLoader THIS_CLASS_LOADER = Main.class.getClassLoader();

    /**
     * The URI for the configs dir
     */
    public static final URI CONFIGS_URI;
    /**
     * The URI for the plugins dir
     */
    public static final URI[] PLUGINS_URI;
    /**
     * The URI for the reports dir
     */
    public static final URI REPORTS_URI;
    /**
     * The URI for the report file
     */
    public static final URI REPORT_URI;
    /**
     * The URI for the saves dir
     */
    public static final URI SAVES_URI;
    // Some basic URIs

    /**
     * The language played in
     */
    public static final String LANGUAGE;

    static {

        DEF_CHARSET = Charset.forName(((String) (Main.optSet.valueOf("charset"))));
        CONFIGS_URI = ((File) (Main.optSet.valueOf("confDir"))).toURI();
        var tmp = Stream.of((Main.optSet.valuesOf("plugDir").toArray(new File[0])));
        var lst = new ArrayList<URI>();
        for (File file : tmp.toList()) {
            lst.add(file.toURI());
        }
        PLUGINS_URI = lst.toArray(new URI[0]);

        REPORTS_URI = ((File) (Main.optSet.valueOf("repoDir"))).toURI();
        SAVES_URI = ((File) (Main.optSet.valueOf("saveDir"))).toURI();
        REPORT_URI = new File(REPORTS_URI.getPath(), ((String) (Main.optSet.valueOf("reportName"))))
                .toURI();

        LANGUAGE = util.getConfig("base", "lang");

    }
}
