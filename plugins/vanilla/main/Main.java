package vanilla.main;

import game.gts.*;
import game.gui.listeners.*;

import javax.swing.*;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;

import java.util.*;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * @version 2.0.2a
 */


public class Main {

    public static final    String              __VERSION__ = "2.0.2a";
    public static final    game.utils.reg<item> VanillaItemReg  = new game.utils.reg<>("vanilla");
    // METAish
    public static final Properties settings     = new Properties();
    public static final Properties LangSettings = new Properties();
    // Properties
    public static JFrame     GameFrame   = new JFrame();
    public static JTextArea  OutTextArea = new JTextArea();
    public static JTextField InTextArea  = new JTextField("play");
    // GUI

    private static final File PLUGINS_PATH  = game.main.Main.PLUGINS_PATH;
    // Privates

    static {
        VanillaItemReg.add(item.valueOf(new game.utils.templates.ItemTemplate()
                .setName("ALPHA"))
                );
    }

    /**
     * The entry of this plugin.
     */
    public static void main(String[] args) throws Exception {

        System.out.println(VanillaItemReg.get(0).Name);
        System.out.println("2024.03.18 : Alpha success (1.1.0)");
        System.out.println("2024.04.08 : Epic Rebirth  (1.2.3)");
        System.out.println("Omni co., Ltd.");

        System.out.println("______________________________________");
        System.out.println(" _");
        System.out.println("/ \\ |/\\/\\ |/\\ .   _  _     |  _|_  _|");
        System.out.println("\\_/ | | | | | |  |_ |_| ., |_  |  |_|.");
        System.out.println("______________________________________");

        // Happy coding and loading.

        CoreCmdProcessor();
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

                            UCL.loadClass("vanilla.init.CreateNewSave")
                                .getMethod("Create")
                                .invoke(null);

                            game.io.output.log("USE CNS");

                            UCL.close();

                        }
                        else if (buffer.equals("help")) {
                            game.io.output.write(game.main.Main.LangSettings.getProperty("help"));
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
