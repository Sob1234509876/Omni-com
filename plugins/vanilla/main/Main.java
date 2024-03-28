package vanilla.main;

import src.utils.*;
import src.utils.factories.*;
import vanilla.main.others.createGame;
import src.gts.*;
import src.gui.listeners.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import java.io.*;
import java.nio.file.*;

import java.util.Properties;

/**
 * The vanilla game of this game.
 * For more information, please check out the html file in the jar package.
 * (W.I.P)
 * <p>
 * Quick info :
 * {@code vanilla.main.Main.flag} - A flag describing current game status
 * <p>
 * -1 - default.
 * <p>
 * 0 - init.
 * <p>
 * 1 - new save creating.
 * 
 * @version 1.0.2a
 */

public class Main {

    public static long flag = -1;
    // A flag describing current game status

    public static String __VERSION__ = "1.1a";
    public static volatile reg<item> Reg = new reg<>("vanilla");
    // METAish

    public static Properties settings = new Properties();
    public static Properties langSettings = new Properties();
    // Properties

    public static JFrame game = new JFrame();
    public static JTextArea out = new JTextArea();
    public static JTextField in = new JTextField("play");
    // GUI

    private static Path RESOURCE_PATH = src.main.Main.RESOURCE_PATH;
    private static Path CONFIG_PATH = src.main.Main.CONFIGS_PATH;
    // Paths

    static {
        Reg.add(new itemFactory()
                .setName("ALPHA")
                .getProduct());
    }

    /**
     * Used as a testing ground.
     * 
     * @param args , you know what does it means.
     */

    public static void main(String[] args) {
    }

    /**
     * The entry of this plugin, consists of init. and gt. creation.
     * 
     * @throws Exception
     */

    public static void run() throws Exception {

        System.err.println("There might not be any errors, lol");

        System.out.println(Reg.get(0).name);
        System.out.println("2024.3.18 : Alpha success (1.1.0)");
        System.out.println("Omni co., Ltd.");

        System.out.println(" _");
        System.out.println("/ \\ |/\\/\\ |/\\ .   _  _     |  _|_  _|");
        System.out.println("\\_/ | | | | | |  |_ |_| ., |_  |  |_|.");

        // Happy coding and loading.

        Game();

    }

    /**
     * The part where the cmd line of the src works.
     * 
     * @throws Exception
     */

    private static void Game() throws Exception {

        // BLAH Blah blah!!!!!!!!!!!!!!! It is only about the main game cmd commands.
        Thread gamet = new Thread(new Runnable() {

            private String buffer;

            public void run() {

                try {

                    while (true) {
                        if ((keyDetect.PressedKey == '\n')) {

                            buffer = src.io.input.read();

                            if (buffer.equals("game")) {
                                initGame();
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

        gamet.start();

    }

    /**
     * The init. part of the game, GUI and etc.
     * 
     * @throws Exception
     */
    private static void initGame() throws Exception {

        game.add(in);
        game.add(out);
        // Add the input and output JTextPanel

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

        final int GUI_WIDTH = Integer.parseInt(settings.getProperty("GUI.size").split("x")[0]);
        final int GUI_HEIGHT = Integer.parseInt(settings.getProperty("GUI.size").split("x")[1]);
        final int SIZ = Integer.parseInt(settings.getProperty("GUI.font_siz"));

        final Color BGCOLOR = new Color(Integer.parseInt(settings.getProperty("GUI.BGColor")), false);
        final Color FGCOLOR = new Color(Integer.parseInt(settings.getProperty("GUI.FGColor")), false);

        final Border BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, FGCOLOR);
        final Font FONT = new Font(
                settings.getProperty("GUI.font"),
                Font.PLAIN,
                SIZ);

        // For quick access to gui configurations.

        ///////////////////////////////////////////// A nice wall///////////////////
        game.setTitle(String.format(langSettings.getProperty("title"), __VERSION__));

        game.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        game.setLayout(null);
        game.setIconImage(
                (new ImageIcon(
                        Paths.get(
                                RESOURCE_PATH.toString(),
                                "icon.png").toString())
                        .getImage()));
        game.setSize(GUI_WIDTH, GUI_HEIGHT + 35);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setVisible(true);

        // Init. game JFrame

        out.setText("");
        out.setFont(FONT);
        out.setBounds(
                0,
                0,
                GUI_WIDTH,
                GUI_HEIGHT - SIZ);
        out.setBackground(BGCOLOR);
        out.setForeground(FGCOLOR);
        out.setBorder(BORDER);
        out.setLineWrap(true);

        // Init. output JTextPanel

        in.setText("");
        in.setFont(FONT);
        in.setBounds(
                0,
                GUI_HEIGHT - SIZ,
                GUI_WIDTH,
                SIZ);
        in.setBackground(BGCOLOR);
        in.setForeground(FGCOLOR);
        in.setBorder(BORDER);
        in.addKeyListener(new keyDetect()); // Runs createGame when you type
        ///////////////////////////////////////////// A nice wall///////////////////

        Thread mkGame = new Thread(new createGame(), "mk Game");
        mkGame.start();

        // Init. input JTextPanel
    }

}
