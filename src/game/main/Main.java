package game.main;

//Tools
import java.util.*;
import java.util.jar.*;
import java.net.*;

import game.*;
import game.gui.listeners.*;
import game.io.*;
import game.utils.*;

//io
import java.io.*;
import java.nio.charset.*;

//GUI
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * The core of the whole game, consists of core paths, starting frame, plugin loading and etc.
*/
public class Main {
    
    public static final Properties Settings     = new Properties();
    public static final Properties LangSettings = new Properties();
    
    public static final String      __VERSION__      = "1.2.8a";
    public static final File        GAME_PATH        = new File(new File("").getAbsolutePath());
    public static final File        SRC_PATH         = new File(GAME_PATH, "src");
    public static final File        CONFIGS_PATH     = new File(GAME_PATH, "configs");
    public static final File        PLUGINS_PATH     = new File(GAME_PATH, "plugins");
    public static final File        SAVES_PATH       = new File(GAME_PATH, "saves");
    public static final File        REPORT_PATH      = new File(GAME_PATH, "report");
    public static final Charset     DEF_CHARSET      = Charset.forName("UTF-8");
    public static final ClassLoader DEF_CLASS_LOADER = Main.class.getClassLoader();
    
    // Consts. & importants
    
    public static final JFrame     GameFrame   = new JFrame();
    public static final JTextArea  OutTextArea = new JTextArea();
    public static final JTextField InTextArea  = new JTextField("play");
    public static Image ICON;
    
    // gui & consts.
    
    private static final Thread SHOW_DATA_THREAD = new Thread(new ShowData(), "Show Data Thread");
    
    public static void main(String[] args) throws Throwable {
        
        PrintStream t = new PrintStream(new File(REPORT_PATH, String.format("REPORT %s.log", System.currentTimeMillis())), DEF_CHARSET);
        System.setErr(t);
        // Init Reports
        
        Init();
        LoadPlugins();
    }
    
    /**
     * Graphics init. (That`s all)
    */
    
    private static void Init() throws Exception {
    
        ICON = new ImageIcon(DEF_CLASS_LOADER.getResource("game/assets/icon.png")).getImage();
        
        Settings    .load (new InputStreamReader(new FileInputStream(new File(CONFIGS_PATH, "Main.cfg")), DEF_CHARSET));
        LangSettings.load (new InputStreamReader(DEF_CLASS_LOADER.getResourceAsStream("game/assets/lang/" + Settings.getProperty("lang") + ".lang"), DEF_CHARSET));
        // Loads icon, settings and langs
        
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
        
        SHOW_DATA_THREAD.start();
        
    }
    
    private static void LoadPlugins() throws Throwable {

        output.log("Start loading plugins");

        File[] plugins = PLUGINS_PATH.listFiles(new FileFilter() {
            public boolean accept(File f) {
                return f.isFile();
            }
        });
        // Only allows files not dirs


        JarFile[] Jars = new JarFile[plugins.length];

        for (int i = 0; i < Jars.length; i++) {
            Jars[i] = new JarFile(plugins[i]);
        }

        String[] MainClasses = new String[plugins.length];

        for (int i = 0; i < Jars.length; i ++) {
            MainClasses[i] = Jars[i].getManifest()
                .getMainAttributes()
                .getValue("Main-Class");
        }
        // This is going to be changed in the future

        URL[] URLS = new URL[plugins.length];

        for (int i = 0; i < URLS.length; i++) {
            URLS[i] = new URL("file:" + plugins[i].toString());
        }
        // Get URLS

        URLClassLoader UCL = new URLClassLoader(URLS);

        for (int i = 0; i < MainClasses.length; i ++) {
            output.log("---" + MainClasses[i].split("\\.")[0] + "---");
            UCL.loadClass(MainClasses[i])
               .getDeclaredMethod("main", String[].class)
               .invoke(null, new Object[1]);
            data.Plugins.add(plugins[i].getName().split("\\.")[0]);
        }
        output.log("----------------");
        // Load

        UCL.close();
    }
    
}
