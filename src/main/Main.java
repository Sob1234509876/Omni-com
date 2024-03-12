package src.main;

//Tools
import java.util.Properties;
import java.util.ArrayList;

import src.gts.*;
import src.gui.listeners.clickDetect;
import src.gui.listeners.keyDetect;
import src.gui.listeners.mouseMotionDetect;

//Paths
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        public static JWindow gui = new JWindow();
        public static JPanel decoPanel = new JPanel(null);
        public static JButton closeButton = new JButton("X");
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

        private static void init() {

                gui.add(out);
                gui.add(in);
                gui.add(decoPanel);
                decoPanel.add(closeButton);

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
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
                gui.addMouseListener(new clickDetect());
                gui.addMouseMotionListener(new mouseMotionDetect());
                gui.setFocusable(true);

                decoPanel.setBounds(0,
                                0,
                                GUI_X,
                                SIZ);
                decoPanel.setFont(FONT);
                decoPanel.setBackground(new Color(FGCOLOR, false));
                decoPanel.setForeground(new Color(BGCOLOR, false));
                decoPanel.setBorder(BORDER);

                closeButton.setBounds(0,
                                0,
                                2 * SIZ,
                                SIZ);
                closeButton.setFont(FONT);
                closeButton.setBackground(new Color(FGCOLOR, false));
                closeButton.setForeground(new Color(BGCOLOR, false));
                closeButton.setBorder(BORDER);
                closeButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                System.exit(0);
                        }
                });

                out.setBounds(0,
                                SIZ,
                                GUI_X,
                                GUI_Y - 2 * SIZ);
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

}
