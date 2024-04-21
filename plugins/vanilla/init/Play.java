package vanilla.init;

import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import game.gui.listeners.*;

import game.main.*;

public class Play {

    public static final int CLIENT_MODE = 0;
    public static final int SERVER_MODE = 1;
    public static final int NORMAL      = 2;
    public static final int HARD        = 3;
    public static final int DEBUG       = 4;
    public static final int REAL        = 5;
    // Cons.

    private static URL[]          URLS;
    private static URLClassLoader UCL;

    private static Class<?> CLIENT_CLASS;
    private static Class<?> SERVER_CLASS;

    private static Thread CLIENT_THREAD;
    private static Thread SERVER_THREAD;
    // Threads, it could be done another way to save stack mem. but it will be a bit messy.
    // Oh no, ClassNotDefError is here again, last sight : vanilla.main.Main

    public static int  Mode;
    public static File GameFile;
    // Some type of API

    /**
     * Starts a multi-player game.
     * There are 2 types of mode :
     * <pre>
     * CLIENT_MODE : the game is a client of a server.
     * SERVER_MODE : the game is a server.
     * </pre>
     * 
     * @param Mode the mode of the game.
     * @throws Exception
     */
    public static void Start(Integer Mode) throws Exception {

        Play.Mode = Mode;

        switch (Mode) {
            case CLIENT_MODE:

                InitGUI();
                CLIENT_THREAD.start();
                break;
        
            case SERVER_MODE:

                InitGameResource.Init();
                SERVER_THREAD.start();
                break;
        }
    }

    /**
     * Starts a single-player game.
     * There are 4 types of mode :
     * <pre>
     * NORMAL : normal mode.
     * HARD   : hard mode.
     * DEBUG  : debug (dev only).
     * REAL   : too much realism.
     * </pre>
     * 
     * @param Game the game file.
     * @param Mode the mode of the game.
     * @throws Exception
     */
    public static void Start(File Game, Integer Mode) throws Exception {
        InitGUI();
        InitGameResource.Init();

        Play.Mode     = Mode;
        Play.GameFile = Game;

        SERVER_THREAD.start();
        CLIENT_THREAD.start();

    }

    /**
     * The init. part of the game, GUI and etc.
     * 
     * @throws Exception
     */
    private static void InitGUI() throws Exception {

        vanilla.main.Main.GameFrame.add(vanilla.main.Main.InTextArea );
        vanilla.main.Main.GameFrame.add(vanilla.main.Main.OutTextArea);
        // Add the input and output JTextPanel

        final Integer SIZ        = Integer.parseInt(Main.Settings.getProperty("GUI.font_siz"));
        final Font    FONT       = new Font(Main.Settings.getProperty("GUI.font"),Font.PLAIN,SIZ);
        final Color   BGCOLOR    = new Color(Integer.parseInt(Main.Settings.getProperty("GUI.BGColor")), false);
        final Color   FGCOLOR    = new Color(Integer.parseInt(Main.Settings.getProperty("GUI.FGColor")), false);
        final Integer GUI_WIDTH  = Integer.parseInt(Main.Settings.getProperty("GUI.size").split("x")[0]);
        final Integer GUI_HEIGHT = Integer.parseInt(Main.Settings.getProperty("GUI.size").split("x")[1]);
        final Border  BORDER     = BorderFactory.createMatteBorder(1, 1, 1, 1, FGCOLOR);

        // For quick access to gui configurations.

        vanilla.main.Main.GameFrame.setTitle                 (String.format(Main.LangSettings.getProperty("vanilla.title"), Main.__VERSION__));
        vanilla.main.Main.GameFrame.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
        vanilla.main.Main.GameFrame.setLayout                (null);
        vanilla.main.Main.GameFrame.setIconImage             (game.main.Main.ICON);
        vanilla.main.Main.GameFrame.setSize                  (GUI_WIDTH, GUI_HEIGHT + 35);
        vanilla.main.Main.GameFrame.setResizable             (false);
        vanilla.main.Main.GameFrame.setLocationRelativeTo    (null);
        vanilla.main.Main.GameFrame.setVisible               (true);

        // Init. game JFrame

        vanilla.main.Main.OutTextArea.setText       ("");
        vanilla.main.Main.OutTextArea.setEditable   (false);
        vanilla.main.Main.OutTextArea.setFont       (FONT);
        vanilla.main.Main.OutTextArea.setBounds     (
                                   0,
                                   0,
                                   GUI_WIDTH,
                                   GUI_HEIGHT - SIZ);
        vanilla.main.Main.OutTextArea.setBackground (BGCOLOR);
        vanilla.main.Main.OutTextArea.setForeground (FGCOLOR);
        vanilla.main.Main.OutTextArea.setBorder     (BORDER);
        vanilla.main.Main.OutTextArea.setLineWrap   (true);

        // Init. output JTextPanel

        vanilla.main.Main.InTextArea.setText        ("");
        vanilla.main.Main.InTextArea.setFont        (FONT);
        vanilla.main.Main.InTextArea.setBounds      (
                                   0,
                                   GUI_HEIGHT - SIZ,
                                   GUI_WIDTH,
                                   SIZ);
        vanilla.main.Main.InTextArea.setBackground  (BGCOLOR);
        vanilla.main.Main.InTextArea.setForeground  (FGCOLOR);
        vanilla.main.Main.InTextArea.setBorder      (BORDER);
        vanilla.main.Main.InTextArea.addKeyListener (new KeyDetect()); // Runs createGame when you type
    
        //Init. input JTextArea
    }

    public static void init() throws Exception {

        URLS = new URL[1];
        URLS[0] = new URL(vanilla.main.Main.THIS_PATH.toString());

        game.io.output.log("Path of vanilla jar : " + vanilla.main.Main.THIS_PATH);

        UCL = new URLClassLoader(URLS);

        SERVER_CLASS = UCL.loadClass("vanilla.net.LServer");
        CLIENT_CLASS = UCL.loadClass("vanilla.net.LClient");

        SERVER_THREAD = new Thread(new Runnable() {public void run() {try {SERVER_CLASS.getMethod("run").invoke(SERVER_CLASS.getConstructor().newInstance());} catch (Exception e) {e.printStackTrace();e.printStackTrace(System.out);}}}, "server");
        CLIENT_THREAD = new Thread(new Runnable() {public void run() {try {CLIENT_CLASS.getMethod("run").invoke(CLIENT_CLASS.getConstructor().newInstance());} catch (Exception e) {e.printStackTrace();e.printStackTrace(System.out);}}}, "client");
        // I`m sorry but I have used everything that I know.
        // Class not define error is an absolute killer to me.

    }
}
