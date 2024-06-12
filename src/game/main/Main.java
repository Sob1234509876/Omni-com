package game.main;


import game.reflect.*;
import game.ui.*;

//Tools
import java.util.*;

//io
import java.io.*;
import java.nio.charset.*;

//GUI
import javax.swing.*;
import java.awt.*;

/**
 * The core of the whole game, consists of core paths, starting frame, plugin
 * loading and etc.
 */
public class Main {

    public static final Properties SETTINGS = new Properties();
    public static final Properties LANG = new Properties();

    public static final String __VERSION__ = "1.2.7a";
    public static final File GAME_PATH = new File(new File("").getAbsolutePath());
    public static final File SRC_PATH = new File(GAME_PATH, "src");
    public static final File CONFIGS_PATH = new File(GAME_PATH, "configs");
    public static final File PLUGINS_PATH = new File(GAME_PATH, "plugins");
    public static final File SAVES_PATH = new File(GAME_PATH, "saves");
    public static final File REPORT_PATH = new File(GAME_PATH, "report");
    public static final Charset DEF_CHARSET = Charset.forName("UTF-8");
    public static final ClassLoader DEF_CLASS_LOADER = Main.class.getClassLoader();
    public static final Runtime DEF_RUNTIME = Runtime.getRuntime();

    // Consts. & importants

    public static final JFrame GameFrame = new JFrame();
    public static final JTextArea OutTextArea = new JTextArea();
    public static final JTextField InTextArea = new JTextField("play");
    public static Image ICON;

    // gui & consts.

    /** No instance constructing */
    private Main() {
    }

    public static void main(String[] args) throws Throwable {

        PrintStream t = new PrintStream(
                new File(REPORT_PATH, String.format("REPORT %s.log", System.currentTimeMillis())), DEF_CHARSET);
        System.setErr(t);
        // Init Reports
        ICON = new ImageIcon(DEF_CLASS_LOADER.getResource("game/assets/icon.png")).getImage();

        SETTINGS.load(new InputStreamReader(new FileInputStream(new File(CONFIGS_PATH, "Main.cfg")), DEF_CHARSET));
        LANG.load(new InputStreamReader(
                DEF_CLASS_LOADER.getResourceAsStream("game/assets/lang/" + SETTINGS.getProperty("lang") + ".lang"),
                DEF_CHARSET));
        //Loads in settings and lang files

        LoadPlugins.Load();
        LoadUI.Load();

    }



}
