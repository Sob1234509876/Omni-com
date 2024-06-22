package top.sob.core.api;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

import top.sob.core.*;

/**
 * The game meta datas, e.x : dafault encoding
 * 
 * @since 1.2.8a
 */
public final class meta {

    /** No instance making */
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
     * The game base code enum. Used for knowing what are you doing at this game.
     * The codes:
     * <p>
     * 
     * <pre>
     * NORMAL : Normal game;
     * DEBUG : For debugging;
     * </pre>
     * 
     * @since 1.2.8a
     */
    public enum bcode {
        NORMAL,
        DEBUG
    }

    /** The code for what are you doing during this game */
    public static bcode G_INIT_CODE;
    /** The code after game mode selection */
    public static mcode G_MODE_CODE;
    /** The default encoding */
    public static final Charset DEF_CHARSET;
    /** The class loader for this jar */
    public static final ClassLoader THIS_CLASS_LOADER = Main.class.getClassLoader();

    /** The URI for the configs dir */
    public static final URI CONFIGS_URI;
    /** The URI for the plugins dir */
    public static final URI PLUGINS_URI;
    /** The URI for the reports dir */
    public static final URI REPORTS_URI;
    /** The URI for the report file */
    public static final URI REPORT_URI;
    /** The URI for the saves dir */
    public static final URI SAVES_URI;
    // Some basic URIs

    static {

        DEF_CHARSET = Charset.forName(((String) (Main.optSet.valueOf("charset"))));
        CONFIGS_URI = ((File) (Main.optSet.valueOf("confDir"))).toURI();
        PLUGINS_URI = ((File) (Main.optSet.valueOf("plugDir"))).toURI();
        REPORTS_URI = ((File) (Main.optSet.valueOf("repoDir"))).toURI();
        SAVES_URI = ((File) (Main.optSet.valueOf("saveDir"))).toURI();
        REPORT_URI = new File(REPORTS_URI.getPath(), ((String) (Main.optSet.valueOf("reportName"))))
                .toURI();

    }
}
