package vanilla.main;

import game.gts.*;
import game.gui.listeners.*;

import javax.swing.*;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;

import java.util.*;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * <p>
 * Quick info :
 * {@code vanilla.main.Main.flag} - A flag describing current game status
 * <pre>
 * -1 : default.
 * 0 : init.
 * 1 : new save creating.
 * </pre>
 * @version 2.0.1a
 */


public class Main {
    public static volatile long StatusFlag = -1;
    // Flags

    public static final    String              __VERSION__ = "2.0a";
    public static volatile game.utils.reg<item> VanillaReg  = new game.utils.reg<>("vanilla");
    // METAish
    public static final Properties settings     = new Properties();
    public static final Properties langSettings = new Properties();
    // Properties
    public static JFrame     GameFrame   = new JFrame();
    public static JTextArea  OutTextArea = new JTextArea();
    public static JTextField InTextArea  = new JTextField("play");
    // GUI

    private static final File RESOURCE_PATH = game.main.Main.RESOURCE_PATH;
    private static final File CONFIG_PATH   = game.main.Main.CONFIGS_PATH;
    private static final File PLUGINS_PATH  = game.main.Main.PLUGINS_PATH;
    // Privates

    static {
        VanillaReg.add(item.valueOf(new game.utils.factories.ItemFactory()
                .setName("ALPHA"))
                );
    }

    /**
     * The entry of this plugin.
     */
    public static void main(String[] args) throws Exception {

        System.out.println(VanillaReg.get(0).Name);
        System.out.println("2024.03.18 : Alpha success (1.1.0)");
        System.out.println("2024.04.08 : Epic Rebirth  (1.2.3)");
        System.out.println("Omni co., Ltd.");

        System.out.println("______________________________________");
        System.out.println(" _");
        System.out.println("/ \\ |/\\/\\ |/\\ .   _  _     |  _|_  _|");
        System.out.println("\\_/ | | | | | |  |_ |_| ., |_  |  |_|.");
        System.out.println("______________________________________");

        // Happy coding and loading.

        InitResource();
        game.io.output.log(String.format("SETTINGS LOAD...%s...L:%d\n", (settings.isEmpty() ? "FAILED" : "SUCSEED"), settings.size()));
        settings.list(System.out);
        settings.list(System.err);

        game.io.output.log(String.format("LANGS LOAD...%s...L:%d\n", (settings.isEmpty() ? "FAILED" : "SUCSEED"), settings.size()));
        langSettings.list(System.out);
        langSettings.list(System.err);

        CoreCmdProcessor();
    }

    /**
     * Inits some basic resources like settings and lang files.
     * @throws Exception
     */
    private static void InitResource() throws Exception{

        settings.load(new InputStreamReader(new FileInputStream(Paths.get(CONFIG_PATH.toString(),"vanilla.cfg").toString()),"utf-8"));
        langSettings.load(new InputStreamReader(new FileInputStream(Paths.get(RESOURCE_PATH.toString(),"vanilla",settings.getProperty("lang") + ".lang").toString()),"utf-8"));

        // Load the settings and lang files


    }

    /**
     * The part where the cmd line of the src works.
     * 
     * @throws Exception
     */
    private static void CoreCmdProcessor() throws Exception {

        Thread VanillaCmdSolver = new Thread(new Runnable() {

            private String buffer;

            public void run() {

                try {
                    while (true) {
                        buffer = GET();

                        if (buffer.equals("cns")) {
                            
                            URL[] U = {new URL(String.format("file:%s/vanilla.jar", PLUGINS_PATH))};
                            URLClassLoader UCL = new URLClassLoader(U);

                            game.io.output.log("LOADING CNS");

                            UCL.loadClass("vanilla.CreateNewSave")
                                .getMethod("Create")
                                .invoke(null);

                            game.io.output.log("USE CNS");

                            UCL.close();

                        }
                        else if (buffer.equals("help")) {
                            game.io.output.write(String.format(langSettings.getProperty("help")));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    e.printStackTrace(System.out);
                }
            }

        }

                , "VCL");

        VanillaCmdSolver.start();

    }


    private static String GET() {
        while (KeyDetect.PressedKey != '\n') ;
        String tmp = game.io.input.read();
        game.io.input.clear();
        KeyDetect.PressedKey = '\0';

        return tmp;
    }

}
