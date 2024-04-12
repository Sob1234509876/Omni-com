package vanilla.main;

import src.gts.*;
import src.gui.listeners.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import java.io.*;
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
 * @version 1.0.2a
 */

public class Main {

    public static long StatusFlag = -1;
    // Flags

    public static final String                 __VERSION__ = "2.0a";
    public static volatile src.utils.reg<item> VanillaReg = new src.utils.reg<>("vanilla");
    // METAish
    public static Properties settings = new Properties();
    public static Properties langSettings = new Properties();
    // Properties
    public static JFrame     GameFrame = new JFrame();
    public static JTextArea  OutTextArea = new JTextArea();
    public static JTextField InTextArea = new JTextField("play");
    // GUI

    private static File RESOURCE_PATH = src.main.Main.RESOURCE_PATH;
    private static File CONFIG_PATH = src.main.Main.CONFIGS_PATH;
    // Privates

    static {
        VanillaReg.add(item.valueOf(new src.utils.factories.ItemFactory()
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
        CoreCmdProcessor();
    }

    /**
     * Inits some basic resources like settings and lang files.
     * @throws Exception
     */
    private static void InitResource() throws Exception{

        settings.load(new InputStreamReader(
                new FileInputStream(
                        Paths.get(
                                CONFIG_PATH.toString(),
                                "vanilla.cfg")
                                .toString()),
                "utf-8"));

        langSettings.load(new InputStreamReader(
                new FileInputStream(
                        Paths.get(
                                RESOURCE_PATH.toString(),
                                "vanilla",
                                settings.getProperty("lang") + ".lang")
                                .toString()),
                "utf-8"));

        // Load the settings and lang files
    }

    /**
     * The part where the cmd line of the src works.
     * 
     * @throws Exception
     */
    private static void CoreCmdProcessor() throws Exception {

        Thread VanillaCoreCmdPT = new Thread(new Runnable() {

            private String buffer;

            public void run() {

                try {
                    while (true) {
                        if ((keyDetect.PressedKey == '\n')) {

                            buffer = src.io.input.read();

                            if (buffer.equals("game")) {
                                InitGUI();
                            }

                            if (buffer.equals("help")) {
                                src.io.output.write(String.format(langSettings.getProperty("help")));
                            }

                            src.io.input.clear();
                            keyDetect.PressedKey = '\0';
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

                , "Game");

        VanillaCoreCmdPT.start();

    }

    /**
     * The init. part of the game, GUI and etc.
     * 
     * @throws Exception
     */
    private static void InitGUI() throws Exception {

        GameFrame.add(InTextArea);
        GameFrame.add(OutTextArea);
        // Add the input and output JTextPanel
        final Integer SIZ        = Integer.parseInt(settings.getProperty("GUI.font_siz"));

        final Font    FONT       = new Font(settings.getProperty("GUI.font"),Font.PLAIN,SIZ);
        final Color   BGCOLOR    = new Color(Integer.parseInt(settings.getProperty("GUI.BGColor")), false);
        final Color   FGCOLOR    = new Color(Integer.parseInt(settings.getProperty("GUI.FGColor")), false);
        final Integer GUI_WIDTH  = Integer.parseInt(settings.getProperty("GUI.size").split("x")[0]);
        final Integer GUI_HEIGHT = Integer.parseInt(settings.getProperty("GUI.size").split("x")[1]);
        final Border  BORDER     = BorderFactory.createMatteBorder(1, 1, 1, 1, FGCOLOR);

        // For quick access to gui configurations.

        GameFrame.setTitle                 (String.format(langSettings.getProperty("title"), __VERSION__));
        GameFrame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        GameFrame.setLayout                (null);
        GameFrame.setIconImage             (src.main.Main.ICON);
        GameFrame.setSize                  (GUI_WIDTH, GUI_HEIGHT + 35);
        GameFrame.setResizable             (false);
        GameFrame.setLocationRelativeTo    (null);
        GameFrame.setVisible               (true);

        // Init. game JFrame

        OutTextArea.setText       ("");
        OutTextArea.setEditable   (false);
        OutTextArea.setFont       (FONT);
        OutTextArea.setBounds     (
                                   0,
                                   0,
                                   GUI_WIDTH,
                                   GUI_HEIGHT - SIZ);
        OutTextArea.setBackground (BGCOLOR);
        OutTextArea.setForeground (FGCOLOR);
        OutTextArea.setBorder     (BORDER);
        OutTextArea.setLineWrap   (true);

        // Init. output JTextPanel

        InTextArea.setText        ("");
        InTextArea.setFont        (FONT);
        InTextArea.setBounds      (
                                   0,
                                   GUI_HEIGHT - SIZ,
                                   GUI_WIDTH,
                                   SIZ);
        InTextArea.setBackground  (BGCOLOR);
        InTextArea.setForeground  (FGCOLOR);
        InTextArea.setBorder      (BORDER);
        InTextArea.addKeyListener (new keyDetect()); // Runs createGame when you type
    
    }

}
