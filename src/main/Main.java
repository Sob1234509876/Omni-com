package src.main;

///////
//Types

//Tools
import java.util.Properties;

import java.net.URL;
import java.net.URLClassLoader;

import src.gui.listeners.keyDetect;
import src.io.*;

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
        public static final Path REPORT_PATH = Paths.get(GAME_PATH.toString(), "report");

        // Consts. & importants

        public static JFrame gui = new JFrame();
        public static JTextArea out = new JTextArea();
        public static JTextField in = new JTextField("game");

        // gui & consts.

        public static void main(String[] args) throws Exception {

                PrintStream t = new PrintStream(new FileOutputStream(Paths.get(REPORT_PATH.toString(),
                                String.format("Report %d.log",
                                                System.currentTimeMillis()))
                                .toString()),
                                false, "utf-8");

                System.setErr(t);

                // Path Init

                settings.load(new InputStreamReader(
                                new FileInputStream(
                                                Paths.get(CONFIGS_PATH.toString(),
                                                                "Main.cfg").toString()),
                                "utf-8"));

                langSettings.load(
                                new InputStreamReader(
                                                new FileInputStream(
                                                                Paths.get(RESOURCE_PATH.toString(),
                                                                                "Main",
                                                                                settings.getProperty("lang") + ".lang")
                                                                                .toString()),
                                                "utf-8"));

                // Setting init

                init();

                loadPlugins();

        }

        /**
         * Graphics init. (That`s all)
         */

        private static void init() {

                gui.add(out);
                gui.add(in);

                gui.setTitle(String.format(langSettings.getProperty("title"), __VERSION__));
                out.setText(langSettings.getProperty("default"));

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
                out.setLineWrap(true);

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
                boolean ERR_FLAG = false;
                Exception TMP = new Exception("FILL THIS NEW CREATED EXCEPTION WITH ERRORS AND BUGS!");

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

                                TMP = e;
                                e.printStackTrace();
                                System.err.print('\n');
                                ERR_FLAG = true;

                        } finally {

                                if (ERR_FLAG) {

                                        output.log();
                                        TMP.printStackTrace(System.out);

                                }
                        }

                }

                UCL.close();
        }

}
