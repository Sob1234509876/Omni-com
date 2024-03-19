package vanilla.main;

import src.utils.factories.*;
import src.utils.io.*;
import src.gui.listeners.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

import java.io.*;
import java.nio.file.*;

import java.util.Properties;

public class Main {

    public static String __VERSION__ = "1.0a";

    public static Properties settings = new Properties();
    public static Properties langSettings = new Properties();

    public static JFrame game = new JFrame();
    public static JTextArea out = new JTextArea();
    public static JTextField in = new JTextField();

    private static Path RESOURCE_PATH = src.main.Main.RESOURCE_PATH;
    // private static Path SAVE_PATH = src.main.Main.SAVES_PATH;
    private static Path CONFIG_PATH = src.main.Main.CONFIGS_PATH;

    /**
     * Used as a testing ground.
     * 
     * @param args , you know what does it means.
     */

    public static void main(String[] args) {
    }

    /**
     * The entry of this plugin, consists of init. and gt. creation.
     */

    public static void run() throws Exception {

        Integer i = new itemFactory()
                .setName("ALPHA")
                .register();

        System.out.println(src.main.Main.Items.get(i).name);
        System.out.println("2024.3.18 : Alpha success (1.1.0)");
        System.out.println("Omni co., Ltd.");

        System.out.println(" _");
        System.out.println("/ \\ |/\\/\\ |/\\ .   _  _     |  _|_  _|");
        System.out.println("\\_/ | | | | | |  |_ |_| ., |_  |  |_|.");

        Game();

    }

    private static void Game() throws Exception {

        Thread gamet = new Thread(new Runnable() {

            public void run() {

                try {

                    while (true) {
                        if ((keyDetect.PressedKey == '\n')) {
                            if (input.read().equals("game")) {
                                initGame();
                            }

                            if (input.read().equals("help")) {
                            }

                            input.clear();
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

    private static void initGame() throws Exception {

        game.add(in);
        game.add(out);

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

        int GUI_WIDTH = Integer.parseInt(settings.getProperty("GUI.size").split("x")[0]);
        int GUI_HEIGHT = Integer.parseInt(settings.getProperty("GUI.size").split("x")[1]);
        int SIZ = Integer.parseInt(settings.getProperty("GUI.font_siz"));

        Color BGCOLOR = new Color(Integer.parseInt(settings.getProperty("GUI.BGColor")), false);
        Color FGCOLOR = new Color(Integer.parseInt(settings.getProperty("GUI.FGColor")), false);

        Border BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, FGCOLOR);
        Font FONT = new Font(
                settings.getProperty("GUI.font"),
                Font.PLAIN,
                SIZ);

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
        in.addKeyListener(new keyDetect());
    }

}
