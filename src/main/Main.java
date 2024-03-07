package src.main;

//Tools
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;

import src.utils.output;

import src.gts.element;
import src.gts.fluid;
import src.gts.item;
import src.gts.machine;
import src.gts.material;
import src.gts.recipe;

import src.gui.listeners.keyDetect;

//Paths
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;

public class Main {

        public static Properties settings = new Properties();
        public static Properties langSettings = new Properties();

        public static final String __VERSION__ = "0.1a";
        public static final Path GAME_PATH = Paths.get("").toAbsolutePath();
        public static final Path SRC_PATH = Paths.get(GAME_PATH.toString(), "src");
        public static final Path CONFIGS_PATH = Paths.get(GAME_PATH.toString(), "configs");
        public static final Path PLUGINS_PATH = Paths.get(GAME_PATH.toString(), "plugins");
        public static final Path RESOURCE_PATH = Paths.get(GAME_PATH.toString(), "resource");
        public static final Path SAVES_PATH = Paths.get(GAME_PATH.toString(), "saves");

        // Consts. & importants

        public static JFrame gui = new JFrame("Omni com. co., Ltd.");
        public static JTextArea out = new JTextArea("Hey");
        public static JTextField in = new JTextField("Ho");

        // gui & consts.

        public volatile static Map<Integer, item> Items = new HashMap<Integer, item>();
        public volatile static Map<Integer, fluid> Fluids = new HashMap<Integer, fluid>();
        public volatile static Map<Integer, material> Materials = new HashMap<Integer, material>();
        public volatile static Map<Integer, element> Elements = new HashMap<Integer, element>();
        public volatile static Map<Integer, recipe> Recipe = new HashMap<Integer, recipe>();
        public volatile static Map<Integer, machine> Machine = new HashMap<Integer, machine>();

        // ID map

        public static void main(String[] args) throws IOException {

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

        }

        private static void init() {

                int GUI_X = Integer.parseInt(settings.getProperty("GUI.size").split("x")[0]);
                int GUI_Y = Integer.parseInt(settings.getProperty("GUI.size").split("x")[1]);
                int SIZ = Integer.parseInt(settings.getProperty("GUI.font_siz"));
                int BGCOLOR = Integer.parseInt(settings.getProperty("GUI.BGColor"));
                int FGCOLOR = Integer.parseInt(settings.getProperty("GUI.FGColor"));
                Font FONT = new Font(settings.getProperty("GUI.font"), Font.PLAIN, SIZ);
                MatteBorder BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(FGCOLOR, false));

                gui.setIconImage(
                                new ImageIcon(
                                                Paths.get(
                                                                RESOURCE_PATH.toString(),
                                                                "icon.png").toString())
                                                .getImage());
                gui.setLayout(null);
                gui.setSize(GUI_X, GUI_Y);
                gui.setResizable(false);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);

                out.setBounds(0,
                                0,
                                GUI_X,
                                GUI_Y - SIZ);
                out.setFont(FONT);
                out.setBackground(new Color(BGCOLOR, false));
                out.setForeground(new Color(FGCOLOR, false));
                out.setBorder(BORDER);
                out.setEditable(false);

                in.setBounds(0,
                                GUI_Y - 9 * SIZ,
                                GUI_X,
                                SIZ);
                in.setFont(FONT);
                in.setBackground(new Color(BGCOLOR, false));
                in.setForeground(new Color(FGCOLOR, false));
                in.setBorder(BORDER);

                gui.add(out);
                gui.add(in);
        }

}
