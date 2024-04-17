package game.main;


//Tools
import java.util.*;

import java.net.*;

import game.gui.listeners.*;
import game.io .*;

//io
import java.io .*;
import java.nio.charset.*;

//GUI
import javax.swing.*;
import javax.swing.border.*;
import java .awt  .*;

/**
 * The core of the whole game, consists of core paths, starting frame, plugin loading and etc.
 */
public class Main {

        public static Properties Settings = new Properties();
        public static Properties LangSettings = new Properties();

        public static final String  __VERSION__ = "1.2.5a";
        public static final File    GAME_PATH = new File(new File("").getAbsolutePath());
        public static final File    SRC_PATH = new File(GAME_PATH, "src");
        public static final File    CONFIGS_PATH = new File(GAME_PATH, "configs");
        public static final File    PLUGINS_PATH = new File(GAME_PATH, "plugins");
        public static final File    SAVES_PATH = new File(GAME_PATH, "saves");
        public static final File    REPORT_PATH = new File(GAME_PATH, "report");
        public static final Charset DEF_CHARSET = Charset.forName("utf-8");

        // Consts. & importants

        public static JFrame     GameFrame = new JFrame();
        public static JTextArea  OutTextArea = new JTextArea();
        public static JTextField InTextArea = new JTextField("cns");
        public static Image      ICON;

        // gui & consts.

        public static void main(String[] args) throws Exception {
                                
                PrintStream t = new PrintStream(new File(REPORT_PATH, String.format("REPORT %d.log", System.currentTimeMillis())), DEF_CHARSET);
                System.setErr(t);

                // Init Reports

                Init();
                LoadPlugins();


        }

        /**
         * Graphics init. (That`s all)
         */

        private static void Init() throws Exception {

                URL[] TUA = {new URL("file:" + new File(GAME_PATH, "game.jar"))};
                URLClassLoader UCL = new URLClassLoader(TUA);

                ICON = new ImageIcon(UCL.getResource("game/assets/icon.png")).getImage();

                Settings    .load (new InputStreamReader(new FileInputStream(new File(CONFIGS_PATH, "Main.cfg")), DEF_CHARSET));
                LangSettings.load (new InputStreamReader(UCL.getResourceAsStream("game/assets/lang/" + Settings.getProperty("lang") + ".lang"), DEF_CHARSET));

                UCL.close();

                GameFrame.add(InTextArea);
                GameFrame.add(OutTextArea);


                final Integer GUI_X = Integer.parseInt(Settings.getProperty("GUI.size").split("x")[0]);
                final Integer GUI_Y = Integer.parseInt(Settings.getProperty("GUI.size").split("x")[1]);
                final Integer SIZ = Integer.parseInt(Settings.getProperty("GUI.font_siz"));
                final Integer BGCOLOR = Integer.parseInt(Settings.getProperty("GUI.BGColor"));
                final Integer FGCOLOR = Integer.parseInt(Settings.getProperty("GUI.FGColor"));
                final Font    FONT = new Font(Settings.getProperty("GUI.font"), Font.PLAIN, SIZ);
                final Border  BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(FGCOLOR, false));

                GameFrame.setTitle    (String.format(LangSettings.getProperty("title"), __VERSION__));
                GameFrame.setVisible  (true);
                GameFrame.setIconImage(ICON);
                GameFrame.setLayout   (null);
                GameFrame.setSize     (GUI_X + 12, GUI_Y + 35);
                GameFrame.setResizable(false);
                GameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                OutTextArea.setBounds    (0,
                                          0,
                                          GUI_X,
                                          GUI_Y - SIZ);
                OutTextArea.setEditable  (false);
                OutTextArea.setFont      (FONT);
                OutTextArea.setBackground(new Color(BGCOLOR, false));
                OutTextArea.setForeground(new Color(FGCOLOR, false));
                OutTextArea.setBorder    (BORDER);
                OutTextArea.setLineWrap  (true);
                OutTextArea.setText      (LangSettings.getProperty("default"));

                InTextArea.setBounds(0,
                                GUI_Y - SIZ,
                                GUI_X,
                                SIZ);
                InTextArea.setFont(FONT);
                InTextArea.setBackground(new Color(BGCOLOR, false));
                InTextArea.setForeground(new Color(FGCOLOR, false));
                InTextArea.setBorder(BORDER);
                InTextArea.setEditable(true);
                InTextArea.addKeyListener(new KeyDetect());

        }

        /**
         * Loads the plugins under {@code plugins} , these plugins are also known as
         * <p>
         * mods.
         * 
         * @throws Exception
         */

        private static void LoadPlugins() throws Exception {

                String   fileName;
                String[] splitFileName;
                Class<?> cls;
                // Temporary varibles. 

                output.log("Plugins loading");
                //logs

                URL[]          url = { new URL("file:C:") };
                URLClassLoader UCL = new URLClassLoader(url);
                // Avoid Uninit.


                for (File f : PLUGINS_PATH.listFiles()) {

                        try {

                                splitFileName = f.getName().split("\\.");
                                fileName      = splitFileName[0];
                                // Getting the plugin names

                                if (f.isFile()) {

                                        output.log(f.getName());
                                        // Log

                                        url[0] = new URL("file:" + f.getAbsolutePath());
                                        UCL    = new URLClassLoader(url);
                                        // Creating new class loader

                                        cls = UCL.loadClass(fileName + ".main.Main");
                                        // Load class

                                        output.log(fileName + " loaded");
                                        output.log(fileName + " running");
                                        output.log("\n---" + fileName + "---");

                                        cls.getDeclaredMethod("main", String[].class).invoke(null, new Object[1]);
                                        // Run plugin method "main"
                                        
                                        System.out.println("\n------");


                                }

                        } catch (Exception e) {

                                e.printStackTrace();
                                e.printStackTrace(System.out);
                                System.err.print('\n');

                        }

                }

                UCL.close();
        }

}
