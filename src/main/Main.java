package src.main;

///////
//Types

//Tools
import java.util.Properties;
import java.util.ArrayList;

import java.net.URL;
import java.net.URLClassLoader;

import src.gts.*;
import src.gui.listeners.keyDetect;
import src.utils.output;

//io
import java.io.*;

import java.nio.file.Paths;
import java.nio.file.Path;

//Swing
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
///////

public class Main {

        public static Properties settings = new Properties();
        public static Properties langSettings = new Properties();

        public static final String __VERSION__ = "1.0.3a";
        public static final Path GAME_PATH = Paths.get("").toAbsolutePath();
        public static final Path SRC_PATH = Paths.get(GAME_PATH.toString(), "src");
        public static final Path CONFIGS_PATH = Paths.get(GAME_PATH.toString(), "configs");
        public static final Path PLUGINS_PATH = Paths.get(GAME_PATH.toString(), "plugins");
        public static final Path RESOURCE_PATH = Paths.get(GAME_PATH.toString(), "resource");
        public static final Path SAVES_PATH = Paths.get(GAME_PATH.toString(), "saves");

        // Consts. & importants

        public static JFrame gui = new JFrame("Omni com. co., Ltd. " + __VERSION__);
        public static JTextArea out = new JTextArea("Hey");
        public static JTextField in = new JTextField("Ho");

        // gui & consts.

        public volatile static ArrayList<item> Items = new ArrayList<>();
        public volatile static ArrayList<fluid> Fluids = new ArrayList<>();
        public volatile static ArrayList<material> Materials = new ArrayList<>();
        public volatile static ArrayList<element> Elements = new ArrayList<>();
        public volatile static ArrayList<recipe> Recipe = new ArrayList<>();
        public volatile static ArrayList<machine> Machine = new ArrayList<>();

        // ID map

        public static void main(String[] args) throws Exception {

                // Path Init

                settings.load(
                                new FileReader(
                                                Paths.get(
                                                                CONFIGS_PATH.toString(),
                                                                "Main.cfg")
                                                                .toString()));

                langSettings.load(
                                new FileReader(
                                                Paths.get(
                                                                RESOURCE_PATH.toString(),
                                                                settings.getProperty("lang")
                                                                                + ".lang")
                                                                .toString()));

                // Setting init

                init();

                loadPlugins();

                Thread cmdThread = new Thread(new Runnable() {
                        public void run() {
                                while (true) {
                                        if (keyDetect.PressedKey == '\n') {
                                                String outp = in.getText();
                                                in.setText(null);
                                                out.setText(outp);
                                                keyDetect.PressedKey = 0;
                                        }
                                }
                        }
                }, "cmd thread");

                cmdThread.start();

        }

        /**
         * Graphics init. (That`s all)
         */

        private static void init() {

                gui.add(out);
                gui.add(in);

                int GUI_X = Integer.parseInt(settings.getProperty("GUI.size").split("x")[0]);
                int GUI_Y = Integer.parseInt(settings.getProperty("GUI.size").split("x")[1]);
                int SIZ = Integer.parseInt(settings.getProperty("GUI.font_siz"));
                int BGCOLOR = Integer.parseInt(settings.getProperty("GUI.BGColor"));
                int FGCOLOR = Integer.parseInt(settings.getProperty("GUI.FGColor"));
                Font FONT = new Font(settings.getProperty("GUI.font"), Font.PLAIN, SIZ);
                MatteBorder BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(FGCOLOR, false));

                gui.setVisible(true);
                gui.setIconImage(
                                new ImageIcon(
                                                Paths.get(
                                                                RESOURCE_PATH.toString(),
                                                                "icon.png").toString())
                                                .getImage());
                gui.setLayout(null);
                gui.setSize(GUI_X + 12, GUI_Y + 35);
                gui.setResizable(false);
                gui.setLocationRelativeTo(null);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                out.setBounds(0,
                                0,
                                GUI_X,
                                GUI_Y - SIZ);
                out.setFont(FONT);
                out.setBackground(new Color(BGCOLOR, false));
                out.setForeground(new Color(FGCOLOR, false));
                out.setBorder(BORDER);

                in.setBounds(0,
                                GUI_Y - SIZ,
                                GUI_X,
                                SIZ);
                in.setFont(FONT);
                in.setBackground(new Color(BGCOLOR, false));
                in.setForeground(new Color(FGCOLOR, false));
                in.setBorder(BORDER);
                in.setEditable(true);
                in.addKeyListener(new keyDetect());

        }

        /**
         * Loads the plugins under {@code plugins} , these plugins are also known as
         * <p>
         * mods.
         * 
         * @throws Exception
         */

        private static void loadPlugins() throws Exception {

                String fileName, fileEx;

                output.log("Plugins loading");

                URL[] url = { new URL("file:C:") };
                URLClassLoader UCL = new URLClassLoader(url);
                Class<?> cls;

                for (File f : PLUGINS_PATH.toFile().listFiles()) {

                        try {

                                fileName = f.getName().split("\\.")[0];
                                fileEx = f.getName().split("\\.")[1];
                                if (fileEx.equals("jar")) {
                                        url[0] = new URL("file:" + f.getAbsolutePath());
                                        UCL = new URLClassLoader(url);
                                        cls = UCL.loadClass(fileName + ".main.Main");
                                        output.log(fileName + " loaded");

                                        output.log(fileName + " running");
                                        output.log("\n---" + fileName + "---");
                                        cls.getDeclaredMethod("run").invoke(null);
                                        System.out.println("\n------");
                                }

                        } catch (Exception e) {
                                if (settings.getProperty("debug").equals("true")) {
                                        e.printStackTrace();
                                }
                        }
                }

                UCL.close();
        }

}
